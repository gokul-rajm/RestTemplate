package RestTemplate.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import RestTemplate.Entity.Employee;
import RestTemplate.Entity.Students;
import RestTemplate.Service.ServiceClass;

@RestController
public class ControllerClass {

	@Autowired
	private ServiceClass serviceClass;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/postEmployee")
	public Employee postEmployee(@RequestBody Employee employee) {
		return serviceClass.postEmployee(employee);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getEmployee(Employee employee) {
		return serviceClass.getEmployee(employee);
	}
	
	@PostMapping("/postStudents")
	public Students postStudents(@RequestBody Students students) {
		return serviceClass.postStudents(students);
	}
		
	@GetMapping("/getAllStudents")
	public List<Students> getStudents(Students students) {
		return serviceClass.getStudents(students);
	}
	
	 @GetMapping("/get")
	   public String getList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
	      
	      String getEmployee = restTemplate.exchange("http://localhost:8080/getAllEmployee", HttpMethod.GET, entity, String.class).getBody();
	      String getStudent = restTemplate.exchange("http://localhost:8080/getAllStudents", HttpMethod.GET, entity, String.class).getBody();
	      
	      return getEmployee+"\n"+getStudent;
	 }
}
