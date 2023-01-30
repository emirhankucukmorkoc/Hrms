package KodlamaIo.hrms.business.abstracts;

import java.util.List;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.JobAdvertisement;
import KodlamaIo.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisementWithEmployerDto>> getAllJobAdvertisementWithEmployerDtoByApplicationDeadline();

	DataResult<List<JobAdvertisementWithEmployerDto>> getAllJobAdvertisementWithEmployerDtoByCompanyNameAndActive(
			String companyName);

	Result changeIsActive(int id);

	DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetails();

}
