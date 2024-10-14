import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Individu {
    // Attributs de la classe Individu
    private final int taille;  // Taille de l'individu en centimètres
    private final ZonedDateTime dateDeNaissance;  // Date de naissance de l'individu
    private final LieuxDeNaissance lieuDeNaissance;  // Lieu de naissance de l'individu
    private final List<Hobbys> hobbys;  // Liste des hobbies de l'individu

    // Constructeur de la classe Individu
    public Individu(int taille, ZonedDateTime dateDeNaissance, LieuxDeNaissance lieuDeNaissance, List<Hobbys> hobbys) {
        this.taille = taille;  // Initialisation de la taille
        this.dateDeNaissance = dateDeNaissance;  // Initialisation de la date de naissance
        this.lieuDeNaissance = lieuDeNaissance;  // Initialisation du lieu de naissance
        this.hobbys = hobbys;  // Initialisation de la liste de hobbies
    }

    // Méthode pour obtenir la taille de l'individu
    public int getTaille() {
        return taille;
    }

    // Méthode pour obtenir la date de naissance de l'individu
    public ZonedDateTime getDateDeNaissance() {
        return dateDeNaissance;
    }

    // Méthode pour obtenir le lieu de naissance de l'individu
    public LieuxDeNaissance getLieuDeNaissance() {
        return lieuDeNaissance;
    }

    // Méthode pour obtenir la liste des hobbies de l'individu
    public List<Hobbys> getHobbys() {
        return hobbys;
    }

    // Méthode pour retourner une représentation sous forme de chaîne de caractères de l'individu
    @Override
    public String toString() {
        return "Né le " + dateDeNaissance.toLocalDate() +
                " à " + lieuDeNaissance.getNom() +
                ", mesure " + taille + "cm, aime " +
                hobbys.stream().map(Enum::name).collect(Collectors.joining(", "));
    }
}
