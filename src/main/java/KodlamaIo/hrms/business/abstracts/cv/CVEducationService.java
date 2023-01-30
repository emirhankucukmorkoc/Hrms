package KodlamaIo.hrms.business.abstracts.cv;
import java.util.List;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVEducation;

public interface CVEducationService {
    Result add(CVEducation cvEducation);
    Result update(CVEducation cvEducation);
    Result delete(int id);

    DataResult<List<CVEducation>> getAll();

    DataResult<List<CVEducation>> getAllByCandidateId(int id);

    DataResult<List<CVEducation>> getAllByCandidateIdOrderByGraduationYearDesc(int id);
}
