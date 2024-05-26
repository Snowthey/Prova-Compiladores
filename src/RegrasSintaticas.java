import java.util.ArrayList;

public class RegrasSintaticas {

    boolean INICIO(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        if ((VetorAnaliseLexica.get(0).Token == Token.INT) && (VetorAnaliseLexica.get(1).Token == Token.MAIN)) {
            return true;
        } else {
            return false;
        }
    }

    boolean ABRE_CHAVE(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        if(VetorAnaliseLexica.get(0).Token == Token.ABRE_CHAVE) return true;
        else {
            return false;
        }
    }

    boolean FECHA_CHAVE(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        if(VetorAnaliseLexica.get(0).Token == Token.FECHA_CHAVE) return true;
        else {
            return false;
        }
    }

    boolean CLEAR(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        if(VetorAnaliseLexica.get(0).Token == Token.CLEAR) return true;
        else {
            return false;
        }
    }

    boolean DO(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        if(VetorAnaliseLexica.get(0).Token == Token.DO)
            return true;
        else {
            return false;
        }
    }


    boolean DECLARACAO_VARIAVEL(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        int tamanho = VetorAnaliseLexica.size();

        // Verificar se o tamanho mínimo é respeitado
        if(tamanho < 2)
            return false;

        // Verificar se é uma declaração de variável válida
        if(((VetorAnaliseLexica.get(0).Token == Token.INT) && (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL))){
            return true;
        }

        if((VetorAnaliseLexica.get(0).Token == Token.CHAR) && (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(2).Token == Token.PONTO_VIRGULA)){
            return true;
        }

        if((VetorAnaliseLexica.get(0).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(1).Token == Token.ATRIBUICAO) && (VetorAnaliseLexica.get(2).Token == Token.VARIAVEL)
                && (VetorAnaliseLexica.get(3).Token == Token.MULTIPLICACAO) && (VetorAnaliseLexica.get(4).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(5).Token == Token.VARIAVEL)){
            return true;
        }

        if((VetorAnaliseLexica.get(0).Token == Token.INT) && (VetorAnaliseLexica.get(1).Token == Token.MATRIZ)){
            return true;
        }

        if((VetorAnaliseLexica.get(0).Token == Token.FLOAT) && (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL) || (VetorAnaliseLexica.get(0).Token == Token.FLOAT) && (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL)
                && (VetorAnaliseLexica.get(2).Token == Token.ATRIBUICAO) && (VetorAnaliseLexica.get(3).Token == Token.NUMERO_DECIMAL)) {
            return true;
        }

        if((VetorAnaliseLexica.get(0).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(1).Token == Token.ATRIBUICAO) && (VetorAnaliseLexica.get(2).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(3).Token == Token.MULTIPLICACAO)
                && (VetorAnaliseLexica.get(4).Token == Token.VARIAVEL)) {
            return true;
        }

        if((VetorAnaliseLexica.get(0).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(1).Token == Token.ATRIBUICAO) && (VetorAnaliseLexica.get(2).Token == Token.NUMERO_DECIMAL)) {
            return true;
        }

        if((VetorAnaliseLexica.get(0).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(1).Token == Token.ATRIBUICAO) && (VetorAnaliseLexica.get(2).Token == Token.NUMERO_DECIMAL) && (VetorAnaliseLexica.get(3).Token == Token.MULTIPLICACAO)
                && (VetorAnaliseLexica.get(4).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(5).Token == Token.MULTIPLICACAO) && (VetorAnaliseLexica.get(6).Token == Token.VARIAVEL)) {
            return true;
        }

        else return false;


    }


    boolean COMANDO_FOR(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){
        int tamanho = VetorAnaliseLexica.size();
        if(tamanho < 4)
            return false;

        if ((VetorAnaliseLexica.get(0).Token == Token.FOR) && (VetorAnaliseLexica.get(1).Token == Token.FORLOOP) &&
                (VetorAnaliseLexica.get(2).Token == Token.FORLOOP) && (VetorAnaliseLexica.get(3).Token == Token.FORLOOP)){
            return true;
        } else
            return false;
    }

    boolean PRINTLN(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){

        if ((VetorAnaliseLexica.get(0).Token == Token.PRINT) && (VetorAnaliseLexica.get(1).Token == Token.ABRE_PARENTESES &&
                (VetorAnaliseLexica.get(2).Token == Token.STRING) && (VetorAnaliseLexica.get(3).Token == Token.FECHA_PARENTESES))){
            return true;
        }
        if ((VetorAnaliseLexica.get(0).Token == Token.PRINT) && (VetorAnaliseLexica.get(1).Token == Token.STRING &&
                (VetorAnaliseLexica.get(2).Token == Token.VARIAVEL))){
            return true;
        }
        if ((VetorAnaliseLexica.get(0).Token == Token.PRINT) && (VetorAnaliseLexica.get(1).Token == Token.STRING &&
                (VetorAnaliseLexica.get(2).Token == Token.FECHA_PARENTESES))){
            return true;
        }
        if ((VetorAnaliseLexica.get(0).Token == Token.PRINT) && (VetorAnaliseLexica.get(1).Token == Token.STRING_DE_FORMATO &&
                (VetorAnaliseLexica.get(2).Token == Token.MATRIZ))){
            return true;
        }
        if ((VetorAnaliseLexica.get(0).Token == Token.PRINT) && (VetorAnaliseLexica.get(1).Token == Token.PULA_LINHA &&
                (VetorAnaliseLexica.get(2).Token == Token.FECHA_PARENTESES))){
            return true;
        }
        if ((VetorAnaliseLexica.get(0).Token == Token.PRINT) && (VetorAnaliseLexica.get(1).Token == Token.STRING &&
                (VetorAnaliseLexica.get(2).Token == Token.VIRGULA) && (VetorAnaliseLexica.get(3).Token == Token.VARIAVEL))){
            return true;
        } else
            return false;
    }

    boolean SCANF(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {


        if ((VetorAnaliseLexica.get(0).Token == Token.SCANF) && (VetorAnaliseLexica.get(1).Token == Token.ABRE_PARENTESES) ||
                (VetorAnaliseLexica.get(0).Token == Token.STRING_DE_FORMATO)  && (VetorAnaliseLexica.get(1).Token == Token.SCANF_FUNCTION)) {

            return true;
        }

        if ((VetorAnaliseLexica.get(0).Token == Token.SCANF) && (VetorAnaliseLexica.get(1).Token == Token.STRING_DE_FORMATO) ||
                (VetorAnaliseLexica.get(0).Token == Token.SCANF_FUNCTION)) {

            return true;
        }
        return false;
    }

    boolean COMENTARIO(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {


        if ((VetorAnaliseLexica.get(0).Token == Token.COMENTARIO)) {

            return true;
        }
        return false;
    }

    boolean SWITCH(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {

        if ((VetorAnaliseLexica.get(0).Token == Token.SWITCH)) {
            return true;
        }
        return false;
    }

    boolean CASE(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {

        if ((VetorAnaliseLexica.get(0).Token == Token.CASE)) {
            return true;
        }
        return false;
    }
    boolean BREAK(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {

        if ((VetorAnaliseLexica.get(0).Token == Token.BREAK)) {
            return true;
        }
        return false;
    }

    boolean DEFAULT(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {

        if ((VetorAnaliseLexica.get(0).Token == Token.DEFAULT)) {
            return true;
        }
        return false;
    }

    boolean WHILE(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {

        if ((VetorAnaliseLexica.get(0).Token == Token.WHILE) && (VetorAnaliseLexica.get(1).Token == Token.ABRE_PARENTESES) && (VetorAnaliseLexica.get(2).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(3).Token == Token.MAIORQUE) &&
                (VetorAnaliseLexica.get(4).Token == Token.NUMERO_INTEIRO) && (VetorAnaliseLexica.get(5).Token == Token.E) && (VetorAnaliseLexica.get(6).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(7).Token == Token.MENORQUE) &&
                (VetorAnaliseLexica.get(8).Token == Token.NUMERO_INTEIRO) && (VetorAnaliseLexica.get(9).Token == Token.FECHA_PARENTESES)) {
            return true;
        }
        return false;
    }

    boolean IF(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {

        if ((VetorAnaliseLexica.get(0).Token == Token.IF) &&
                (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(2).Token == Token.MENORQUE)  && (VetorAnaliseLexica.get(3).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(4).Token == Token.ADICAO) && (VetorAnaliseLexica.get(5).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(6).Token == Token.E) &&
                (VetorAnaliseLexica.get(7).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(8).Token == Token.MENORQUE)  && (VetorAnaliseLexica.get(9).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(10).Token == Token.ADICAO) && (VetorAnaliseLexica.get(11).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(12).Token == Token.E) &&
                (VetorAnaliseLexica.get(13).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(14).Token == Token.MENORQUE)  && (VetorAnaliseLexica.get(15).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(16).Token == Token.ADICAO) && (VetorAnaliseLexica.get(17).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(18).Token == Token.FECHA_PARENTESES)
                && (VetorAnaliseLexica.get(19).Token == Token.ABRE_CHAVE)) {
            return true;
        }
        if ((VetorAnaliseLexica.get(0).Token == Token.IF) &&
                (VetorAnaliseLexica.get(1).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(2).Token == Token.OPERADOR_INSERCAO)  && (VetorAnaliseLexica.get(3).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(4).Token == Token.E) &&
                (VetorAnaliseLexica.get(5).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(6).Token == Token.OPERADOR_INSERCAO)  && (VetorAnaliseLexica.get(7).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(8).Token == Token.E) &&
                (VetorAnaliseLexica.get(9).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(10).Token == Token.OPERADOR_INSERCAO)  && (VetorAnaliseLexica.get(11).Token == Token.VARIAVEL)) {
            return true;
        }

        return false;
    }

    boolean ELSEIF(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {
        if ((VetorAnaliseLexica.get(0).Token == Token.ELSE) && (VetorAnaliseLexica.get(1).Token == Token.IF) && (VetorAnaliseLexica.get(2).Token == Token.ABRE_PARENTESES)  &&
                (VetorAnaliseLexica.get(3).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(4).Token == Token.OPERADOR_INSERCAO) && (VetorAnaliseLexica.get(5).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(6).Token == Token.OU) &&
                (VetorAnaliseLexica.get(7).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(8).Token == Token.OPERADOR_INSERCAO) && (VetorAnaliseLexica.get(9).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(10).Token == Token.OU) &&
                (VetorAnaliseLexica.get(11).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(12).Token == Token.OPERADOR_INSERCAO) && (VetorAnaliseLexica.get(13).Token == Token.VARIAVEL) && (VetorAnaliseLexica.get(14).Token == Token.FECHA_PARENTESES)) {
            return true;
        }
        else return false;
    }

    boolean ELSE(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {


        if ((VetorAnaliseLexica.get(0).Token == Token.ELSE) && (VetorAnaliseLexica.get(1).Token == Token.PRINT) && (VetorAnaliseLexica.get(2).Token == Token.ABRE_PARENTESES) &&
                (VetorAnaliseLexica.get(3).Token == Token.STRING)  && (VetorAnaliseLexica.get(4).Token == Token.FECHA_PARENTESES)) {
            return true;
        }
        if ((VetorAnaliseLexica.get(0).Token == Token.ELSE) && (VetorAnaliseLexica.get(1).Token == Token.PRINT) && (VetorAnaliseLexica.get(2).Token == Token.ABRE_PARENTESES) &&
                (VetorAnaliseLexica.get(3).Token == Token.STRING)  && (VetorAnaliseLexica.get(4).Token == Token.VARIAVEL)) {
            return true;
        }
        return false;
    }

    boolean RETURN(ArrayList<ClassificacaoLexica> VetorAnaliseLexica) {


        if ((VetorAnaliseLexica.get(0).Token == Token.RETURN)) {
            return true;
        }

        return false;
    }


    boolean PROGRAMA(ArrayList<ClassificacaoLexica> VetorAnaliseLexica){
        if(INICIO(VetorAnaliseLexica) == true){
            System.out.print("INICIO - ");
            return true;
        }
        if(DECLARACAO_VARIAVEL(VetorAnaliseLexica) == true){
            System.out.print("DECLARACAO_VARIAVEL - ");
            return true;
        }

        if(COMANDO_FOR(VetorAnaliseLexica) == true){
            System.out.print("COMANDO_FOR - ");
            return true;
        }
        if(CASE(VetorAnaliseLexica) == true){
            System.out.print("CASE - ");
            return true;
        }
        if(BREAK(VetorAnaliseLexica) == true){
            System.out.print("BREAK - ");
            return true;
        }
        if(WHILE(VetorAnaliseLexica) == true){
            System.out.print("WHILE - ");
            return true;
        }
        if(DEFAULT(VetorAnaliseLexica) == true){
            System.out.print("DEFAULT - ");
            return true;
        }
        if(DO(VetorAnaliseLexica) == true){
            System.out.print("DO - ");
            return true;
        }
        if(CLEAR(VetorAnaliseLexica) == true){
            System.out.print("CLEAR - ");
            return true;
        }
        if(ABRE_CHAVE(VetorAnaliseLexica) == true){
            System.out.print("ABRE_CHAVE - ");
            return true;
        }
        if(SCANF(VetorAnaliseLexica) == true){
            System.out.print("SCANF - ");
            return true;
        }
        if(PRINTLN(VetorAnaliseLexica) == true){
            System.out.print("PRINT - ");
            return true;
        }
        if(FECHA_CHAVE(VetorAnaliseLexica) == true){
            System.out.print("FECHA_CHAVE - ");
            return true;
        }
        if(IF(VetorAnaliseLexica) == true){
            System.out.print("IF - ");
            return true;
        }
        if(ELSE(VetorAnaliseLexica) == true){
            System.out.print("ELSE - ");
            return true;
        }
        if(COMENTARIO(VetorAnaliseLexica) == true){
            System.out.print("COMENTARIO - ");
            return true;
        }
        if(SWITCH(VetorAnaliseLexica) == true){
            System.out.print("SWITCH - ");
            return true;
        }
        if(RETURN(VetorAnaliseLexica) == true){
            System.out.print("RETURN - ");
            return true;
        }
        if(ELSEIF(VetorAnaliseLexica) == true){
            System.out.print("ELSE IF - ");
            return true;
        }

        else return false;
    }



}
