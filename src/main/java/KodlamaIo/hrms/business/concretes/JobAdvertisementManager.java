package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.JobAdvertisementService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.JobAdvertisementDao;
import KodlamaIo.hrms.entities.concretes.JobAdvertisement;
import KodlamaIo.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Posting Added");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getAllJobAdvertisementWithEmployerDtoByApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(this.jobAdvertisementDao.getAllJobAdvertisementWithEmployerDtoByApplicationDeadline(), "All Job Advertisement sorted by deadline");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getAllJobAdvertisementWithEmployerDtoByCompanyNameAndActive(
			String companyName) {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(
				this.jobAdvertisementDao.getAllJobAdvertisementWithEmployerDtoByCompanyNameAndActive(companyName),
				companyName + "'s job advertisements listed.");
	}

	@Override
	public Result changeIsActive(int id) {
		this.jobAdvertisementDao.changeIsActive(id);
		return new SuccessResult("Changed Activity Status Successfully");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetails() {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(
				this.jobAdvertisementDao.getJobAdvertisementWithEmployerDetails());
	}

}
