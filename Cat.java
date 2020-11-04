package Home_Work_5;

public class Cat extends Animal {
    public Cat(String name) {
        super(name, 200, 0, 2);
    }

    public Cat(String name, float deviationRunning, float deviationFloating, float deviationJumping) {
        super(name, 200, 0, 2, deviationRunning, deviationFloating, deviationJumping);
    }


    @Override
    protected String running(float obstacle) {
        if (obstacle <= restrictionOnRunning) {
            return "Кот " + name + " пробежал " + obstacle + " метров";
        } else {
            return "Кот " + name + " не пробежал " + obstacle + " метров";
        }
    }



    @Override
    protected String floating(float obstacle) {
        return "Кот плавать не умеет";

    }



    @Override
    protected String jumping(float obstacle) {
        if (obstacle <= restrictionOnJumping) {
            return "Кот " + name + " перепрыгнул " + obstacle + " метров";
        } else {
            return "Кот " + name + " не перепрыгнул " + obstacle + " метров";
        }

    }


}
