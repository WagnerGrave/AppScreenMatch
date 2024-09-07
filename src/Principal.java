import wagner.dev.appscreenmatch.calculo.CalculadoraDeTempo;
import wagner.dev.appscreenmatch.calculo.FiltroRecomendacao;
import wagner.dev.appscreenmatch.modelo.Episodio;
import wagner.dev.appscreenmatch.modelo.Filme;
import wagner.dev.appscreenmatch.modelo.Serie;

public class Principal {

    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("Forest Gump");
        meuFilme.setAnoDeLancamento(1998);
        meuFilme.setDuracaoEmMinutos(120);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(10);
        meuFilme.avalia(7.8);
        meuFilme.avalia(6.8);
        meuFilme.avalia(7);

        System.out.println(meuFilme.getTotalDeAvaliacao());
        System.out.println(meuFilme.mediaAvaliacao());

        Serie BreakingBad = new Serie();
        BreakingBad.setNome("Breaking Bad");
        BreakingBad.setAnoDeLancamento(2009);
        BreakingBad.exibeFichaTecnica();
        BreakingBad.setTemporadas(5);
        BreakingBad.setEpisodiosPorTemporada(9);
        BreakingBad.setMinutosPorEpisodio(50);

        System.out.println("Duração para maratonar Breaking Bad: " + BreakingBad.getDuracaoEmMinutos());

        Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar");
        outroFilme.setAnoDeLancamento(2023);
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

        var filmeDoWagner = new Filme();
        filmeDoWagner.setDuracaoEmMinutos(180);
        filmeDoWagner.setNome("Clube da Luta");
        filmeDoWagner.setAnoDeLancamento(1999);
        filmeDoWagner.avalia(10);

    }
}