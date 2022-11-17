package entities;

import exceptions.NoEquipmentException;
import utilities.*;

import java.util.Objects;

public class Policeman extends Human implements JobChanger {
    private Job workPlace;
    private boolean isOpposeWorkers;
    private Equipment[] eq = new Equipment[] {
        new Equipment(PoliceStuff.COAT),
        new Equipment(PoliceStuff.HELMET),
        new Equipment(PoliceStuff.PISTOL),
        new Equipment(PoliceStuff.RIFLE)
    };

    private class Equipment {
        private PoliceStuff type;
        private Equipment(PoliceStuff type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type.translate();
        }
    }

    public Policeman() {
        super();
        System.out.println("Создан безымянный полицейский");
    }

    public Policeman(String name) {
        super(name);
        System.out.println("Создан полицейский по имени " + name);
    }

    @Override
    public void changeJob(Job job) {
        this.workPlace = job;
        System.out.println("Бывший полицейский " + this.getName() + " меняет работу на " + job.translate());
    }

    @Override
    public void changePlace(Infrastructure inf) {
        System.out.println("Бывший полицейский " + this.getName() + " теперь работает в " + inf.translate());
    }

    public void stopOpposeWorkers() {
        System.out.println("Полиция перестала выступать против рабочих");
    }

    public void throwAway() throws NoEquipmentException {
        if (this.eq.length == 0) throw new NoEquipmentException("У полицейского нет экипировки");
        for (int i = 0; i < this.eq.length; i++) {
            System.out.println("Полицейский " + this.getName() + " выбрасывает экипировку " + this.eq[i].toString());
            this.eq[i] = null;
        }
    }

    @Override
    public String toString() {
        return "Полицейский " + this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policeman policeman = (Policeman) o;
        return workPlace == policeman.workPlace && getName().equals(policeman.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workPlace, isOpposeWorkers);
    }
}
