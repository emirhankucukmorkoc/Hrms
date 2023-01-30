package KodlamaIo.hrms.business.validation;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.stereotype.Service;

import KodlamaIo.hrms.core.result.ErrorResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.JobSeekerDao;
import KodlamaIo.hrms.entities.concretes.Employer;
import KodlamaIo.hrms.entities.concretes.JobSeeker;


@Service
public class ValidationRules {

	private EmailValidator emailValidator = new EmailValidator();
	private JobSeekerDao jobSeekerDao;
	
	

	public void CheckIfRealPerson(JobSeeker jobSeeker) throws NumberFormatException, RemoteException {
		
	}

	public boolean HowLongIsTheCharacterLength(JobSeeker jobSeeker) {
		if (jobSeeker.getFirstName().length() <= 2 || jobSeeker.getLastName().length() <= 2) {
			return  true;
		} else
			return false;
	}

	public boolean HowLongIsThePassword(JobSeeker jobSeeker) {
		if (jobSeeker.getPassword().length() < 5) {
			return  true;
		}
		return false;
	}

	public boolean IsEmailTrue(JobSeeker jobSeeker) {

		if (!emailValidator.ptr.matcher(jobSeeker.getEmail()).matches()) {
			System.out.println();
			return true;
		}
		return false;

	}

	public boolean isEmptyOneOfTheFields(JobSeeker jobSeeker) {
		if (jobSeeker.getEmail() == null || jobSeeker.getFirstName() == null || jobSeeker.getLastName() == null
				|| jobSeeker.getNationalIdentitiy() == null || jobSeeker.getPassword() == null
				|| jobSeeker.getPassword2() == null || jobSeeker.getBirthOfYear() == 0) {
			System.out.println();
			return true;
		}
		return false;
	}

	public boolean isEmpty(Employer employer) {
		if (employer.getEmailTheWebSitesDomain() == null || employer.getNameOfCompany() == null
				|| employer.getPassword() == null || employer.getPhoneNumber() == null
				|| employer.getWebSite() == null) {
			return true;
		}else {
			
		
		return false;
		}
		
	}

	public boolean isPasswordTrue(JobSeeker jobSeeker) {
		if (jobSeeker.getPassword().equals(jobSeeker.getPassword2())) {
			return false;

		} else {

			return true;

		}

	}
	public Result isEmailExist(JobSeeker jobSeeker) {
		List<JobSeeker> jobSeekers = this.jobSeekerDao.findAll();
		for (JobSeeker jobSeeker2 : jobSeekers) {
			if (jobSeeker2.getEmail().equals(jobSeeker.getEmail())) {
				System.out.println("This email already exist. ");
				return new ErrorResult("The passwords you entered do not match.");
			}

		}
		return new SuccessResult();
	}

	

}
