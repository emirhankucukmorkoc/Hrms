package KodlamaIo.hrms.business.abstracts.cv;

import java.util.List;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVCoverLetter;

public interface CVCoverLetterService {
	Result add(CVCoverLetter cvCoverLetter);

	Result update(CVCoverLetter cvCoverLetter);

	Result delete(int id);

	DataResult<List<CVCoverLetter>> getAll();

	DataResult<List<CVCoverLetter>> findByJobSeekerId(int jobSeekerId);

}
