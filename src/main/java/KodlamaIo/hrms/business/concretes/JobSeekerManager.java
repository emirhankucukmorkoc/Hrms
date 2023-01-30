package KodlamaIo.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.JobSeekerService;
import KodlamaIo.hrms.business.validation.ValidationRules;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.ErrorResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.JobSeekerDao;
import KodlamaIo.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private ValidationRules validationRules;

	public JobSeekerManager(JobSeekerDao jobSeekerDao, ValidationRules validationRules) {
		this.jobSeekerDao = jobSeekerDao;
		this.validationRules = validationRules;
	}

	@Override
	public Result register(JobSeeker jobSeeker) throws Exception {
		if (validationRules.HowLongIsTheCharacterLength(jobSeeker)) {
			return new ErrorResult("First name and surname can't be less than 2 characters");

		}
		/*
		 * else if (!jobSeekerCheckService.checkIfRealPerson(jobSeeker).isSuccess()) {
		 * return new ErrorResult("Please check your information");
		 * 
		 * b * }
		 */ else if (validationRules.HowLongIsThePassword(jobSeeker)) {
			return new ErrorResult("Password must be at least 6 characters.");

		} else if (validationRules.IsEmailTrue(jobSeeker)) {
			return new ErrorResult("Wrong e-mail entered.");

		} else if (validationRules.isEmptyOneOfTheFields(jobSeeker)) {
			return new ErrorResult("Please fill in the blanks");

		} else if (validationRules.isPasswordTrue(jobSeeker)) {
			return new ErrorResult("The passwords you entered do not match ");

		} else if (isEmailExist(jobSeeker)) {
			return new ErrorResult("This email is already exist in the system");

		} else {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Dear " + jobSeeker.getFirstName() + " " + jobSeeker.getLastName()
					+ " You have successfully registered. " + "Please click on the link in the e-mail we sent to "
					+ jobSeeker.getEmail() + " to confirm the e-mail address. ");
		}
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), " the job seekers listed.");
	}

	public boolean isEmailExist(JobSeeker jobSeeker) {
		List<JobSeeker> jobSeekers = this.jobSeekerDao.findAll();
		for (JobSeeker jobSeeker2 : jobSeekers) {
			if (jobSeeker2.getEmail().equals(jobSeeker.getEmail())) {
				System.out.println("This email already exist. ");
				return true;
			}

		}
		return false;
	}

}
