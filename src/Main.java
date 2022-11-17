import entities.*;
import exceptions.NoEquipmentException;
import exceptions.NotEnoughMoneyException;
import utilities.Harmable;
import utilities.Infrastructure;
import utilities.Job;

public class Main {
    public static void main(String[] args) {
        Policeman p = new Policeman("Жак Ф.");
        Harmable zeroGravity = new Harmable() {
            @Override
            public void harm() {
                System.out.println("Невесомость наносит ожоги, ранения и увечья полицейским");
            }
        };
        zeroGravity.harm();

        p.stopOpposeWorkers();
        try {
            p.throwAway();
        } catch (NoEquipmentException e) {
            System.out.println(e.getMessage());
        }
        p.changeJob(Job.COOK);
        p.changePlace(Infrastructure.CANTEEN);
        System.out.println();

        Worker[] workers = new Worker[]{
                new Worker("Петрович", Job.WORKER),
                new Worker("Николаич", Job.COOK)
        };
        Richman.Footman[] footmen = new Richman.Footman[]{
                new Richman.Footman("Геннадий", Job.PORTER),
                new Richman.Footman("Janie", Job.LAUNDRESS)
        };
        System.out.println();

        Manufacture fabric = new Manufacture("Zavod");
        fabric.setType(Infrastructure.FABRIC);

        for (Worker w : workers) {
            w.quitRichman();
        }


        workers[0].increaseSalary();
        workers[1].increaseSalary();
        System.out.println();

        for (Worker w : workers) {
            if (w.getSalary()) {
                fabric.needMoreProduct = true;
            }
        }
        if (fabric.needMoreProduct) {
            fabric.increaseProduction();
            fabric.hireWorkers();
        }
        workers[0].changePlace(Infrastructure.FABRIC);
        workers[1].changePlace(Infrastructure.RESTAURANT);
        footmen[0].changePlace(Infrastructure.FABRIC);
        footmen[1].changePlace(Infrastructure.RESTAURANT);
        footmen[0].changeJob(Job.WORKER);
        footmen[1].changeJob(Job.COOK);

        System.out.println();

        Manufacture pastaFabric = new Manufacture("Макаронная фабрика");
        pastaFabric.setType(Infrastructure.FABRIC);

        Scooperfield scooperfield = new Scooperfield("Scooperfield");
        scooperfield.setProperty(pastaFabric);
        try {
            scooperfield.loseMoney(2000000);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
        scooperfield.loseProperty();
        scooperfield.changeJob(Job.WORKER);
        System.out.println();


    }
}
