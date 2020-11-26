// A Java program to demonstrate working of 
// Composite Design Pattern with example 
// of a company with different 
// employee details 

import java.util.ArrayList; 
import java.util.List; 


interface Employee
{
	public void showEmployeeDetails();
}

class Developer implements Employee
{
	private String name;
	private long empId;
	private String position;
	
	public Developer(String name, long empId, String position)
	{
		this.name = name;
		this.empId = empId;
		this.position = position;
	}
	
	@override
	public void showEmployeeDetails()
	{
		System.out.println(empId+" "+name+" "+position);
	}
	
}

class Manager implements Employee
{
    private String name;
	private long empId;
	private String position;
	
	public Manager(String name, long empId, String position)
	{
		this.name = name;
		this.empId = empId;
		this.position = position;
	}
	
	@override
	public void showEmployeeDetails()
	{
		System.out.println(empId+" "+name+" "+position);
	}
}

class CompanyDirector implements Employee
{
	private List<Employee> employeeList = new ArrayList<Employee>();
	
	@override
	public void showEmployeeDetails()
	{
		for(Employee emp:employeeList)
		{
			emp.showEmployeeDetails();
		}
	}
	
    public addEmployee(Employee emp)
	{
		employeeList.add(emp);
	}
	
	public void removeEmployee(Employee emp)
	{
		employeeList.remove(emp);
	}	
}

public class Company
{
	public static void main(String args[])
	{
		Developer abebe = new Developer(100, "abebe", "BB_DEV");
		Developer kebede = new Developer(200, "kebede", "BB_DEV");
		
		CompanyDirector engDirector = new CompanyDirector();
		engDirector.addEmployee(abebe);
		engDirector.addEmployee(kebede);
		
		Manager man1 = new Manager();
		Manager man2 = new Manager();
		
		CompanyDirector accDirector = new CompanyDirector();
		accDirector.addEmployee(man1);
		accDirector.addEmployee(man2);
		
		CompanyDirector generalDirector = new CompanyDirector();
		generalDirector.addEmployee(engDirector);
		generalDirector.addEmployee(accDirector);
		generalDirector.showEmployeeDetails();
	}
}