
package se.lamm.model;



import se.lamm.model.*;
import java.util.Scanner;
import se.lamm.model.Gender;
import se.lamm.model.Technician;
import static se.lamm.model.Utilities.*;

public class UI {

    static Scanner sc = new Scanner(System.in);
    static EmployeeManagement em = new EmployeeManagement();

    public void Welcome() {
        System.err.println("     Welcome to LAMM Staff Management System");
        System.err.println("                    _,._ ");
        System.err.println("               __.'   _)");
        System.err.println("              <_,)'.-\"a\\");
        System.err.println("                 /' (   \\");
        System.err.println("     _.-----..,-'   (`\"--^");
        System.err.println("    //              |");
        System.err.println("   (|   `;      ,   |");
        System.err.println("     \\   ;.----/  ,/");
        System.err.println("      ) // /   | |\\ \\");
        System.err.println(" LAMM \\ \\\\`\\   | |/ /");
        System.err.println(" TEAM  \\ \\\\ \\  | |\\/");
        System.err.println("        `\" `\"  `\"`");
    }

    public void MainMenu() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("\nMain Menu\n===========");
        int choice = nextInt("1. Employee Operations\n2. Employee Statistics\n0. Exit");

        switch (choice) {
            case 1:
                EmployeeOperationsMenu();
                break;
            case 2:
                EmployeeStatisticMenu();
                break;
            case 0:
                System.exit(0);
                break;
            default: {
                System.err.println("Invalid input, choose again");
                MainMenu();
            }
        }
    }

    public void EmployeeOperationsMenu() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("\nEmployee Operations");
        System.out.println("=====================");
        int choice = nextInt("1. List all employees \n2. Add Employee\n3. Remove employee"
                + "\n4. Search for employee by ID\n5. Update employee ( Salary - Name )\n6. Give bonus to employee\n7. Main Menu"
                + "\n0. Exit");
        switch (choice) {
            case 1:
                System.out.println("List of all employees \n====================");
                header();
                em.listAllEmp();
                EmployeeOperationsMenu();
                break;

            case 2: {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                while (!isName(name)) {
                    System.err.print("Invalid input! Enter name: ");
                    name = sc.nextLine();
                }
                System.out.print("Enter gender Female - Male - Other: ");
                String gender = sc.nextLine().toUpperCase();
                Gender g = null;
                boolean isGenderCorrect = true;

                while (isGenderCorrect) {
                    if (gender.equals("FEMALE") || gender.equals("MALE") || gender.equals("OTHER")) {
                        g = Gender.valueOf(gender);
                        isGenderCorrect = false;

                    } else {
                        System.err.print("Invalid input, choose a gender: Female - Male - Other: ");
                        gender = sc.nextLine().toUpperCase();
                    }
                }
                String dob = isDateBirth();

                Employee ee = null;
                System.out.println("1:Programmer\n2:Technitians\n3:Secretary\n4:Accounting");
                switch (sc.nextInt()) {

                    case 1:
                        ee = new Programmer(name, g, dob);
                        break;
                    case 2:
                        ee = new Technician(name, g, dob);
                        break;
                    case 3:
                        ee = new Secretary(name, g, dob);
                        break;
                    case 4:
                        ee = new Accounting(name, g, dob);
                        break;
                    default:
                        System.err.println("Invalid profession! Adding employee action failed");
                        EmployeeOperationsMenu();
                }
                em.addEmp(ee);
                System.out.println("Employee added");
                header();
                System.out.println(ee);
                        
                EmployeeOperationsMenu();
            }
            break;

            case 3:
                int nId = nextInt("Enter id: ");

                //      String empName = em.findEmpByID(nId).getName(); 
                em.removeEmp(nId);
                EmployeeOperationsMenu();
                // add exception message
                break;

            case 4:
                //System.out.print("Enter id: ");
                int sId = nextInt("Enter id: ");
                if (em.findEmpByID(sId) == null) {
                    System.err.println("No employee found!");
                } else {
                    System.out.println(em.findEmpByID(sId));
                }
                EmployeeOperationsMenu();
                break;

            case 5: {
                UpdateMenu();
            }
            break;

            case 6: {
                System.out.print("Enter id: ");
                int id = sc.nextInt();
                if (em.findEmpByID(id) == null) {
                    System.err.println("Employee not found!");
                    EmployeeOperationsMenu();
                } else {
                    if (em.findEmpByID(id).getClass().equals(Programmer.class)) {
                        System.out.println(em.findEmpByID(id).toString());
                        System.out.print("How many projects has done? ");
                    } else if (em.findEmpByID(id).getClass().equals(Technician.class)) {
                        System.out.println(em.findEmpByID(id).toString());
                        System.out.print("How many problems were fixed? ");
                    } else if (em.findEmpByID(id).getClass().equals(Secretary.class)) {
                        System.out.println(em.findEmpByID(id).toString());
                        System.out.print("How many extra hours? ");
                    } else if (em.findEmpByID(id).getClass().equals(Accounting.class)) {
                        System.out.println(em.findEmpByID(id).toString());
                        System.out.print("Number of lost bills? ");
                    }
                    em.findEmpByID(id).calculateBonus(sc.nextInt());
                    EmployeeOperationsMenu();
                }
            }
            break;

            case 7:
                MainMenu();
                break;

            case 0:
                System.exit(0);
                break;
            default:
                System.err.println("Invalid input, choose again");
                MainMenu();
        }
    }

    public void EmployeeStatisticMenu() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("\nEmployee Statistics");
        System.out.println("=====================");
        int choice = nextInt("1. Find lowest salary\n2. Find highest salary\n3. Find average salary"
                + "\n4. List employees by gender\n5. List employees by age\n6. List employees by profession"
                + "\n7. Main Menu\n0. Exit");
        switch (choice) {
            case 1:
                System.out.println("The lowest salary is: " + em.calculateMinSalary());
                EmployeeStatisticMenu();
                break;

            case 2:
                System.out.println("The highest salary is: " + em.calculateMaxSalary());
                EmployeeStatisticMenu();
                break;

            case 3: {
                System.out.println("The average salary is: " + em.calculateAverageSalary());
                EmployeeStatisticMenu();
            }
            break;

            case 4: {

                System.out.print("Enter gender Female - Male - Other: ");
                //sc.nextLine();
                String gender = sc.nextLine().toUpperCase();
                Gender g = null;
                boolean isGenderCorrect = true;

                while (isGenderCorrect) {
                    if (gender.equals("FEMALE") || gender.equals("MALE") || gender.equals("OTHER")) {
                        g = Gender.valueOf(gender);
                        isGenderCorrect = false;
                        header();
                        em.listEmployeesByGender(g);

                    } else {
                        System.err.print("Invalid input, choose a gender: Female - Male - Other: ");
                        gender = sc.nextLine().toUpperCase();
                    }
                }
                EmployeeStatisticMenu();
            }
            break;

            case 5:
                System.out.println("Type Age");
                em.listByAge(sc.nextInt());
                EmployeeStatisticMenu();
                break;

            case 6:
                ListByProfessionMenu();
                break;

            case 7:
                MainMenu();
                break;

            case 0:
                System.exit(0);
                break;

            default: {
                System.err.println("Invalid input, choose again");
                MainMenu();
            }
        }
    }

    public void UpdateMenu() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("\nWhat entry would you like to update?");
        int choice = nextInt("1. Employee salary\n2. Employee name\n3. Main Menu\n0. Exit");

        switch (choice) {
            case 1: {

                int iD = nextInt("Enter ID: ");
                double newSalary = nextDouble("Enter new Salary: ");
                em.updateEmpSalary(iD, newSalary);
                EmployeeOperationsMenu();
            }
            break;

            case 2: {
                int iD = nextInt("Enter ID: ");
                //sc.nextLine();
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                while (!isName(newName)) {
                    System.err.print("Invalid input! Enter name: ");
                    newName = sc.nextLine();
                }
                em.updateEmpName(iD, newName);
                EmployeeOperationsMenu();
            }
            break;

            case 3:
                MainMenu();
                break;

            case 0:
                System.exit(0);
                break;

            default: {
                System.err.println("Invalid input, choose again");
                MainMenu();
            }
        }
    }

    public void ListByProfessionMenu() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("\nWhich profession do you want to list?");
        int choice = nextInt("1. Programmers\n2. Technicians\n3. Secretaries\n4. Accounting"
                + "\n5. Main Menu\n0. Exit");

        //sc.nextLine();
        switch (choice) {
            case 1: {
                em.printTheList(em.getAllEmployee(Programmer.class));
                EmployeeStatisticMenu();
            }

            break;
            case 2:
                em.printTheList(em.getAllEmployee(Technician.class));
                EmployeeStatisticMenu();
                break;

            case 3:
                em.printTheList(em.getAllEmployee(Secretary.class));
                EmployeeStatisticMenu();
                break;
            case 4:
                em.printTheList(em.getAllEmployee(Accounting.class));
                EmployeeStatisticMenu();
                break;

            case 5:
                MainMenu();
                break;

            case 0:
                System.exit(0);
                break;

            default: {
                System.err.println("Invalid input, choose again");
                MainMenu();
            }
        }
    }
}