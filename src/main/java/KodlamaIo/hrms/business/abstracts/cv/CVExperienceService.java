package KodlamaIo.hrms.business.abstracts.cv;
import java.util.List;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVExperience;

public interface CVExperienceService {
    Result add(CVExperience cvExperience);
    Result update(CVExperience cvExperience);
    Result delete(int id);

    DataResult<List<CVExperience>> getAll();

    DataResult<List<CVExperience>> getAllByCandidateId(int id);

    DataResult<List<CVExperience>> getAllByCandidateIdOrderByLeaveDateDesc(int id);
}
