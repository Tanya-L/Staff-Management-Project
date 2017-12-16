package se.lamm.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Calendar;

public abstract class Employee {

    private int id;
    private String name;
    private Gender gender;
    private double salary;
    private LocalDate joiningDate;
    private LocalDate birth;
    private static int numId = 1;

    public Employee(String name, Gender gender, String birth) {
        this.name = name;
        this.gender = gender;
        this.salary = 25000;
        this.id = numId;
        numId++;
        this.joiningDate = LocalDate.now();
        this.birth = LocalDate.parse(birth);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public abstract double calculateSalary();

    public abstract double calculateBonus(int i);

    public int calculateAge(Employee employee) {
        Date dateNow = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);
        int age = (cal.get(Calendar.YEAR) - birth.getYear());
        return age;
    }

    @Override
    public String toString() {
        int index1 = getClass().toString().indexOf('.');
        String profession = getClass().toString().substring(index1 + 12);
//        return "ID: " + id + "\t " + profession + " Name: " + name + "\t " + gender + 
//        " Salary: " + salary + "\t Joining Date: " + joiningDate.getYear()+  "/" + joiningDate.getMonthValue() +"/" + joiningDate.getDayOfMonth() + "\t Birthdate: " + birth;
        
        return String.format("%-4s%-14s%-25s%-8s%-9s%-4s/%-2s/%-7s%-12s", id,profession,name,gender,salary,joiningDate.getYear(),joiningDate.getMonthValue(),joiningDate.getDayOfMonth(),birth);
                //"ID: " + id + "\t " + profession + " Name: " + name + "\t " + gender + 
        //" Salary: " + salary + "\t Joining Date: " + joiningDate.getYear()+  "/" + joiningDate.getMonthValue() +"/" + joiningDate.getDayOfMonth() + "\t Birthdate: " + birth;
    
    }
}