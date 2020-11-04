package Home_Work_5;

public class Animal {

    protected String name;
    protected float restrictionOnRunning; // ограничение на бег
    protected float restrictionOnFloating; // ограничение на плавание
    protected float restrictionOnJumping; // ограничение на прыжок

    public Animal(String name, float restrictionOnRunning, float restrictionOnFloating, float restrictionOnJumping) {
        this.name = name;
        this.restrictionOnRunning = restrictionOnRunning;
        this.restrictionOnFloating = restrictionOnFloating;
        this.restrictionOnJumping = restrictionOnJumping;
    }

    public Animal(String name, float restrictionOnRunning, float restrictionOnFloating, float restrictionOnJumping, float deviationRunning, float deviationFloating, float deviationJumping) {
        this.name = name;
        this.restrictionOnRunning = restrictionOnRunning + deviationRunning;
        this.restrictionOnFloating = restrictionOnFloating + deviationFloating;
        this.restrictionOnJumping = restrictionOnJumping + deviationJumping;
    }

    protected String running(float obstacle) {
        return "Животное "+ name +" пробежало " + obstacle + " метров";
    }



    protected String floating(float obstacle) {
        return "Животное "+ name +" проплыло " + obstacle + " метров";
    }



    protected String jumping(float obstacle) {
        return "Животное "+ name +" перепрыгнуло " + obstacle + " метров";
    }


}
