package se.lamm.model;

public class Secretary extends Employee {

    private int extraHours = 0;

    public Secretary(String name, Gender gender, String birth) {
        super(name, gender, birth);
        this.calculateSalary();
    }

    @Override
    public double calculateSalary() {
        double pSalary = super.getSalary() + 1000;
        super.setSalary(pSalary);
        return pSalary;
    }

    @Override
    public double calculateBonus(int extraHours) {
        this.extraHours += extraHours;
        double bonus =  extraHours * 0.2;
        System.out.println("The employee's bonus for this year is : " + bonus);
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString() + " Extra hours: " + extraHours;
    }
    
}