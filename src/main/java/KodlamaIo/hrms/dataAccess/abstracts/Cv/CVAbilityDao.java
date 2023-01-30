package KodlamaIo.hrms.dataAccess.abstracts.Cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIo.hrms.entities.concretes.Cv.CVAbility;

public interface CVAbilityDao extends JpaRepository<CVAbility, Integer> {

	List<CVAbility> findByJobSeekerId(int jobSeekerId);

}
