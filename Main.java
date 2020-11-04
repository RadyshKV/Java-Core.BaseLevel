package Home_Work_5;

public class Main {


    public static void main(String[] args) {

        Dog dog1 = new Dog("Жучка");
        Cat cat1 = new Cat("Мурзик");
        Horse horse1 = new Horse("Горбунок");
        Bird bird1 = new Bird("Чижик");

        Dog dog2 = new Dog("Бобик", 100, -10, -0.1F); // вызов конструктора с разбросом значений

        System.out.println(dog1.floating(10));
        System.out.println(dog1.running(600));
        System.out.println(dog1.jumping(0.5F));

        System.out.println(cat1.floating(20));
        System.out.println(cat1.running(300));
        System.out.println(cat1.jumping(0.2F));

        System.out.println(horse1.floating(20));
        System.out.println(horse1.running(300));
        System.out.println(horse1.jumping(0.2F));

        System.out.println(bird1.floating(20));
        System.out.println(bird1.running(300));
        System.out.println(bird1.jumping(0.5F));

        System.out.println(dog2.floating(10));
        System.out.println(dog2.running(600));
        System.out.println(dog2.jumping(0.5F));

        
    }
}
