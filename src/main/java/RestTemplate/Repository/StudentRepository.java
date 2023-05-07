package RestTemplate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import RestTemplate.Entity.Students;

public interface StudentRepository extends JpaRepository<Students, Integer> {

}
