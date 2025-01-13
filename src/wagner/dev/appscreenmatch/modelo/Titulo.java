package wagner.dev.appscreenmatch.modelo;

import com.google.gson.annotations.SerializedName;
import wagner.dev.appscreenmatch.excecao.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo>{

        private String nome;
        private int anoDeLancamento;
        private int totalDeAvaliacao;
        private int duracaoEmMinutos;
        private double somaDasAvaliacoes;
        private boolean incluidoNoPlano;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Nao consegui converter o ano" +
                    "porque tem mais de 04 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));

    }

    public String getNome() {
            return nome;
        }

        public int getAnoDeLancamento() {
            return anoDeLancamento;
        }

        public int getDuracaoEmMinutos() {
            return duracaoEmMinutos;

        }

        public boolean IncluidoNoPlano() {
            return incluidoNoPlano;
        }

        public int getTotalDeAvaliacao(){
            return totalDeAvaliacao;

        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setAnoDeLancamento(int anoDeLancamento) {
            this.anoDeLancamento = anoDeLancamento;
        }

        public void setDuracaoEmMinutos(int duracaoEmMinutos) {
            this.duracaoEmMinutos = duracaoEmMinutos;
        }

        public void setIncluidoNoPlano(boolean incluidoNoPlano) {
            this.incluidoNoPlano = incluidoNoPlano;
        }

        public void exibeFichaTecnica(){
            System.out.println("Nome do filme: " + nome);
            System.out.println("Ano de Lnçamento: " + anoDeLancamento);
        }

        public void avalia(double nota) {
            somaDasAvaliacoes += nota;
            totalDeAvaliacao ++;
        }

        public double mediaAvaliacao(){
            return somaDasAvaliacoes / totalDeAvaliacao;
        }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "nome ='" + nome + '\'' +
                ", anoDeLancamento = " + anoDeLancamento + "," +
                " duração = " + duracaoEmMinutos + " Minutos";
    }
}
