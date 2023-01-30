package KodlamaIo.hrms.dataAccess.abstracts.Cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import KodlamaIo.hrms.entities.concretes.Cv.CVEducation;

public interface CVEducationDao extends JpaRepository<CVEducation, Integer> {

	List<CVEducation> findByJobSeekerId(int jobSeekerId);


	@Query("From CVEducation  ORDER BY graduation_year DESC")
	List<CVEducation> getAllByJobSeeker_IdOrderByGraduationYearDesc(int id);
}
