package utilities;

public enum Job {
    WORKER("Рабочий"),
    LAUNDRESS("Прачка"),
    PORTER("Швейцар"),
    COOK("Повар"),
    NONE("Нет");

    private final String name;

    Job(String name) {
        this.name = name;
    }

    public String translate() {
        return this.name;
    }
}
