package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.JobPositionService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.ErrorResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.JobPositionDao;
import KodlamaIo.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (isPositionExist(jobPosition)) {
			return new ErrorResult(	"This job is  already exist. ");
			
		}else {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("The job ("+jobPosition.getNameOfJob() +" ) is added");

		}
 
		}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<>(this.jobPositionDao.findAll()," jobs are listed");
	}

	public boolean isPositionExist(JobPosition jobPosition) {
		List<JobPosition> jobPositions = this.jobPositionDao.findAll();
		for (JobPosition jobPosition2 : jobPositions) {
			if (jobPosition2.getNameOfJob().equals(jobPosition.getNameOfJob())) {
				return true;
			}

		}
		return false;
	}

	

}
