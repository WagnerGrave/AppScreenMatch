package wagner.dev.appscreenmatch.principal;

import wagner.dev.appscreenmatch.modelo.Filme;
import wagner.dev.appscreenmatch.modelo.Serie;
import wagner.dev.appscreenmatch.modelo.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Forest Gump", 1998);
        Serie BreakingBad = new Serie("Breaking Bad",2009 );
        Filme outroFilme = new Filme("Avatar", 2023);
        var filmeDoWagner = new Filme("Clube da Luta", 1999);

        meuFilme.avalia(10);
        outroFilme.avalia(8);
        filmeDoWagner.avalia(7);

        List<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoWagner);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(BreakingBad);

        for (Titulo item: lista){
            System.out.println(item.getNome());
            if (item instanceof Filme filme) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam");
        buscaPorArtista.add("Wagner");
        buscaPorArtista.add("Ruth");
        System.out.println(buscaPorArtista);

        //Ordenacao por ordem alfabetica usando collections e por ano usando Comparator

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }

}
