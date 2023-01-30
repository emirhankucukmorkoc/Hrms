package KodlamaIo.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KodlamaIo.hrms.entities.concretes.Employer;


@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {


}
