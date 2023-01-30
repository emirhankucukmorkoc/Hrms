package KodlamaIo.hrms.api.controllers.cv;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import KodlamaIo.hrms.business.abstracts.cv.CVPhotographService;
import KodlamaIo.hrms.core.adapter.abstracts.CVImageUploadService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVPhotograph;

@RestController
@RequestMapping("/api/photographs")
public class CVPhotographsController {

	private CVPhotographService cvPhotographService;
	private CVImageUploadService cvImageUploadService;

	@Autowired
	public CVPhotographsController(CVPhotographService cvPhotographService, CVImageUploadService cvImageUploadService) {
		super();
		this.cvPhotographService = cvPhotographService;
		this.cvImageUploadService = cvImageUploadService;
	}

	@PostMapping("/image")
	public DataResult<Map> add(@RequestParam("imageFile") MultipartFile imageFile) {
		Objects.requireNonNull(imageFile, "imageFile cannot be null.");
		return cvImageUploadService.uploadImageFile(imageFile);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody CVPhotograph cvPhotograph) {
		return this.cvPhotographService.delete(cvPhotograph);
	}

	@GetMapping("/getAll")
	public DataResult<List<CVPhotograph>> getAll() {
		return this.cvPhotographService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<List<CVPhotograph>> getById(@RequestParam("id") int id) {
		return this.cvPhotographService.getById(id);
	}

	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CVPhotograph>> getAllByCandidateId(@RequestParam("candidate_id") int id) {
		return this.cvPhotographService.getAllByCandidateId(id);
	}

}
