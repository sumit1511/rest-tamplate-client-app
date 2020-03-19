package org.example;


import com.java.config.AppConfig;
import com.java.config.EmployeeClient;
import com.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;



public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        EmployeeClient client = applicationContext.getBean(EmployeeClient.class);

        System.out.println("Getting list of all people:");

        for (Employee employee : client.getAllEmployee()) {
            System.out.println(employee);
        }


        System.out.println("Adding a Person");
        Employee employee = new Employee();
        employee.setEmpName("suresh");
        employee.setEmpAge(23);
        employee.setEmpCity("japur");
        employee.setEmpDept("SLS");

        Employee status = client.addEmployee(employee);
        System.out.println("Add Person Response = " + status);

        applicationContext.close();
    }
}
