package KodlamaIo.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KodlamaIo.hrms.entities.concretes.JobPosition;

@Repository
public interface JobPositionDao  extends JpaRepository<JobPosition, Integer>{

}
