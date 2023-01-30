package KodlamaIo.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.cv.CVEducationService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.Cv.CVEducationDao;
import KodlamaIo.hrms.entities.concretes.Cv.CVEducation;

@Service
public class CVEducationManager implements CVEducationService {
	private CVEducationDao cvEducationDao;

	@Autowired
	public CVEducationManager(CVEducationDao cvEducationDao) {
		this.cvEducationDao = cvEducationDao;
	}

	@Override
	public Result add(CVEducation cvEducation) {
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("Okul Başarıyla Eklendi!");
	}

	@Override
	public Result update(CVEducation cvEducation) {
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("Okul Başarıyla Güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.cvEducationDao.deleteById(id);
		return new SuccessResult("Okul Başarıyla Silindi!");
	}

	@Override
	public DataResult<List<CVEducation>> getAll() {
		return new SuccessDataResult<List<CVEducation>>(this.cvEducationDao.findAll());
	}

	@Override
	public DataResult<List<CVEducation>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CVEducation>>(this.cvEducationDao.findByJobSeekerId(id));
	}

	@Override
	public DataResult<List<CVEducation>> getAllByCandidateIdOrderByGraduationYearDesc(int id) {
		return new SuccessDataResult<List<CVEducation>>(
				this.cvEducationDao.getAllByJobSeeker_IdOrderByGraduationYearDesc(id));
	}
}
