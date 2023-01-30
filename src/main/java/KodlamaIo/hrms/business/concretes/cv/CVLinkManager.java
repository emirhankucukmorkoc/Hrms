package KodlamaIo.hrms.business.concretes.cv;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.cv.CVLinkService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.Cv.CVLinkDao;
import KodlamaIo.hrms.entities.concretes.Cv.CVLink;

@Service
public class CVLinkManager implements CVLinkService {

    private CVLinkDao cvLinkDao;

    @Autowired
    public CVLinkManager(CVLinkDao cvLinkDao) {
        this.cvLinkDao = cvLinkDao;
    }

    @Override
    public Result add(CVLink cvLink) {
        this.cvLinkDao.save(cvLink);
        return new SuccessResult("Link Başarıyla Eklendi!");
    }

    @Override
    public Result update(CVLink cvLink) {
        this.cvLinkDao.save(cvLink);
        return new SuccessResult("Link Başarıyla Güncellendi!");
    }

    @Override
    public Result delete(int id) {
        this.cvLinkDao.deleteById(id);
        return new SuccessResult("Link Başarıyla Silindi!");
    }

    @Override
    public DataResult<List<CVLink>> getAll() {
        return new SuccessDataResult<List<CVLink>>(this.cvLinkDao.findAll());
    }

    @Override
    public DataResult<List<CVLink>> getAllByCandidateId(int id) {
        return new SuccessDataResult<List<CVLink>>(this.cvLinkDao.findByJobSeekerId(id));
    }
}
