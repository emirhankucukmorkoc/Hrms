package KodlamaIo.hrms.dataAccess.abstracts.Cv;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.Cv.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {

	CurriculumVitae findByJobSeekerId(int jobSeekerId);

}
