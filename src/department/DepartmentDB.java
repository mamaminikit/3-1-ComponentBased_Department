package department;


import model.Department;
import model.Employee;
import model.DepartmentTable;
import model.EmployeeTable;

/*
 * @mmmaimankarae
 */

public class DepartmentDB {
    
    public static void main(String[] args) {
        /* Fill in DepartmentDB Detail */
        Department dep1 = new Department(1, "IT");
        Department dep2 = new Department(2, "HR");
        
        /* Insert Data into Database */
        DepartmentTable.InsertDepartment(dep1);
        DepartmentTable.InsertDepartment(dep2);
        
        /* Fill in Employee Detail */
        Employee emp1 = new Employee(1, "John", "Network Admin", 56789.00, dep1);
        Employee emp2 = new Employee(2, "Marry", "HR Manager", 46789.00, dep2);
        Employee emp3 = new Employee(3, "Herry", "Programmer", 67890.00, dep1);
        Employee emp4 = new Employee(4, "Clark", "HR recruiter", 36789.00, dep2);
        
        /* Insert Data into Database */
        EmployeeTable.InsertEmployee(emp1);
        EmployeeTable.InsertEmployee(emp2);
        EmployeeTable.InsertEmployee(emp3);
        EmployeeTable.InsertEmployee(emp4); 
    }    
}
