package utilities;

public enum Infrastructure {
    FABRIC("Фабрика"),
    RESTAURANT("Ресторан"),
    CANTEEN("Столовая"),
    RICHMAN_HOUSE("Дом богача");

    private final String name;

    Infrastructure(String name) {
        this.name = name;
    }

    public String translate() {
        return this.name;
    }
}
