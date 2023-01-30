package KodlamaIo.hrms.business.abstracts;

import java.util.List;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	Result register(JobSeeker jobSeeker) throws Exception;
	DataResult<List<JobSeeker>> getAll();


}
