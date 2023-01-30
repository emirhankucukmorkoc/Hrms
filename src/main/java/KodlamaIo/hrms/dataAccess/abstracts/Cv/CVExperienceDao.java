package KodlamaIo.hrms.dataAccess.abstracts.Cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import KodlamaIo.hrms.entities.concretes.Cv.CVExperience;

public interface CVExperienceDao extends JpaRepository<CVExperience, Integer> {

	List<CVExperience> findByJobSeekerId(int jobSeekerId);


	@Query("From CVExperience ORDER BY leave_date DESC")
	List<CVExperience> getAllByJobSeeker_IdOrderByLeaveDateDesc(int id);

}
