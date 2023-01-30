package KodlamaIo.hrms.dataAccess.abstracts.Cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.Cv.CVPhotograph;

public interface CVPhotographDao extends JpaRepository<CVPhotograph, Integer> {
	List<CVPhotograph> getById(int id);

	List<CVPhotograph> findByJobSeekerId(int jobSeekerId);

}
