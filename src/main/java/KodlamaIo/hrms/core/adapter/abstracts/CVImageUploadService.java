package KodlamaIo.hrms.core.adapter.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import KodlamaIo.hrms.core.result.DataResult;

public interface CVImageUploadService {

    @SuppressWarnings("rawtypes")
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
