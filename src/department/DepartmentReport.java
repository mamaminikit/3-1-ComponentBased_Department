package department;

import java.util.Collection;
import java.util.List;
import model.Department;
import model.DepartmentTable;
import model.Employee;
import model.EmployeeTable;

/*
 * @mmmaimankarae
 */

public class DepartmentReport {
    public static void main(String[] args) {
        /* Show All Employee */
        System.out.println("All Employee (By ID)");
        System.out.println("---------------------------");
        List<Employee> empID = EmployeeTable.FindAllEmployee();
        for(Employee emp : empID){
            System.out.println("ID: " + emp.getEmployeeid());
            System.out.println("Name: " + emp.getName());
            System.out.println("Job: " + emp.getJob());
            System.out.println("Salary: " + emp.getSalary());
            System.out.println("Department: " + emp.getDepartmentid().getName());
            System.out.println("---------------------------");
        }
        
        /* Show All Employee in Department */
        System.out.println("All employee (by Department)");
        List<Department> depList = DepartmentTable.FindAllDepartment();
        System.out.println("---------------------------");
        for(Department dep : depList){
            System.out.print("Department ID: " + dep.getDepartmentid());
            System.out.println("\tDepartment Name: " + dep.getName());
            System.out.println("---------------------------");
            Collection<Employee> allEmp = dep.getEmployeeCollection();
            for(Employee emp : allEmp){
                System.out.println("ID: " + emp.getEmployeeid());
                System.out.println("Name: " + emp.getName());
                System.out.println("Job: " + emp.getJob());
                System.out.println("Salary: " + emp.getSalary());
                System.out.println("---------------------------");
            }
        }
    }
}
