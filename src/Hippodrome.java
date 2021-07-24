import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public Horse getWinner() {
        double maxDistance = 0;
        Horse winner = null;
        for (Horse horse : getHorses()) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }
    public void printWinner() {
        System.out.printf("Winner is %s!", getWinner().getName());
    }
    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        Horse a = new Horse("A", 3, 0);
        Horse b = new Horse("B", 3, 0);
        Horse c = new Horse("C", 3, 0);
        horses.add(a);
        horses.add(b);
        horses.add(c);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
