package KodlamaIo.hrms.business.abstracts.cv;
import java.util.List;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVLanguage;

public interface CVLanguageService {
    Result add(CVLanguage cvLanguage);
    Result update(CVLanguage cvLanguage);
    Result delete(int id);

    DataResult<List<CVLanguage>> getAll();
    DataResult<List<CVLanguage>> getAllByCandidateId(int id);
}
