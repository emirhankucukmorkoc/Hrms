package KodlamaIo.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.cv.CVAbilityService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.Cv.CVAbilityDao;
import KodlamaIo.hrms.entities.concretes.Cv.CVAbility;

@Service
public class CVAbilityManager implements CVAbilityService {
	private CVAbilityDao cvAbilityDao;

	@Autowired
	public CVAbilityManager(CVAbilityDao cvAbilityDao) {
		this.cvAbilityDao = cvAbilityDao;
	}

	@Override
	public Result add(CVAbility cvAbility) {
		this.cvAbilityDao.save(cvAbility);
		return new SuccessResult("Yeni Yetenek Eklendi!");
	}

	@Override
	public Result delete(int id) {
		this.cvAbilityDao.deleteById(id);
		return new SuccessResult("Yetenek Silindi!");
	}

	@Override
	public Result update(CVAbility cvAbility) {
		this.cvAbilityDao.save(cvAbility);
		return new SuccessResult("Yetenek Güncellendi!");
	}

	@Override
	public DataResult<List<CVAbility>> getAll() {
		return new SuccessDataResult<List<CVAbility>>(this.cvAbilityDao.findAll());
	}

	@Override
	public DataResult<List<CVAbility>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CVAbility>>(this.cvAbilityDao.findByJobSeekerId(id));
	}
}
