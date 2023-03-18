public class AnimalRunner {
    Animal animalObj = new Animal();

    public AnimalRunner() {
        checkToWin();
    }

    public static void main(String[] args) {
        AnimalRunner animalRunner = new AnimalRunner();
    }

    public void checkToWin() {
        Animal animal1 = new Animal("an1", 1);
        Animal animal2 = new Animal("an2", 9);
        System.out.println(animalObj.winner(animal1, animal2));
    }
}