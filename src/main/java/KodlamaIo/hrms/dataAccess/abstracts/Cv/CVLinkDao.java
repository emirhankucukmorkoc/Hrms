package KodlamaIo.hrms.dataAccess.abstracts.Cv;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.Cv.CVLink;

public interface CVLinkDao extends JpaRepository<CVLink, Integer> {
	
	
	List<CVLink> findByJobSeekerId(int jobSeekerId);

}
