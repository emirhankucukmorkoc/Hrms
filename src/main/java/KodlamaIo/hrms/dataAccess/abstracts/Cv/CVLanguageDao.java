package KodlamaIo.hrms.dataAccess.abstracts.Cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.Cv.CVLanguage;

public interface CVLanguageDao extends JpaRepository<CVLanguage, Integer> {

	List<CVLanguage> findByJobSeekerId(int jobSeekerId);

}
