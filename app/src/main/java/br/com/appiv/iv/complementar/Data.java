package br.com.appiv.iv.complementar;

public class Data {

    public Data(){}

    /*
    Verifica se o valor para data é um numero inteiro
    E tambem chama o metodo que verifica se a data quando está toda preenchida é válida
    */
    public boolean validarData(String ultimoCaracter, String data){

        switch (ultimoCaracter){

            case "0":
                if(data.length() == 5){

                    return validarData(data);
                }
                return true;
            case "1":
                if(data.length() == 5){

                    return validarData(data);
                }
                return true;
            case "2":
                if(data.length() == 5){

                    return validarData(data);
                }
                return true;
            case "3":
                if(data.length() == 5){

                    return validarData(data);
                }
                return true;
            case "4":
                if(data.length() == 5){

                    return validarData(data);
                }
                return true;
            case "5":
                if(data.length() == 5){

                    return validarData(data);
                }
                return true;
            case "6":
                if(data.length() == 5){

                    return validarData(data);
                }
                return true;
            case "7":
                if(data.length() == 5){

                    return validarData(data);
                }
                return true;
            case "8":
                if(data.length() == 5){

                    return validarData(data);
                }
                return true;
            case "9":
                if(data.length() == 5){

                    return validarData(data);
                }
                return true;
            case "/":
                return true;
            default:
                return false;
        }
    }

    //Verifica se a data quando completa está incorreta
    private boolean validarData(String data){

        String dia = data.substring(0,2);
        String mes = data.substring(3,5);
        int intDia = Integer.parseInt(dia);
        int intMes = Integer.parseInt(mes);
        if((intDia < 1 || intDia > 31) ||
                (intMes > 12 || intMes < 1)   ||
                (intDia == 30 && intMes == 2) ||
                (intDia == 31 && intMes == 2) ||
                (intDia == 31 && intMes == 4) ||
                (intDia == 31 && intMes == 6) ||
                (intDia == 31 && intMes == 9) ||
                (intDia == 31 && intMes == 11)){

            return false;
        }

        return true;
    }

    //formata data com '/'
    public String formatarData(String data,int tamanho,int cursor){

        //se count for 0 quer dizer que está apagando
        if(cursor == 0){

            return null;
        }

        String dataFormatada = data + "/";
        return dataFormatada;
    }

    /*
    Caso a validação do metodo que verifica o valor da data retornar false quer dizer que
    a data que está sendo preenchida está invlálida por tanto este método retorna false
     */
    public boolean validarPreenchimentoData(String data){

        String validacao = "";
        if(data.length()!= 0) {
            validacao += data.charAt(data.length() - 1);
            if(!validarData(validacao,data)){

                return false;
            }
        }

        return true;
    }
}
