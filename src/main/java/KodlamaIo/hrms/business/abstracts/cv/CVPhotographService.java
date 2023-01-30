package KodlamaIo.hrms.business.abstracts.cv;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVPhotograph;

public interface CVPhotographService {

	Result add(CVPhotograph cvPhotograph, MultipartFile multipartFile);

	Result delete(CVPhotograph cvPhotograph);

	DataResult<List<CVPhotograph>> getAll();

	DataResult<List<CVPhotograph>> getById(int id);

	DataResult<List<CVPhotograph>> getAllByCandidateId(int id);
}
