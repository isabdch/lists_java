package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class EmployeesSalary {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n, idIncreaseSalary;
		double salaryPercentage;
		boolean isDuplicateId = false;

		List<Employee> employeesList = new ArrayList<>();

		Integer id;
		String name;
		Double salary;

		do {
			System.out.print("How many employees will be registered? ");
			n = sc.nextInt();

			if (n < 1) {
				System.out.println("Invalid number. Enter again.\n");
			}
		} while (n < 1);

		for (int i = 0; i < n; i++) {
			do {
				System.out.println("\nEmployee #" + (i + 1) + ":");

				System.out.print("Id: ");
				id = sc.nextInt();

				for (Employee employee : employeesList) {
					if (employee.getId().equals(id)) {
						isDuplicateId = true;
					} else {
						isDuplicateId = false;
					}
				}

				if (isDuplicateId == false) {
					System.out.print("Name: ");
					sc.nextLine();
					name = sc.nextLine();

					System.out.print("Salary: ");
					salary = sc.nextDouble();

					employeesList.add(new Employee(id, name, salary));
				} else {
					System.out.println("Id already exists. Enter a new id.");
				}
			} while (isDuplicateId == true);
		}

		System.out.print("\nEnter the employee id that will have salary increase: ");
		idIncreaseSalary = sc.nextInt();

		Employee employeeIncreasedSalary = employeesList.stream().filter(x -> x.getId() == idIncreaseSalary).findAny()
				.orElse(null);

		if (employeeIncreasedSalary != null) {
			System.out.print("Enter the percentage: ");
			salaryPercentage = sc.nextDouble();

			employeeIncreasedSalary.increaseSalary(salaryPercentage);
		} else {
			System.out.println("This id does not exist!");
		}

		System.out.println("\nList of employees:");

		for (Employee employee : employeesList) {
			System.out.println(employee);
		}

		sc.close();
	}

}
