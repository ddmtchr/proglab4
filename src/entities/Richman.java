package entities;

import exceptions.NotEnoughMoneyException;
import utilities.*;

import java.util.Objects;

public class Richman extends Human implements LoseAll {
    private Infrastructure property;
    private int money = 2000000;

    public static class Footman extends Human implements JobChanger {
        private Job workPlace;

        public Footman(String name, Job job) {
            super(name);
            this.workPlace = job;
            System.out.println("Создан лакей " + name + ", должность: " + job.translate());
        }

        public Job getWorkPlace() {
            return this.workPlace;
        }

        @Override
        public void changeJob(Job job) {
            this.workPlace = job;
            System.out.println("Лакей " + this.getName() + " сменил профессию на " + job.translate());
        }

        @Override
        public void changePlace(Infrastructure inf) {
            System.out.println("Бывший лакей " + this.getName() + " теперь работает в " + inf.translate());
        }
    }

    public Richman() {
        super();
        this.property = Infrastructure.RICHMAN_HOUSE;
    }

    public Richman(String name) {
        super(name);
        this.property = Infrastructure.RICHMAN_HOUSE;
    }

    public Infrastructure getProperty() {
        return this.property;
    }
    @Override
    public void loseProperty() {
        System.out.println("Богач " + this.getName() + " потерял имущество " + this.property.translate());
        this.property = null;
    }

    @Override
    public void loseMoney(int m) throws NotEnoughMoneyException {
        if (this.money < m) throw new NotEnoughMoneyException("Богач ушел в минус");
        this.money -= m;
        System.out.println("Персонаж " + this.getName() + " растерял свои капиталы. Баланс: " + this.money);
    }

    @Override
    public String toString() {
        return "Богач по имени " + this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Richman richman = (Richman) o;
        return this.getName().equals(richman.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, getName());
    }
}
