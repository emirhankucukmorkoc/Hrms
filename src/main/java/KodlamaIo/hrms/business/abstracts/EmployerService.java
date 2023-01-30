package KodlamaIo.hrms.business.abstracts;

import java.util.List;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result register(Employer employer);

	DataResult<List<Employer>> getAll();
	

}
