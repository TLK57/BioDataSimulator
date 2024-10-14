import java.time.ZoneId;

public enum LieuxDeNaissance {
    TOKYO("Tokyo", ZoneId.of("Asia/Tokyo")),
    PARIS("Paris", ZoneId.of("Europe/Paris")),
    NAIROBI("Nairobi", ZoneId.of("Africa/Nairobi")),
    LOS_ANGELES("Los Angeles", ZoneId.of("America/Los_Angeles")),
    BAMAKO("Bamako", ZoneId.of("Africa/Bamako")),
    MOSCOU("Moscou", ZoneId.of("Europe/Moscow")),
    CARACAS("Caracas", ZoneId.of("America/Caracas")),
    TBILISSI("Tbilissi", ZoneId.of("Asia/Tbilisi"));

    private final String nom;
    private final ZoneId zoneId;

    LieuxDeNaissance(String nom, ZoneId zoneId) {
        this.nom = nom;
        this.zoneId = zoneId;
    }

    public String getNom() {
        return nom;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }
}