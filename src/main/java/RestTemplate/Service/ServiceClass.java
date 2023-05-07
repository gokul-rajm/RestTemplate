package RestTemplate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RestTemplate.Entity.Employee;
import RestTemplate.Entity.Students;
import RestTemplate.Repository.EmployeeRepository;
import RestTemplate.Repository.StudentRepository;

@Service
public class ServiceClass {
	
	@Autowired 
	EmployeeRepository employeeRepository;
	
	@Autowired
	StudentRepository studentRepository;

	public Employee postEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getEmployee(Employee employee) {
		return employeeRepository.findAll();
	}
	
	public Students postStudents(Students students) {
		return studentRepository.save(students);
	}

	public List<Students> getStudents(Students students) {
		return studentRepository.findAll();
	}
}
