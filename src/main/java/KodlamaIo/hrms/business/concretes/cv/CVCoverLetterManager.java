package KodlamaIo.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.cv.CVCoverLetterService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.Cv.CVCoverLetterDao;
import KodlamaIo.hrms.entities.concretes.Cv.CVCoverLetter;

@Service
public class CVCoverLetterManager implements CVCoverLetterService {
	private CVCoverLetterDao cvCoverLetterDao;

	@Autowired
	public CVCoverLetterManager(CVCoverLetterDao cvCoverLetterDao) {
		this.cvCoverLetterDao = cvCoverLetterDao;
	}

	@Override
	public Result add(CVCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Ön Yazı Başarıyla Eklendi!");
	}

	@Override
	public Result update(CVCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Ön Yazı Başarıyla Güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.cvCoverLetterDao.deleteById(id);
		return new SuccessResult("Ön Yazı Başarıyla Silindi!");
	}

	@Override
	public DataResult<List<CVCoverLetter>> getAll() {
		return new SuccessDataResult<List<CVCoverLetter>>(this.cvCoverLetterDao.findAll());
	}


	@Override
	public DataResult<List<CVCoverLetter>> findByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<CVCoverLetter>>(this.cvCoverLetterDao.findByJobSeekerId(jobSeekerId));

	}
}
