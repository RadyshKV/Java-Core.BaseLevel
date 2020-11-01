package ru.geekbrains.Home_Work_4;

public class HW4 {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Ширяев Гордей Митрофанович", "директор", "8-999-999-22-11", 250000, 50);

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Владимиров Ипполит Мэлорович", "главный инженер", "8-999-999-22-12", 150000, 35);
        employees[1] = new Employee("Селезнёв Гаянэ Натанович", "сантехник", "8-999-999-22-13", 60000, 40);
        employees[2] = new Employee("Горбачёв Илья Вячеславович", "слесарь", "8-999-999-22-14", 60000, 46);
        employees[3] = new Employee("Сафонов Лука Улебович", "Инженер-гидравлик", "8-999-999-22-15", 75000, 45);
        employees[4] = new Employee("Лазарев Пантелеймон Иосифович", "Телемастер", "8-999-999-22-16", 45000, 29);

        System.out.println("ФИО: " + employee1.getName() + "\nДолжность: " + employee1.getPosition());
        System.out.println();

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= 40) {
                System.out.println("ФИО: " + employees[i].getName());
                System.out.println("Должность: " + employees[i].getPosition());
                System.out.println("Телефон: " + employees[i].getPhoneNumber());
                System.out.println("Заработная плата: " + employees[i].getSalary());
                System.out.println("Возраст: " + employees[i].getAge());
                System.out.println();
            }
        }

        for (int i = 0; i < employees.length; i++) {
            raiseSalary(employees[i]);
        }
    }

    public static void raiseSalary(Employee employee) {
        if (employee.getAge() >= 45) {
            employee.setSalary(employee.getSalary() + 5000);
            System.out.println("ФИО: " + employee.getName() + "\nЗаработная плата: " + employee.getSalary());
            System.out.println();
        }
    }

}