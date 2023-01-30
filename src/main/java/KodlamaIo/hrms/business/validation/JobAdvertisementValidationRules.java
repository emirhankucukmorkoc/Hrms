package KodlamaIo.hrms.business.validation;

import KodlamaIo.hrms.entities.concretes.JobAdvertisement;

public class JobAdvertisementValidationRules {
	
	
	


	public boolean isActive(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.isActive()) {
			return true;
		}else {
			return false;
		}
	}

}
