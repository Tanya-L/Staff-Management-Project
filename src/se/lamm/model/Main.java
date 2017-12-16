
package se.lamm.model;


import se.lamm.model.*;

public class Main {

    static EmployeeManagement em = new EmployeeManagement();

    public static void main(String[] args) throws InterruptedException {
     //   System.out.printf("|%-10s|%-4d","nmmmmm",76);
        em.addEmp(new Programmer("Eleonora Maccacaro", Gender.FEMALE, "1985-06-22"));
        em.addEmp(new Programmer("Mehreen Mairaj", Gender.FEMALE, "1983-08-08"));
        em.addEmp(new Programmer("Tanya Lytovchenko", Gender.FEMALE, "1979-10-24"));
        em.addEmp(new Programmer("Haydee Arbieto", Gender.FEMALE, "1976-10-28"));
        
        em.addEmp(new Technician("Nick Carter", Gender.MALE, "1976-04-08"));
        em.addEmp(new Technician("Lady Gaga", Gender.FEMALE, "1976-01-28"));
        em.addEmp(new Technician("Emma Thomson", Gender.OTHER, "1978-09-09"));
        
        em.addEmp(new Accounting("Thom Hanks", Gender.MALE, "1970-01-20"));
        em.addEmp(new Accounting("Tom Cruise", Gender.MALE, "1985-06-22"));
        em.addEmp(new Accounting("Karl Gustav 16", Gender.MALE, "1956-01-01"));
        
        em.addEmp(new Secretary("John Smith", Gender.MALE, "1989-10-03"));
        em.addEmp(new Secretary("Donald Trump", Gender.OTHER, "1940-08-08"));
        
        UI menu = new UI();
        menu.Welcome();
        menu.MainMenu();
    }
}