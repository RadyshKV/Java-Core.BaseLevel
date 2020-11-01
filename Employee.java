package ru.geekbrains.Home_Work_4;

public class Employee {
    static long idCounter = 0;
    private long id;
    private String name;
    private String position;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String position, String phoneNumber, int salary, int age) {
        this.id = idCounter++;
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}