import java.util.Random;

public class Animal {
    Random rand = new Random();
    private String name;
    private int rank;

    public Animal(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public String toString() {
        return name + "," + rank + "\n";
    }

    public Animal winner(Animal animal1, Animal animal2) {
        int range = animal1.getRank() + animal2.getRank();
        int num = rand.nextInt(range) + 1;
        if (num <= animal1.getRank()) {
            return animal2;
        } else {
            return animal1;
        }
    }
}