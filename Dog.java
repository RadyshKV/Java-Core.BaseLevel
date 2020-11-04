package Home_Work_5;

public class Dog extends Animal {
    public Dog(String name) {
        super(name, 500, 10, 0.5F);
    }

    public Dog(String name, float deviationRunning, float deviationFloating, float deviationJumping) {
        super(name, 500, 10, 0.5F, deviationRunning, deviationFloating, deviationJumping);
    }


    @Override
    protected String running(float obstacle) {
        if (obstacle <= restrictionOnRunning) {
            return "Собачка " + name + " пробежала " + obstacle + " метров";
        } else {
            return "Собачка " + name + " не пробежала " + obstacle + " метров";
        }
    }



    @Override
    protected String floating(float obstacle) {
        if (obstacle <= restrictionOnFloating) {
            return "Собачка " + name + " проплыла " + obstacle + " метров";
        } else {
            return "Собачка " + name + " не проплыла " + obstacle + " метров";
        }
    }



    @Override
    protected String jumping(float obstacle) {
        if (obstacle <= restrictionOnJumping) {
            return "Собачка " + name + " перепрыгнула " + obstacle + " метров";
        } else {
            return "Собачка " + name + " не перепрыгнула " + obstacle + " метров";
        }

    }
}
