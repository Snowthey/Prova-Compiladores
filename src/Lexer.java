import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lexer {

    public TabelaDeSimbolos objTabelaDeSimbolos = new TabelaDeSimbolos();
    public static ArrayList<ClassificacaoLexica> ArrayListAnaliseLexica = new ArrayList<>();

    boolean TokenVoid(String Lexema){
        if(Lexema.equals("void"))
            return true;
        else return false;
    }

    boolean TokenMain(String Lexema) {
        // Verifica se a string começa com "main" e termina com "()"
        if (Lexema.startsWith("main") && Lexema.endsWith("()")) {
            return true;
        } else {
            return false;
        }
    }

    boolean TokenComentario(String Lexema) {
        if (Lexema.startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }

    boolean TokenFor(String Lexema) {
        if (Lexema.equals("for")) {
            return true;
        } else {
            return false;
        }
    }

    boolean TokenCout(String Lexema){
        if(Lexema.equals("cout"))
            return true;
        else return false;
    }

    boolean TokenTipoInteiro(String Lexema){
        if(Lexema.equals("int"))
            return true;
        else return false;
    }

    boolean TokenTipoChar(String Lexema){
        if(Lexema.equals("char"))
            return true;
        else return false;
    }

    boolean TokenTipoFloat(String Lexema){
        if(Lexema.equals("float"))
            return true;
        else return false;
    }

    boolean TokenTipoPrint(String Lexema){
        if(Lexema.equals("print") || Lexema.equals("printf") || Lexema.equals("printf("))
            return true;
        else return false;
    }

    boolean TokenTipoScanF(String Lexema){
        if(Lexema.equals("scanf")|| Lexema.equals("scanf("))
            return true;
        else return false;
    }

    boolean TokenTipoAtribuicao(String Lexema){
        if(Lexema.equals("="))
            return true;
        else return false;
    }

    boolean TokenTipoPontoVirgula(String Lexema){
        if(Lexema.equals(";"))
            return true;
        else return false;
    }

    boolean TokenTipoVirgula(String Lexema){
        if(Lexema.equals(","))
            return true;
        else return false;
    }

    boolean TokenTipoPonto(String Lexema){
        if(Lexema.equals("."))
            return true;
        else return false;
    }

    boolean TokenTipoAbreChave(String Lexema){
        if(Lexema.equals("{"))
            return true;
        else return false;
    }

    boolean TokenTipoFechaChave(String Lexema){
        if(Lexema.equals("}"))
            return true;
        else return false;
    }

    boolean TokenTipoAbreParenteses(String Lexema){
        if(Lexema.equals("("))
            return true;
        else return false;
    }

    boolean TokenMenorQue(String Lexema){
        if(Lexema.equals("<"))
            return true;
        else return false;
    }

    boolean TokenTipoFechaParenteses(String Lexema){
        if(Lexema.equals(")") || Lexema.equals(");"))
            return true;
        else return false;
    }

    boolean TokenOperadorInsercao(String Lexema){
        if(Lexema.equals("=="))
            return true;
        else return false;
    }

    boolean TokenAdicao(String Lexema) {
        if (Lexema.equals("+"))
            return true;
        else return false;
    }
    boolean TokenIf(String Lexema){
        if(Lexema.equals("if(") || Lexema.equals("if"))
            return true;
        else return false;
    }
    boolean TokenElse(String Lexema){
        if(Lexema.equals("else"))
            return true;
        else return false;
    }
    boolean TokenMenorIgual(String Lexema){
        if(Lexema.equals("<="))
            return true;
        else return false;
    }

    boolean TokenOU(String Lexema){
        if(Lexema.equals("||"))
            return true;
        else return false;
    }
    boolean TokenE(String Lexema){
        if(Lexema.equals("&&"))
            return true;
        else return false;
    }

    boolean TokenReturn(String Lexema){
        if(Lexema.equals("return 1;"))
            return true;
        else return false;
    }

    boolean TokenSwitch(String Lexema){
        if(Lexema.equals("switch("))
            return true;
        else return false;
    }

    boolean TokenCase(String Lexema){
        if(Lexema.equals("case") || Lexema.equals("1:")|| Lexema.equals("2:")|| Lexema.equals("3:")|| Lexema.equals("0:"))
            return true;
        else return false;
    }

    boolean TokenStringDeFormato(String Lexema){
        if(Lexema.equals("\"%d\"") || (Lexema.equals("\"%f\"")))
            return true;
        else return false;
    }
    boolean TokenDo(String Lexema){
        if(Lexema.equals("do"))
            return true;
        else return false;
    }
    boolean TokenWhile(String Lexema){
        if(Lexema.equals("while"))
            return true;
        else return false;
    }

    boolean TokenDefault(String Lexema){
        if(Lexema.equals("default:"))
            return true;
        else return false;
    }
    boolean TokenBreak(String Lexema){
        if(Lexema.equals("break;"))
            return true;
        else return false;
    }
    boolean TokenClear(String Lexema){
        if(Lexema.equals("system(") || (Lexema.equals("\"cls\"")))
            return true;
        else return false;
    }

    boolean TokenEnderecoVariavel(String Lexema){
        if(Lexema.equals("&x);") || Lexema.equals("&n);") || Lexema.equals("&m);") || Lexema.equals("&a);") || Lexema.equals("&raio);"))
            return true;
        else return false;
    }


    boolean TokenScanF_Function(String Lexema){
        if(Lexema.equals(",&lado1);") || Lexema.equals(",&lado2);") || Lexema.equals(",&lado3);") || Lexema.equals("&opcao);"))
            return true;
        else return false;
    }

    boolean TokenForLoop(String Lexema) {
        // Removendo espaços em branco para garantir que não interfiram na comparação
        Lexema = Lexema.replaceAll("\\s+", "");

        // Verifica se a string termina com ";" ou ")"
        if (Lexema.endsWith(";") || Lexema.endsWith(")")) {
            // Dividindo a string em partes separadas
            String[] partes = Lexema.split(";");

            // Verificando se há exatamente uma parte
            if (partes.length == 1) {
                // Remove espaços em branco antes e depois da parte
                String parte = partes[0].trim();

                // Verifica se a parte contém um "="
                if (parte.contains("=")) {
                    return true;
                }
                if (parte.contains("<") || parte.contains(">")) {
                    return true;
                }
            }
        }
        // Se não passar em alguma das verificações, retorna false
        return false;
    }

    boolean TokenStringEntreAspas(String Lexema) {
        if (Lexema.startsWith("\"") && Lexema.endsWith("\"")) {
            return true;
        } else {
            return false;
        }
    }

    boolean TokenNumeroInteiro(String lexema) {
        int tamanho = lexema.length();

        // Ignorar espaços em branco
        lexema = lexema.trim();

        // Verificar se o lexema está vazio ou consiste apenas de um sinal de menos
        if (lexema.isEmpty() || (lexema.length() == 1 && lexema.charAt(0) == '-')) {
            return false;
        }

        // Verificar se o primeiro caractere é um sinal de menos
        int startIndex = 0;
        if (lexema.charAt(0) == '-') {
            startIndex = 1;
        }

        // Verificar se o último caractere é um ponto e vírgula
        int endIndex = tamanho;
        if ((lexema.charAt(tamanho - 1) == ';')|| lexema.charAt(tamanho - 1) == ')') {
            endIndex = tamanho - 1; // Ignorar o ponto e vírgula para verificar os dígitos
        }

        // Verificar se os caracteres restantes são dígitos decimais
        for (int i = startIndex; i < endIndex; i++) {
            char caractere = lexema.charAt(i);
            if (!Character.isDigit(caractere)) {
                return false; // Se não for um dígito, não é um número inteiro
            }
        }

        return true;
    }

    boolean TokenAspasDuplas(String lexema) {
        return lexema.equals("“");
    }

    boolean TokenMaiorQue(String lexema) {
        return lexema.equals(">");
    }

    boolean TokenMultiplicacao(String lexema) {
        return lexema.equals("*");
    }

    boolean TokenNumeroFlutuante(String lexema) {
        int tamanho = lexema.length();

        // Ignorar espaços em branco
        lexema = lexema.trim();

        // Verificar se o lexema está vazio ou consiste apenas de um sinal de menos
        if (lexema.isEmpty() || (lexema.length() == 1 && lexema.charAt(0) == '-')) {
            return false;
        }

        // Verificar se o primeiro caractere é um sinal de menos
        int startIndex = 0;
        if (lexema.charAt(0) == '-') {
            startIndex = 1;
        }

        // Verificar se o último caractere é um ponto e vírgula
        int endIndex = tamanho;
        if (lexema.charAt(tamanho - 1) == ';') {
            endIndex = tamanho - 1; // Ignorar o ponto e vírgula para verificar os dígitos
        }

        // Verificar se os caracteres restantes são dígitos decimais ou um único ponto
        boolean pontoEncontrado = false;
        for (int i = startIndex; i < endIndex; i++) {
            char caractere = lexema.charAt(i);
            if (!Character.isDigit(caractere)) {
                if (caractere == '.') {
                    if (pontoEncontrado) {
                        return false; // Se já encontrou um ponto anteriormente, não é um número decimal válido
                    }
                    pontoEncontrado = true;
                } else {
                    return false; // Se não for um dígito ou um ponto, não é um número decimal válido
                }
            }
        }

        return true;
    }

    boolean TokenVariavel(String lexema) {
        int tamanho = lexema.length();

        // Ignorar espaços em branco
        lexema = lexema.trim();

        // Verificar se o lexema está vazio ou se começa com um dígito
        if (lexema.isEmpty() || Character.isDigit(lexema.charAt(0))) {
            return false;
        }

        // Verificar se o lexema contém apenas caracteres alfanuméricos, sublinhados, vírgulas, ponto e vírgulas,
        // parênteses ou asteriscos
        for (int i = 0; i < tamanho; i++) {
            char caractere = lexema.charAt(i);
            if (!Character.isLetterOrDigit(caractere) && caractere != '_' && caractere != ',' && caractere != ';'
                    && caractere != '(' && caractere != '*' && caractere != ')') {
                return false; // Se o caractere não for alfanumérico, um sublinhado, uma vírgula, ponto e vírgula,
                // parêntese ou asterisco, não é um nome de variável válido
            }
        }

        return true;
    }

    boolean TokenVazio(String Lexema){
        return Lexema.trim().isEmpty();
    }


    void ClassificaLexema(String Lexema, int linha){
        if(TokenVoid(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.VOID, linha));
            return;
        }
        if(TokenMain(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.MAIN, linha));
            return;
        }
        if(TokenComentario(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.COMENTARIO, linha));
            return;
        }
        if(TokenTipoInteiro(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.INT, linha));
            return;
        }
        if(TokenTipoChar(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.CHAR, linha));
            return;
        }
        if(TokenIf(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.IF, linha));
            return;
        }
        if(TokenBreak(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.BREAK, linha));
            return;
        }
        if(TokenWhile(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.WHILE, linha));
            return;
        }
        if(TokenCase(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.CASE, linha));
            return;
        }
        if(TokenElse(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.ELSE, linha));
            return;
        }
        if(TokenMaiorQue(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.MAIORQUE, linha));
            return;
        }
        if(TokenClear(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.CLEAR, linha));
            return;
        }
        if(TokenReturn(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.RETURN, linha));
            return;
        }
        if(TokenSwitch(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.SWITCH, linha));
            return;
        }
        if(TokenDefault(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.DEFAULT, linha));
            return;
        }
        if(TokenMenorIgual(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.MENOR_IGUAL, linha));
            return;
        }
        if(TokenTipoFloat(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.FLOAT, linha));
            return;
        }
        if(TokenAspasDuplas(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.ASPASDUPLAS, linha));
            return;
        }
        if(TokenMenorQue(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.MENORQUE, linha));
            return;
        }
        if(TokenTipoPrint(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.PRINT, linha));
            return;
        }
        if(TokenStringDeFormato(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.STRING_DE_FORMATO, linha));
            return;
        }
        if(TokenEnderecoVariavel(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.ENDERECO_VARIAVEL, linha));
            return;
        }
        if(TokenScanF_Function(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.SCANF_FUNCTION, linha));
            return;
        }
        if(TokenMultiplicacao(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.MULTIPLICACAO, linha));
            return;
        }
        if(TokenStringEntreAspas(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.STRING, linha));
            return;
        }
        if(TokenTipoScanF(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.SCANF, linha));
            return;
        }
        if(TokenE(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.E, linha));
            return;
        }
        if(TokenOU(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.OU, linha));
            return;
        }

        if(TokenTipoAtribuicao(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.ATRIBUICAO, linha));
            return;
        }
        if(TokenTipoPontoVirgula(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.PONTO_VIRGULA, linha));
            return;
        }
        if(TokenTipoPonto(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.PONTO, linha));
            return;
        }
        if(TokenTipoVirgula(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.VIRGULA, linha));
            return;
        }
        if(TokenVazio(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.VAZIO, linha));
            return;
        }
        if(TokenFor(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.FOR, linha));
            return;
        }
        if(TokenTipoAbreChave(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.ABRE_CHAVE, linha));
            return;
        }
        if(TokenTipoFechaChave(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.FECHA_CHAVE, linha));
            return;
        }
        if(TokenOperadorInsercao(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.OPERADOR_INSERCAO, linha));
            return;
        }
        if(TokenForLoop(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.FORLOOP, linha));
            return;
        }
        if(TokenTipoAbreParenteses(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.ABRE_PARENTESES, linha));
            return;
        }
        if(TokenTipoFechaParenteses(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.FECHA_PARENTESES, linha));
            return;
        }
        if(TokenCout(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.COUT, linha));
            return;
        }
        if(TokenAdicao(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.ADICAO, linha));
            return;
        }
        if(TokenNumeroInteiro(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.NUMERO_INTEIRO, linha));
            return;
        }
        if(TokenDo(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.DO, linha));
            return;
        }
        if(TokenNumeroFlutuante(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.NUMERO_DECIMAL, linha));
            return;
        }
        if(TokenVariavel(Lexema)){
            ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.VARIAVEL, linha));

            return;
        }

        ArrayListAnaliseLexica.add(new ClassificacaoLexica(Lexema, Token.ERRO_DESCONHECIDO, linha));
        return;
    }


    void GerarTabelaDeSimbolos(){

        objTabelaDeSimbolos.adcionarSimbolo(Token.VOID,"COMANDO VOID");
        objTabelaDeSimbolos.adcionarSimbolo(Token.MAIN,"COMANDO MAIN");
        objTabelaDeSimbolos.adcionarSimbolo(Token.INT,"TIPO INT");
        objTabelaDeSimbolos.adcionarSimbolo(Token.FLOAT,"TIPO FLOAT");
        objTabelaDeSimbolos.adcionarSimbolo(Token.PRINT,"COMANDO PRINT");
        objTabelaDeSimbolos.adcionarSimbolo(Token.SCANF,"SCANF");
        objTabelaDeSimbolos.adcionarSimbolo(Token.ATRIBUICAO,"ATRIBUICAO");
        objTabelaDeSimbolos.adcionarSimbolo(Token.PONTO_VIRGULA,"PONTO_VIRGULA");
        objTabelaDeSimbolos.adcionarSimbolo(Token.ABRE_CHAVE,"ABRE_CHAVE");
        objTabelaDeSimbolos.adcionarSimbolo(Token.FECHA_CHAVE,"FECHA_CHAVE");
        objTabelaDeSimbolos.adcionarSimbolo(Token.ABRE_PARENTESES,"ABRE_PARENTESES");
        objTabelaDeSimbolos.adcionarSimbolo(Token.FECHA_PARENTESES,"FECHA_PARENTESES");
        objTabelaDeSimbolos.adcionarSimbolo(Token.ADICAO,"ADICAO");
        objTabelaDeSimbolos.adcionarSimbolo(Token.VIRGULA,"VIRGULA");
        objTabelaDeSimbolos.adcionarSimbolo(Token.NUMERO_INTEIRO,"NUMERO_INTEIRO");
        objTabelaDeSimbolos.adcionarSimbolo(Token.VARIAVEL,"VARIAVEL");
        objTabelaDeSimbolos.adcionarSimbolo(Token.CHAR,"TIPO CHAR");
        objTabelaDeSimbolos.adcionarSimbolo(Token.NUMERO_DECIMAL, "NUMERO_DECIMAL");
        objTabelaDeSimbolos.adcionarSimbolo(Token.ERRO_DESCONHECIDO,"*** ERRO DESCONHECIDO ***");
        objTabelaDeSimbolos.adcionarSimbolo(Token.FOR, "FOR");
        objTabelaDeSimbolos.adcionarSimbolo(Token.FORLOOP, "FOR_LOOP");
        objTabelaDeSimbolos.adcionarSimbolo(Token.COUT, "COUT");
        objTabelaDeSimbolos.adcionarSimbolo(Token.OPERADOR_INSERCAO, "OPERADOR INSERCAO");
        objTabelaDeSimbolos.adcionarSimbolo(Token.STRING, "STRING");
        objTabelaDeSimbolos.adcionarSimbolo(Token.VAZIO, "VAZIO");
        objTabelaDeSimbolos.adcionarSimbolo(Token.ASPASDUPLAS, "ASPAS_DUPLAS");
        objTabelaDeSimbolos.adcionarSimbolo(Token.ELSE, "ELSE");
        objTabelaDeSimbolos.adcionarSimbolo(Token.IF, "IF");
        objTabelaDeSimbolos.adcionarSimbolo(Token.MAIORQUE, "MAIOR_QUE");
        objTabelaDeSimbolos.adcionarSimbolo(Token.MULTIPLICACAO, "MULTIPLICACAO");
        objTabelaDeSimbolos.adcionarSimbolo(Token.SCANF_FUNCTION, "SCANF_FUNCTION");
        objTabelaDeSimbolos.adcionarSimbolo(Token.STRING_DE_FORMATO, "STRING_DE_FORMATO");
        objTabelaDeSimbolos.adcionarSimbolo(Token.ENDERECO_VARIAVEL, "ENDERECO_VARIAVEL");
        objTabelaDeSimbolos.adcionarSimbolo(Token.OU, "OU");
        objTabelaDeSimbolos.adcionarSimbolo(Token.E,"E");
        objTabelaDeSimbolos.adcionarSimbolo(Token.MENORQUE, "MENOR_QUE");
        objTabelaDeSimbolos.adcionarSimbolo(Token.COMENTARIO, "COMENTARIO");
        objTabelaDeSimbolos.adcionarSimbolo(Token.RETURN, "RETURN");
        objTabelaDeSimbolos.adcionarSimbolo(Token.MENOR_IGUAL, "MENOR QUE");
        objTabelaDeSimbolos.adcionarSimbolo(Token.DO, "DO");
        objTabelaDeSimbolos.adcionarSimbolo(Token.SWITCH, "SWITCH");
        objTabelaDeSimbolos.adcionarSimbolo(Token.CASE, "CASE");
        objTabelaDeSimbolos.adcionarSimbolo(Token.BREAK, "BREAK");
        objTabelaDeSimbolos.adcionarSimbolo(Token.DEFAULT, "DEFAULT");
        objTabelaDeSimbolos.adcionarSimbolo(Token.CLEAR, "CLEAR");
        objTabelaDeSimbolos.adcionarSimbolo(Token.WHILE, "WHILE");


    }

    String[] TratamentoLexemas(String[] ConjuntoLexemas) {
        StringBuilder texto = new StringBuilder();

        for (String lexema : ConjuntoLexemas) {
            texto.append(lexema).append(" ");
        }

        ArrayList<String> NovosLexemas = new ArrayList<>();

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|//.*$|return\\s+1;");
        Matcher matcher = pattern.matcher(texto.toString());

        int posicaoAnterior = 0;
        while (matcher.find()) {
            int posicaoAtual = matcher.start();
            if (posicaoAtual > posicaoAnterior) {
                String lexemaExterno = texto.substring(posicaoAnterior, posicaoAtual).trim();
                String[] palavras = lexemaExterno.split("\\s+");
                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        NovosLexemas.add(palavra);
                    }
                }
            }
            String lexemaString = matcher.group(0).trim();
            if (!lexemaString.isEmpty()) {
                NovosLexemas.add(lexemaString);
            }
            posicaoAnterior = matcher.end();
        }

        // Adicionar o restante do texto, se houver
        if (posicaoAnterior < texto.length()) {
            String lexemaExterno = texto.substring(posicaoAnterior).trim();
            String[] palavras = lexemaExterno.split("\\s+");
            for (String palavra : palavras) {
                if (!palavra.isEmpty()) {
                    NovosLexemas.add(palavra);
                }
            }
        }

        // Converter ArrayList de volta para array
        String[] NovoConjuntoLexemas = NovosLexemas.toArray(new String[0]);

        return NovoConjuntoLexemas;
    }

    boolean GerarAnaliseLexica(){

        boolean ResultadoAnaliseLexica = true;

        for(ClassificacaoLexica obj : ArrayListAnaliseLexica){
            String Lexema = obj.Lexema;
            int Linha = obj.Linha;
            int CodigoToken = obj.Token;
            String Simbolo = objTabelaDeSimbolos.buscarValor(CodigoToken);

            if(obj.Token == Token.ERRO_DESCONHECIDO){
                ResultadoAnaliseLexica = false;
            }

            System.out.println("Linha: " + Linha + " - Lexema: " + Lexema + " simbolo: " + objTabelaDeSimbolos.buscarValor(CodigoToken) + " Token: " + CodigoToken);
        }
        return ResultadoAnaliseLexica;
    }

    boolean AnalisadorLexico(File selectedFile) throws FileNotFoundException
    {
        //Criar Tabela de Simbolos
        GerarTabelaDeSimbolos();

        //Abrir o arquivo selecionado
        Scanner LeituraArquivo = new Scanner(selectedFile);
        String TextoArquivoAnalisado;

        System.out.println("\n\n ********** ANALISE LEXICA ********** \n\n");

        //começar a leitura de cada uma das linhas
        int linha = 1;
        while(LeituraArquivo.hasNextLine())
        {
            TextoArquivoAnalisado = LeituraArquivo.nextLine();

            //Dividindo a string usando espaços em branco como delimitador
            String[] ConjuntoLexemas = TextoArquivoAnalisado.split("\\s+");


            ConjuntoLexemas = TratamentoLexemas(ConjuntoLexemas);


            // Classificar os lexemas da linha lida do arquivo
            for (String lexema : ConjuntoLexemas) {
                ClassificaLexema(lexema, linha);
            }

            linha++; //incrementar a linha

        }

        //fechar a leitura do arquivo
        LeituraArquivo.close();

        //Mostrar a análise lexica na tela e gerar um arquivo com a classificacao dos lexemas
        return GerarAnaliseLexica();

    }



}
