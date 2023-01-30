package KodlamaIo.hrms.core.adapter.abstracts;

import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.JobSeeker;

public interface JobSeekerCheckService {
	Result checkIfRealPerson(JobSeeker jobSeeker) throws Exception;

}
