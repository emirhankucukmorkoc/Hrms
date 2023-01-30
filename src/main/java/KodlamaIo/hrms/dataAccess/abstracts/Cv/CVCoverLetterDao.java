package KodlamaIo.hrms.dataAccess.abstracts.Cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.Cv.CVCoverLetter;

public interface CVCoverLetterDao extends JpaRepository<CVCoverLetter, Integer> {

	List<CVCoverLetter> findByJobSeekerId(int jobSeekerId);

}
