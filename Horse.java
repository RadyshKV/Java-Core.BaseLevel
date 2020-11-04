package Home_Work_5;

public class Horse extends Animal {
    public Horse(String name) {
        super(name, 1500, 100, 3);
    }

    public Horse(String name, float deviationRunning, float deviationFloating, float deviationJumping) {
        super(name, 1500, 100, 3, deviationRunning, deviationFloating, deviationJumping);
    }


    @Override
    protected String running(float obstacle) {
        if (obstacle <= restrictionOnRunning) {
            return "Лошадка " + name + " пробежала " + obstacle + " метров";
        } else {
            return "Лошадка " + name + " не пробежала " + obstacle + " метров";
        }
    }



    @Override
    protected String floating(float obstacle) {
        if (obstacle <= restrictionOnFloating) {
            return "Лошадка " + name + " проплыла " + obstacle + " метров";
        } else {
            return "Лошадка " + name + " не проплыла " + obstacle + " метров";
        }
    }



    @Override
    protected String jumping(float obstacle) {
        if (obstacle <= restrictionOnJumping) {
            return "Лошадка " + name + " перепрыгнула " + obstacle + " метров";
        } else {
            return "Лошадка " + name + " не перепрыгнула " + obstacle + " метров";
        }

    }


}
