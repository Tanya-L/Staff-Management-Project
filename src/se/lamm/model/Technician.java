package se.lamm.model;

public class Technician extends Employee {

    private int numberCalls;

    public Technician(String name, Gender gender, String birth) {
        super(name, gender, birth);
        this.numberCalls = numberCalls;
        this.calculateSalary();
    }

    @Override
    public double calculateSalary() {
        double pSalary = super.getSalary() + 3000;
        super.setSalary(pSalary);
        return pSalary;
    }

    @Override
    public double calculateBonus(int numberCalls) {
        this.numberCalls+=numberCalls;
        double bonus =  numberCalls * 0.3;
        System.out.println("The employee's bonus for this year is : " + bonus);
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString() + " Number of fixes: " + numberCalls;
    }
}