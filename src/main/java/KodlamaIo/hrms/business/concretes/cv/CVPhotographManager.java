package KodlamaIo.hrms.business.concretes.cv;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import KodlamaIo.hrms.business.abstracts.cv.CVPhotographService;
import KodlamaIo.hrms.core.adapter.abstracts.CVImageUploadService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.Cv.CVPhotographDao;
import KodlamaIo.hrms.entities.concretes.Cv.CVPhotograph;

@Service
public class CVPhotographManager implements CVPhotographService {
	private CVPhotographDao cvPhotographDao;
	private CVImageUploadService cvImageUploadService;

	@Autowired
	public CVPhotographManager(CVPhotographDao cvPhotographDao, CVImageUploadService cvImageUploadService) {
		this.cvPhotographDao = cvPhotographDao;
		this.cvImageUploadService = cvImageUploadService;
	}

	
	
	@Override
	public Result add(CVPhotograph cvPhotograph, MultipartFile multipartFile) {
		@SuppressWarnings("unchecked")
		Map<String, String> result = this.cvImageUploadService.uploadImageFile(multipartFile).getData();
		String url = result.get("url");
		cvPhotograph.setPhotoLink(url);
		return new SuccessResult("Fotoğraf Başarıyla Eklendi!");
	}

	@Override
	public Result delete(CVPhotograph cvPhotograph) {
		this.cvPhotographDao.delete(cvPhotograph);
		return new SuccessResult("Fotoğraf Başarıyla Silindi!");
	}

	@Override
	public DataResult<List<CVPhotograph>> getAll() {
		return new SuccessDataResult<>(this.cvPhotographDao.findAll());
	}

	@Override
	public DataResult<List<CVPhotograph>> getById(int id) {
		return new SuccessDataResult<>(this.cvPhotographDao.getById(id));
	}

	@Override
	public DataResult<List<CVPhotograph>> getAllByCandidateId(int id) {
		return new SuccessDataResult<>(this.cvPhotographDao.findByJobSeekerId(id));
	}
}
