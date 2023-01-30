package KodlamaIo.hrms.core.adapter.concretes;

import org.springframework.stereotype.Service;

import KodlamaIo.hrms.core.adapter.abstracts.JobSeekerCheckService;
import KodlamaIo.hrms.core.result.ErrorResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements JobSeekerCheckService {

	@Override
	public Result checkIfRealPerson(JobSeeker jobSeekers) throws Exception {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeekers.getNationalIdentitiy()), jobSeekers.getEmail(), jobSeekers.getLastName(), jobSeekers.getBirthOfYear());
		
		if(result == false) {
			return new ErrorResult();
		}
		
		return new SuccessResult();
	}

}

