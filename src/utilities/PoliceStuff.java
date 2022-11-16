package utilities;

public enum PoliceStuff {
    COAT("Мундир"),
    HELMET("Каска"),
    PISTOL("Пистолет"),
    RIFLE("Ружье");

    private final String name;

    PoliceStuff(String name) {
        this.name = name;
    }

    public String translate() {
        return name;
    }
}
