
package se.lamm.model;

import se.lamm.model.Gender;
import se.lamm.model.Employee;
import java.util.ArrayList;
import static se.lamm.model.Utilities.header;

 public class EmployeeManagement {

    private static ArrayList<Employee> employeeList = new ArrayList<>();
    
    public void addEmp(Employee e) {
      employeeList.add(e);
    }

    public void removeEmp(int id) {
        int temp=0;
        int i =0;
        boolean isEmployee = false;
        for (Employee employee : employeeList) {
            
            if (id==employee.getId()) {
                temp = i;
                isEmployee = true;
                System.out.println( "Employee has been removed!");
            }
            i++;
            
        } 
        employeeList.remove(temp);
        if (!isEmployee) {
            System.err.println("No employee found!");
        }
    }

    public void listAllEmp() {
        for (Employee employee1 : employeeList) {
            System.out.println(employee1.toString());
        }
    }

    public Employee findEmpByID(int id) {
        for (Employee employee : employeeList) {
            if (id == employee.getId()) { 
                return employee;             
            }
        }
        return null;
    }

   public void updateEmpName(int iD, String newName) {
        boolean isEmployee = false;
        for (Employee employee : employeeList) {

            if (iD == employee.getId()) { 
                employee.setName(newName);
                System.out.println("Employee ID: " + employee.getId() + " changed the name to " + newName);
                header();
                System.out.println(employee.toString());
                isEmployee = true;
            }
        }
         if (!isEmployee) {
            System.out.println("No employee found!");
        }
    }

    public void updateEmpSalary(int iD, double newSalary) {
        boolean isEmployee = false;
        for (Employee employee : employeeList) {

            if (iD == employee.getId()) { 
                employee.setSalary(newSalary);
                System.out.println("Employee ID: " + employee.getId() + " has a new salary of " + newSalary);
                header();
                System.out.println(employee.toString());
                 isEmployee = true;
            }
        }
         if (!isEmployee) {
            System.out.println("No employee found!");
        }
    }

    public void updateEmpGender(int iD, Gender newGender) {
        boolean isEmployee = false;
        for (Employee employee : employeeList) {

            if (iD == employee.getId()) { 
                employee.setGender(newGender);
                System.out.println("Employee ID: " + employee.getId() + " changed gender to " + newGender);
                header();
                System.out.println(employee.toString());
                 isEmployee = true;
            }
        }
        if (!isEmployee) {
            System.out.println("No employee found!");
        }
    }
   
    public double calculateAverageSalary() {
        double sumSalary = 0;
        for (Employee employee1 : employeeList) {
            sumSalary = sumSalary + employee1.getSalary();
        }
        return sumSalary / employeeList.size();
    }

    public double calculateMaxSalary() {
        double maxSalary = 0;
        for (Employee employee1 : employeeList) {
            maxSalary = Math.max(maxSalary, employee1.getSalary());
        }
        return maxSalary;
    }

    public double calculateMinSalary() {
        double minSalary = employeeList.get(0).getSalary();
        for (Employee employee1 : employeeList) {
            minSalary = Math.min(minSalary, employee1.getSalary());
        }
        return minSalary;
    }

    public void listEmployeesByGender(Gender gender) {
        boolean isEmployee = false;
        for (Employee employee : employeeList) {
            if(gender == employee.getGender()){
                System.out.println(employee.toString());
                 isEmployee = true;
            }
        }
        if (!isEmployee) {
            System.out.println("No employee found!");
        }
    }

    public void listByAge(int age) {
        boolean isEmployee = false;
        boolean isHeader = true;
        for (Employee employee : employeeList) {
           if(age == employee.calculateAge(employee)){
              if (isHeader) {
                  header();
                  isHeader = false;
              }
               
               System.out.println(employee );
               isEmployee = true;
           } 
        }
        
        if (!isEmployee) {
            System.out.println("No employee found!");
        }
    }
    
    public ArrayList<Employee> getAllEmployee(Class c){
        ArrayList<Employee> temp = new ArrayList<>();
        
        for (Employee e : employeeList) {
            if(e.getClass().equals(c))
                temp.add(e);
        }
        return temp;
    }
    
    public void printTheList(ArrayList<Employee> list){
        for (Employee e : list) {
            System.out.println(e);
        }
    }
}