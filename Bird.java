package Home_Work_5;

public class Bird extends Animal {
    public Bird(String name) {
        super(name, 5, 0, 0.2F);
    }

    public Bird(String name, float deviationRunning, float deviationFloating, float deviationJumping) {
        super(name, 5, 0, 0.2F, deviationRunning, deviationFloating, deviationJumping);
    }


    @Override
    protected String running(float obstacle) {
        if (obstacle <= restrictionOnRunning) {
            return "Птичка " + name + " пробежала " + obstacle + " метров";
        } else {
            return "Птичка " + name + " не пробежала " + obstacle + " метров";
        }
    }



    @Override
    protected String floating(float obstacle) {
            return "Птичка плавать не умеет";

    }



    @Override
    protected String jumping(float obstacle) {
        if (obstacle <= restrictionOnJumping) {
            return "Птичка " + name + " перепрыгнула " + obstacle + " метров";
        } else {
            return "Птичка " + name + " не перепрыгнула " + obstacle + " метров";
        }

    }


}
