package wagner.dev.appscreenmatch.principal;

import wagner.dev.appscreenmatch.calculo.CalculadoraDeTempo;
import wagner.dev.appscreenmatch.calculo.FiltroRecomendacao;
import wagner.dev.appscreenmatch.modelo.Episodio;
import wagner.dev.appscreenmatch.modelo.Filme;
import wagner.dev.appscreenmatch.modelo.Serie;

import java.util.ArrayList;


public class Principal {

    //  O construtor é mais um recurso para encapsular objetos.

    public static void main(String[] args) {
        Filme meuFilme = new Filme("Forest Gump", 1998);
        meuFilme.setDuracaoEmMinutos(120);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(10);
        meuFilme.avalia(7.8);
        meuFilme.avalia(6.8);
        meuFilme.avalia(7);

        System.out.println(meuFilme.getTotalDeAvaliacao());
        System.out.println(meuFilme.mediaAvaliacao());

        Serie BreakingBad = new Serie("Breaking Bad",2009 );
        BreakingBad.exibeFichaTecnica();
        BreakingBad.setTemporadas(5);
        BreakingBad.setEpisodiosPorTemporada(9);
        BreakingBad.setMinutosPorEpisodio(50);

        System.out.println("Duração para maratonar Breaking Bad: " + BreakingBad.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(BreakingBad);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(BreakingBad);
        episodio.setTotalVizualizacoes(2000);
        filtro.filtra(episodio);

        var filmeDoWagner = new Filme("Clube da Luta", 1999);
        filmeDoWagner.setDuracaoEmMinutos(180);
        filmeDoWagner.avalia(10);

        //Todas as classes são filhas de objects
        //Criando uma arraylist

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoWagner);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista " + listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());


    }
}