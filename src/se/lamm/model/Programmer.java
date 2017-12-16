package se.lamm.model;

public class Programmer extends Employee {

    private int numberOfProjects = 0;

    public Programmer(String name, Gender gender, String birth) {
        super(name, gender, birth);
        this.calculateSalary();
    }

    public int getNumberOfProjects() {
        return numberOfProjects;
    }
    
    public void setNumberOfProjects(int numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }

    @Override
    public double calculateSalary() {
        double pSalary = super.getSalary() + 5000;
        super.setSalary(pSalary);
        return pSalary;
    }

    @Override
    public double calculateBonus(int numberOfProjects) {
        this.numberOfProjects += numberOfProjects;
        double bonus = super.getSalary() * numberOfProjects;
        System.out.println(super.getName() + " got a bonus of: " + bonus);
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString() + " Number of projects: " + numberOfProjects;
    }
}