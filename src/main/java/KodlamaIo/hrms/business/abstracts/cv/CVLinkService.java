package KodlamaIo.hrms.business.abstracts.cv;
import java.util.List;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVLink;

public interface CVLinkService {
    Result add(CVLink cvLink);
    Result update(CVLink cvLink);
    Result delete(int id);

    DataResult<List<CVLink>> getAll();
    DataResult<List<CVLink>> getAllByCandidateId(int id);
}
