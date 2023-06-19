import java.util.Random;

public class Animal {
    private final String name;
    private final int rank;
    Random rand = new Random();

    public Animal(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public Animal() {
        name = null;
        rank = 0;
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
        boolean random = Runner.random;
        int weight = Runner.weight, range;
        double num;
        Animal lowerSeedAnimal = null, higherSeedAnimal = null;

        if (animal1.getRank() < animal2.getRank()) {
            lowerSeedAnimal = animal1;
            higherSeedAnimal = animal2;
        } else if (animal2.getRank() < animal1.getRank()) {
            lowerSeedAnimal = animal2;
            higherSeedAnimal = animal1;
        }

        if (random) {
            range = 2;
            weight = 50;
        } else {
            range = animal1.getRank() + animal2.getRank();
        }

        num = rand.nextInt(range) + 1;

        if (weight == 0) {
            if (higherSeedAnimal != null) {
                return higherSeedAnimal;
            }
        } else if (weight < 50) {
            num += num * ((50 - weight) / 100.0);
        } else if ((weight < 100) && (weight != 50)) {
            num -= num * ((weight - 50) / 100.0);
        } else if (weight == 100) {
            if (lowerSeedAnimal != null) {
                return lowerSeedAnimal;
            }
        }

        if (lowerSeedAnimal != null) {
            if (num <= higherSeedAnimal.getRank()) {
                return lowerSeedAnimal;
            } else {
                return higherSeedAnimal;
            }
        }

        if (num <= animal1.getRank()) {
            return animal2;
        } else {
            return animal1;
        }
    }
}