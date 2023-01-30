package KodlamaIo.hrms.core.adapter.concretes;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import KodlamaIo.hrms.core.adapter.abstracts.CVImageUploadService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.ErrorDataResult;
import KodlamaIo.hrms.core.result.SuccessDataResult;

@Service
public class CVImageUploadManager implements CVImageUploadService {
	private Cloudinary cloudinary;

	public CVImageUploadManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dzgnkcxlm", "api_key", "197927988459398",
				"api_secret", "Dwjmfqau4wYcfq47RxvD5r3hGaU"));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		Objects.requireNonNull(imageFile, "imageFile cannot be null.");

		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(),
					ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}

}

