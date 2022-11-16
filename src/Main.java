import entities.Manufacture;
import entities.Policeman;
import entities.Scooperfield;
import entities.Worker;
import exceptions.NoEquipmentException;
import exceptions.NotEnoughMoneyException;
import utilities.Harmable;
import utilities.Infrastructure;
import utilities.Job;

public class Main {
    public static void main(String[] args) {
        try {
            Policeman p = new Policeman("Жак Ф.");
            Harmable zeroGravity = new Harmable() {
                @Override
                public void harm() {
                    System.out.println("Невесомость наносит ожоги, ранения и увечья полицейским");
                }
            };
            zeroGravity.harm();
            p.stopOpposeWorkers();
            p.throwAway();
            p.changeJob(Job.COOK);
            System.out.println();

            Worker[] workers = new Worker[]{
                    new Worker("Геннадий", Job.WORKER),
                    new Worker("Janie", Job.LAUNDRESS),
                    new Worker("Петрович", Job.PORTER),
                    new Worker("Николаич", Job.COOK)
            };
            System.out.println();

            Manufacture fabric = new Manufacture("Zavod");
            fabric.setType(Infrastructure.FABRIC);

            for (Worker w : workers) {
                w.quitRichman();
            }

            workers[0].increaseSalary();
            workers[2].increaseSalary();
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
            workers[3].changePlace(Infrastructure.CANTEEN);
            workers[1].changePlace(Infrastructure.RESTAURANT);
            workers[2].changeJob(Job.WORKER);
            workers[2].changePlace(Infrastructure.FABRIC);

            System.out.println();

            Manufacture pastaFabric = new Manufacture("Макаронная фабрика");
            pastaFabric.setType(Infrastructure.FABRIC);

            Scooperfield scooperfield = new Scooperfield("Scooperfield");
            scooperfield.setProperty(pastaFabric);
            scooperfield.loseMoney(2000000);
            scooperfield.loseProperty();
            scooperfield.changeJob(Job.WORKER);
            System.out.println();

            Worker.InnerClass wic = new Worker.InnerClass();
            wic.printInfo("Метод printInfo класса Worker.InnerClass");
        } catch (NotEnoughMoneyException e) {
            System.out.println("Поймано исключение NotEnoughMoneyException");
        } catch (NoEquipmentException e) {
            System.out.println("Поймано исключение NoEquipmentException");
        }
    }
}
