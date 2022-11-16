package entities;

import utilities.Facility;
import utilities.Infrastructure;

import java.util.Objects;

public class Manufacture implements Facility {
    private final String name;
    private boolean isThereUnemployed = true;
    private Infrastructure type;
    public boolean needMoreProduct = false;

    public Manufacture(String name) {
        this.name = name;
        System.out.println("Создана фабрика " + name);
    }

    public String getName() {
        return this.name;
    }

    public void setType(Infrastructure type) {
        this.type = type;
    }

    @Override
    public void hireWorkers() {
        isThereUnemployed = false;
        System.out.println("Фабрика " + this.name + " нанимает рабочих. Становится меньше безработных");
    }

    @Override
    public void increaseProduction() {
        if (needMoreProduct) {
            System.out.println("Фабрика " + this.getName() + " увеличила выпуск продукции");
        }
        else {
            System.out.println("Люди не нуждаются в увеличении выпуска");
        }
    }

    @Override
    public String toString() {
        return "Фабрика " + name + ", тип - " + type.translate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacture that = (Manufacture) o;
        return this.getName() == that.getName() && this.type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isThereUnemployed, type, needMoreProduct);
    }
}
