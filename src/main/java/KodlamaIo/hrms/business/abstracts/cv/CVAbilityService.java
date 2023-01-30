package KodlamaIo.hrms.business.abstracts.cv;
import java.util.List;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVAbility;

public interface CVAbilityService {
    Result add(CVAbility cvAbility);
    Result delete(int id);
    Result update(CVAbility cvAbility);

    DataResult<List<CVAbility>> getAll();

    DataResult<List<CVAbility>> getAllByCandidateId(int id);
}
