import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IndividuUtils {
    private static final Random random = new Random(); // Instance de Random pour générer des valeurs aléatoires

    // Méthode pour créer un individu avec des attributs aléatoires
    public static Individu createIndividu() {
        int taille = random.nextInt(100) + 150; // Taille aléatoire entre 150 et 250 cm
        LieuxDeNaissance lieuDeNaissance = LieuxDeNaissance.values()[random.nextInt(LieuxDeNaissance.values().length)]; // Choix aléatoire d'un lieu de naissance parmi les valeurs définies

        // Création d'une date de naissance aléatoire entre 1990 et 2005
        LocalDateTime localDateTime = LocalDateTime.of(
                random.nextInt(16) + 1990, // Année aléatoire entre 1990 et 2005
                random.nextInt(12) + 1,    // Mois aléatoire entre 1 et 12
                random.nextInt(28) + 1,     // Jour aléatoire entre 1 et 28 (pour éviter les erreurs de date)
                random.nextInt(24),         // Heure aléatoire entre 0 et 23
                random.nextInt(60),         // Minute aléatoire entre 0 et 59
                random.nextInt(60)          // Seconde aléatoire entre 0 et 59
        );

        // Conversion de LocalDateTime en ZonedDateTime en utilisant le fuseau horaire du lieu de naissance
        ZonedDateTime dateDeNaissance = ZonedDateTime.of(localDateTime, lieuDeNaissance.getZoneId());

        // Création d'une liste de hobbies
        List<Hobbys> hobbys = new ArrayList<>();
        int nbHobbys = random.nextInt(5) + 1; // Nombre aléatoire de hobbies entre 1 et 5
        for (int i = 0; i < nbHobbys; i++) {
            // Ajout d'un hobby aléatoire à la liste des hobbies
            hobbys.add(Hobbys.values()[random.nextInt(Hobbys.values().length)]);
        }

        // Retourne un nouvel individu avec les attributs générés
        return new Individu(taille, dateDeNaissance, lieuDeNaissance, hobbys);
    }

    // Méthode pour créer une liste d'individus
    public static List<Individu> createIndividus(int n) {
        List<Individu> individus = new ArrayList<>(); // Liste pour stocker les individus
        for (int i = 0; i < n; i++) {
            individus.add(createIndividu()); // Ajoute un individu généré à la liste
        }
        return individus; // Retourne la liste d'individus
    }
}
