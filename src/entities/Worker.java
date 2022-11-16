package entities;

import utilities.*;

import java.util.Objects;

public class Worker extends Human implements Workable, JobChanger {
    private Job workPlace;
    private boolean hasBigSalary = false;
    private boolean eatInRestaurant = false;
    private static String test = "Test static variable";

    public static class InnerClass {
        public InnerClass() {
            System.out.println("Создан внутренний static класс, вложенный в Worker");
        }
        public void printInfo(String msg) {
            System.out.println(msg);
            System.out.println("Static переменная test класса Worker: " + test);
            System.out.println("Фантазия на этом всё");
        }
    }

    public Worker() {
        super();
        workPlace = Job.NONE;
        System.out.println("Создан безработный безымянный человек");
    }

    public Worker(String name) {
        super(name);
        workPlace = Job.NONE;
        System.out.println("Создан безработный человек по имени " + name);
    }

    public Worker(String name, Job job) {
        super(name);
        workPlace = job;
        System.out.println("Создан человек " + name + " c профессией " + workPlace.translate());
    }

    public Job getJob() {
        return this.workPlace;
    }

    public boolean getSalary() {
        return hasBigSalary;
    }

    public void changePlace(Infrastructure inf) { System.out.println("Персонаж " + this.getName() + " теперь работает в " + inf.translate()); }

    @Override
    public void changeJob(Job job) {
        this.workPlace = job;
        System.out.println("Персонаж " + this.getName() + " меняет профессию на " + job.translate());
    }

    @Override
    public void increaseSalary() {
        this.hasBigSalary = true;
        this.eatInRestaurant = true;
        System.out.println("У рабочего " + this.getName() + " увеличилась зарплата.");
        System.out.println("Теперь у него хватает денег, чтобы обедать в ресторане.");
    }

    @Override
    public void quitRichman() { System.out.println("Работник " + this.getName() + " уволился от богача."); }

    @Override
    public String toString() {
        return "Рабочий " + getName() + ", место работы - " + workPlace.translate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return this.workPlace == worker.workPlace && this.getName() == worker.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(workPlace, getName());
    }
}
