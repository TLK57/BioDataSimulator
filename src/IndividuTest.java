import org.junit.Test;

import java.time.Month;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IndividuTest {
    // Test pour afficher tous les individus nés en mars 2000
    @Test
    public void test1() {
        List<Individu> individus = IndividuUtils.createIndividus(100); // création de 100 individus
        individus.stream()
                .filter(individu -> individu.getDateDeNaissance().getYear() == 2000 && individu.getDateDeNaissance().getMonthValue() == 3) // on filtre pour mars 2000
                .forEach(System.out::println); // affiche les individus qui correspond
    }

    // Test pour afficher les 5 premiers individus nés en juillet 1993
    @Test
    public void test2() {
        List<Individu> individus = IndividuUtils.createIndividus(100); // création de 100 individus
        individus.stream()
                .filter(individu -> individu.getDateDeNaissance().getYear() == 1993 && individu.getDateDeNaissance().getMonthValue() == 7) // filtre pour juillet 1993
                .limit(5) // limite le résultat à 5 individus
                .forEach(System.out::println); // affiche les individus correspondants
    }

    // Test pour compter le nombre total d'individus nés en 1994
    @Test
    public void test3() {
        List<Individu> individus = IndividuUtils.createIndividus(100); // création de 100 individus
        long count = individus.stream()
                .filter(individu -> individu.getDateDeNaissance().getYear() == 1994) // filtre pour l'année 1994
                .count(); // compte le nombre d'individus correspondants
        System.out.println("Nombre total d'individus nés en 1994: " + count); // affiche le résultat
    }

    // Test pour afficher les 5 plus grands individus nés en décembre 2001, triés par taille décroissante
    @Test
    public void test4() {
        List<Individu> individus = IndividuUtils.createIndividus(100); // création de 100 individus
        individus.stream()
                .filter(individu -> individu.getDateDeNaissance().getYear() == 2001 && individu.getDateDeNaissance().getMonthValue() == 12) // filtre pour décembre 2001
                .sorted((i1, i2) -> Integer.compare(i2.getTaille(), i1.getTaille())) // trie par taille décroissante
                .limit(5) // limite le résultat à 5 individus
                .forEach(System.out::println); // affiche les individus correspondants
    }

    // Test pour afficher les 5 plus petits individus nés en 2002 ayant une taille d'au moins 180 cm, triés par taille croissante
    @Test
    public void test5() {
        List<Individu> individus = IndividuUtils.createIndividus(100); // Création de 100 individus
        individus.stream()
                .filter(individu -> individu.getDateDeNaissance().getYear() == 2002 && individu.getTaille() >= 180) // filtre pour 2002 et taille >= 180 cm
                .sorted((i1, i2) -> Integer.compare(i1.getTaille(), i2.getTaille())) // trie par taille croissante
                .limit(5) // limite le résultat à 5 individus
                .forEach(System.out::println); // affiche les individus correspondants
    }

    // Test pour afficher les 5 plus grands individus nés en 2002 ayant une taille d'au moins 180 cm, triés par taille décroissante
    @Test
    public void test6() {
        List<Individu> individus = IndividuUtils.createIndividus(100); // création de 100 individus
        individus.stream()
                .filter(individu -> individu.getDateDeNaissance().getYear() == 2002 && individu.getTaille() >= 180) // filtre pour 2002 et taille >= 180 cm
                .sorted((i1, i2) -> Integer.compare(i2.getTaille(), i1.getTaille())) // trie par taille décroissante
                .limit(5) // limite le résultat à 5 individus
                .forEach(System.out::println); // affiche les individus correspondants
    }

    // Test pour récupérer les hobbies des 5 plus grands individus nés en 1999, triés par taille décroissante
    @Test
    public void test7() {
        List<Individu> individus = IndividuUtils.createIndividus(100); // création de 100 individus
        Set<Hobbys> hobbys = individus.stream()
                .filter(individu -> individu.getDateDeNaissance().getYear() == 1999) // filtre pour l'année 1999
                .sorted((i1, i2) -> Integer.compare(i2.getTaille(), i1.getTaille())) // trie par taille décroissante
                .limit(5) // limite le résultat à 5 individus
                .flatMap(individu -> individu.getHobbys().stream()) // récupère les hobbies de chaque individu
                .collect(Collectors.toSet()); // collecte les hobbies dans un ensemble (pour éviter les doublons)
        System.out.println("Hobbys des 5 plus grands individus nés en 1999: " + hobbys); // affiche les hobbies
    }

    // Test pour récupérer les mois de naissance des 20 plus grands individus nés en 1997, triés par taille décroissante
    @Test
    public void test8() {
        List<Individu> individus = IndividuUtils.createIndividus(100); // création de 100 individus
        Set<Month> moisDeNaissance = individus.stream()
                .filter(individu -> individu.getDateDeNaissance().getYear() == 1997) // filtre pour l'année 1997
                .sorted((i1, i2) -> Integer.compare(i2.getTaille(), i1.getTaille())) // trie par taille décroissante
                .limit(20) // limite le résultat à 20 individus
                .map(individu -> individu.getDateDeNaissance().getMonth()) // reccupere le mois de naissance de chaque individu
                .collect(Collectors.toSet()); // collecte les mois dans un ensemble (pour éviter les doublons)
        System.out.println("Mois de naissance des 20 plus grands individus nés en 1997: " + moisDeNaissance); // affiche les mois
    }
}
