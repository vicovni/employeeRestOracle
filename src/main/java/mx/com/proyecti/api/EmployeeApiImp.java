package mx.com.proyecti.api;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.com.proyecti.Employee;
import mx.com.proyecti.EmployeeSoapProxy;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@EnableAutoConfiguration
public class EmployeeApiImp {
	
	EmployeeSoapProxy emp = new EmployeeSoapProxy();
	
	@RequestMapping("/")
	String hello(@RequestParam String who) {
		return "Hello " + who;
	}

	@RequestMapping("/getAllEmployees")
	public Employee[] getAllEmployees() {
		try {
			return emp.readAll();
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/createEmployee")
	public Employee createEmployee(@RequestParam String firstName, 
			@RequestParam String lastName, 
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date birthdate, 
			@RequestParam double salary,
			@RequestParam String username,
			@RequestParam String password
			) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(birthdate);
			return emp.create(firstName, lastName, calendar, salary, username, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/getEmployee")
	Employee getEmployee(@RequestParam(value="id") int idEmployee) {
		try {
			return emp.read(idEmployee);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/deleteEmployee")
	public boolean deleteEmployee(@RequestParam(value="id")int idEmployee) {
		try {
			emp.delete(idEmployee);
			return true;
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping("/updateEmployee")
	public Employee updateEmployee(
			@RequestParam(value="id")int idEmployee, 
			@RequestParam(value="firstName")String firstName, 
			@RequestParam(value="lastName")String lastName, 
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@RequestParam(value="birthdate")Calendar date, 
			@RequestParam(value="salary")double salary,
			@RequestParam(value="username")String userName,
			@RequestParam(value="password")String password
			) {
		try {
			return emp.update(idEmployee, firstName, lastName, date, salary, userName, password);
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiImp.class, args);

	}

}
