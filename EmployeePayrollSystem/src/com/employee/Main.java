package com.employee;

import java.util.ArrayList;

//import com.employee.FullTimeEmployee.payrollSystem;

// abstract class
abstract class Employee
{
		private String name;
		private int id;
		// construct 
		public Employee(String name ,int id)
			{
			this.name=name;//this refer to current object
			this.id=id;
			}
		//Getter and Setter
		 public String getName()
		  	{
			 return name; 
		  	}
	     public  int getId()
	     	{
	    	 return id;
	     	}
	    public abstract double calculateSalary();
	    @Override
	    public  String toString()// object as string we use toString
	    {
			return "Employee [name="+name+", id="+id+",salary="+calculateSalary()+"]";
	    
	    }
}
class FullTimeEmployee extends Employee{
	
	private double monthlySalary;
	public FullTimeEmployee(String name,int id,double monthlySalary)
		{
		super(name ,id);
		this.monthlySalary=monthlySalary;
		}
		@Override
	public double calculateSalary()
		{
			return  monthlySalary;
		}
}
class partTimeEmployee extends Employee
	{
	private int hoursWorked;
	private double hourlyRate;
	public partTimeEmployee(String name, int id,int hoursWorked,double hourlyRate) {
		super(name, id);
		this .hoursWorked=hoursWorked;
		this.hourlyRate=hourlyRate;
	}	
	
	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		 return hoursWorked*hourlyRate;
	}
}


class payrollSystem
	{
	private ArrayList <Employee> employeeList;
	
	public payrollSystem()
	{
		employeeList=new ArrayList<>();
	}
	
	public void addEmployee(Employee employee)
	{
		employeeList.add(employee);
	}
	
	public void removeemployee(int id)
	{
		Employee employeeToRemove=null;
		for(Employee employee:employeeList)
		{
			if(employee.getId()==id)
			{
				employeeToRemove=employee;
				break;
			}
		}
		if(employeeToRemove!=null)
		{
			employeeList.remove(employeeToRemove);
		}
	}
	
	public void displayEmployee()
	{
		for(Employee employee:employeeList)
		{
			System.out.println(employee);
		}
		
	}
}
	
	
public class Main {
public static void main(String[] args) {
		 payrollSystem ps=new  payrollSystem();
		 FullTimeEmployee emp1=new FullTimeEmployee("shruthi", 1,70000);
		 partTimeEmployee emp2=new partTimeEmployee("shwetha", 2, 40, 1000);
		 payrollSystem payrollSystem = new payrollSystem();
		payrollSystem.addEmployee(emp1);
		payrollSystem.addEmployee(emp2);
		System.out.println("intial employee Details");
		payrollSystem.displayEmployee();
		System.out.println("removing Employees");
		payrollSystem.removeemployee(2);
		System.out.println("Remaioning Employee Details");
		payrollSystem.displayEmployee();
		
}
}

