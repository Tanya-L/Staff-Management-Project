package se.lamm.model;

public class Accounting extends Employee {

    private int lostBill;

    public Accounting(String name, Gender gender, String birth) {
        super(name, gender, birth);
        this.lostBill = 0;
        this.calculateSalary();
    }

    public int getLostBill() {
        return lostBill;
    }

    public void setLostBill(int lostBill) {
        this.lostBill = lostBill;
    }

    @Override
    public double calculateSalary() {
        double pSalary = super.getSalary() + 2000;
        super.setSalary(pSalary);
        return pSalary;
    }

    @Override
    public double calculateBonus(int lostBill) {
        this.lostBill+= lostBill;
        double bonus = 1000;
        if (lostBill > 0) {
            bonus = 0;
        }
         System.out.println("The employee's bonus for this year is : " + bonus);
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString() + " Number of lost bills: " + lostBill;
    }
}