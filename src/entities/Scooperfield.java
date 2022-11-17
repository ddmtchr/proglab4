package entities;

import utilities.Infrastructure;
import utilities.Job;
import utilities.LoseAll;
import utilities.JobChanger;

import java.util.Objects;

public class Scooperfield extends Richman implements LoseAll, JobChanger {
    private Job workPlace;
    private int money = 2000000;
    private Manufacture ownManufacture;

    public Scooperfield(String name) {
        super(name);
        System.out.println("Создан персонаж " + name + ". Владеет: " + this.getProperty().translate());
    }

    public void setProperty(Manufacture p) {
        class PastaFabric extends Manufacture {
            public PastaFabric(String name) {
                super(name);
                System.out.println("Создан объект " + name);
            }
        }
        PastaFabric pf = new PastaFabric("Макаронная фабрика");
        this.ownManufacture = pf;
        System.out.println("Персонаж " + this.getName() + " владеет " + pf.getName());
    }

    @Override
    public void changeJob(Job job) {
        this.workPlace = Job.WORKER;
        System.out.println("Персонаж " + this.getName() + " меняет профессию на " + job.translate());
    }

    @Override
    public void changePlace(Infrastructure inf) {
        System.out.println("Персонаж " + this.getName() + " теперь работает в " + inf.translate());
    }

    @Override
    public void loseProperty() {
        System.out.println("Персонаж " + this.getName() + " потерял имущество " + this.ownManufacture.getName());
        this.ownManufacture = null;
    }

    @Override
    public String toString() {
        return "Scooperfield";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scooperfield that = (Scooperfield) o;
        return that.getName() == this.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(workPlace, money, ownManufacture);
    }
}
