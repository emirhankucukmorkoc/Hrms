package KodlamaIo.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.cv.CVExperienceService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.Cv.CVExperienceDao;
import KodlamaIo.hrms.entities.concretes.Cv.CVExperience;

@Service
public class CVExperienceManager implements CVExperienceService {
	private CVExperienceDao cvExperienceDao;

	@Autowired
	public CVExperienceManager(CVExperienceDao cvExperienceDao) {
		this.cvExperienceDao = cvExperienceDao;
	}

	@Override
	public Result add(CVExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Tecrübe Başarıyla Eklendi!");
	}

	@Override
	public Result update(CVExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Tecrübe Başarıyla Güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.cvExperienceDao.deleteById(id);
		return new SuccessResult("Tecrübe Başarıyla Silindi!");
	}

	@Override
	public DataResult<List<CVExperience>> getAll() {
		return new SuccessDataResult<List<CVExperience>>(this.cvExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CVExperience>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CVExperience>>(this.cvExperienceDao.findByJobSeekerId(id));

	}

	@Override
	public DataResult<List<CVExperience>> getAllByCandidateIdOrderByLeaveDateDesc(int id) {
		return new SuccessDataResult<List<CVExperience>>(
				this.cvExperienceDao.getAllByJobSeeker_IdOrderByLeaveDateDesc(id));

	}
}
