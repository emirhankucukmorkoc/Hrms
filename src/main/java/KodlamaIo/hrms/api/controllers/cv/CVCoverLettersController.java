package KodlamaIo.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.cv.CVCoverLetterService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVCoverLetter;

@RestController
@RequestMapping("api/coverletters")
public class CVCoverLettersController {
	private CVCoverLetterService cvCoverLetterService;

	@Autowired
	public CVCoverLettersController(CVCoverLetterService cvCoverLetterService) {
		this.cvCoverLetterService = cvCoverLetterService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CVCoverLetter cvCoverLetter) {
		return this.cvCoverLetterService.add(cvCoverLetter);
	}

	@PostMapping("/update")
	public Result update(@RequestBody CVCoverLetter cvCoverLetter) {
		return this.cvCoverLetterService.update(cvCoverLetter);

	}

	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.cvCoverLetterService.delete(id);

	}

	@GetMapping("/getAll")
	public DataResult<List<CVCoverLetter>> getAll() {
		return this.cvCoverLetterService.getAll();
	}

	@GetMapping("/findByJobSeekerId")
	public DataResult<List<CVCoverLetter>> findByJobSeekerId(@RequestParam int id) {
		return this.cvCoverLetterService.findByJobSeekerId(id);
	}
}
