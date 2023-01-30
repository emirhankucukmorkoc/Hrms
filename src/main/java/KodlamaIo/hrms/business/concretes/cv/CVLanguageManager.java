package KodlamaIo.hrms.business.concretes.cv;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.cv.CVLanguageService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.Cv.CVLanguageDao;
import KodlamaIo.hrms.entities.concretes.Cv.CVLanguage;

@Service
public class CVLanguageManager implements CVLanguageService {
    private CVLanguageDao cvLanguageDao;

    @Autowired
    public CVLanguageManager(CVLanguageDao cvLanguageDao) {
        this.cvLanguageDao = cvLanguageDao;
    }

    @Override
    public Result add(CVLanguage cvLanguage) {
        this.cvLanguageDao.save(cvLanguage);
        return new SuccessResult("Dil Başarıyla Eklendi!");
    }

    @Override
    public Result update(CVLanguage cvLanguage) {
        this.cvLanguageDao.save(cvLanguage);
        return new SuccessResult("Dil Başarıyla Güncellendi!");
    }

    @Override
    public Result delete(int id) {
        this.cvLanguageDao.deleteById(id);
        return new SuccessResult("Dil Başarıyla Silindi!");
    }

    @Override
    public DataResult<List<CVLanguage>> getAll() {
        return new SuccessDataResult<List<CVLanguage>>(this.cvLanguageDao.findAll());
    }

    @Override
    public DataResult<List<CVLanguage>> getAllByCandidateId(int id) {
        return new SuccessDataResult<List<CVLanguage>>(this.cvLanguageDao.findByJobSeekerId(id));
    }
}
