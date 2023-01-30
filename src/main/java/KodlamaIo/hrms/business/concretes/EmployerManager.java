package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.EmployerService;
import KodlamaIo.hrms.business.validation.ValidationRules;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.ErrorResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.EmployerDao;
import KodlamaIo.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private ValidationRules validationRules = new ValidationRules();

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public Result register(Employer employer) {

		if (validationRules.isEmpty(employer)) {
			return new ErrorResult("Please fill in the blanks");

		} else if (isEmailExist(employer)) {
			return new ErrorResult("This email already exist.");

		} else {
			this.employerDao.save(employer);
			return new SuccessResult("Company of " + employer.getNameOfCompany() + " You have successfully registered. "
					+ "Please click on the link in the e-mail we sent to " + employer.getEmailTheWebSitesDomain()
					+ " to confirm the e-mail address. ");
		}

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), " employers listed");

	}


	
	public boolean isEmailExist(Employer employer){
		List<Employer> employers = this.employerDao.findAll();
		for (Employer employer2 : employers) {
			if (employer.getEmailTheWebSitesDomain().equals(employer2.getEmailTheWebSitesDomain())) {
				return true;
			}
		}
		
		return false;
		
	}

	
}
