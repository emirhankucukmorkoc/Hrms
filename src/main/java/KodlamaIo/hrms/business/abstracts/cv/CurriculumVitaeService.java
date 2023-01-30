package KodlamaIo.hrms.business.abstracts.cv;

import java.util.List;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CurriculumVitae;
import KodlamaIo.hrms.entities.dtos.CVDto;

public interface CurriculumVitaeService {

	DataResult<CurriculumVitae> findByJobSeekerId(int jobSeekerId);

	DataResult<List<CurriculumVitae>> getAll();

	Result add(CurriculumVitae curriculumVitae);

	DataResult<CVDto> getJobseekerCVById(int id);

}
