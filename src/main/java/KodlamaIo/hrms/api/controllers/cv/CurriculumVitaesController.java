package KodlamaIo.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.cv.CurriculumVitaeService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.entities.concretes.Cv.CurriculumVitae;
import KodlamaIo.hrms.entities.dtos.CVDto;

@RestController
@RequestMapping("/api/curriculum_vitae")
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;

	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}

	@GetMapping("/getByJobSeekerId")
	public DataResult<CurriculumVitae> getByJobSeekerId(int jobSeekerId) {
		return this.curriculumVitaeService.findByJobSeekerId(jobSeekerId);
	}

	@GetMapping("/getAll")
	public DataResult<List<CurriculumVitae>> getAll() {
		return this.curriculumVitaeService.getAll();
	}

	@GetMapping("/getJobSeekerCvWithDetails")
	public DataResult<CVDto> getCVDetailsByJobSeekerId(int jobSeekerId) {
		return this.curriculumVitaeService.getJobseekerCVById(jobSeekerId);
	}

}
