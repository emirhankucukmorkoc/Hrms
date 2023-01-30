package KodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.JobAdvertisementService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.JobAdvertisement;
import KodlamaIo.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);

	}

	@GetMapping("/getAllSortedByApplicationDeadline")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getAllJobAdvertisementWithEmployerDtoByApplicationDeadline() {
		return this.jobAdvertisementService.getAllJobAdvertisementWithEmployerDtoByApplicationDeadline();
	}

	@GetMapping("/getAllJobAdvertisementWithEmployerDtoByCompanyNameAndActive")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getAllJobAdvertisementWithEmployerDtoByCompanyNameAndActive(
			String companyName) {
		return this.jobAdvertisementService.getAllJobAdvertisementWithEmployerDtoByCompanyNameAndActive(companyName);
	}

	@PostMapping("/changeActivityStatus")
	public Result changeActivityStatus(int id) {
		return this.jobAdvertisementService.changeIsActive(id);

	}

	@GetMapping("/getAllActiveJobAdvertisement")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetails() {
		return this.jobAdvertisementService.getJobAdvertisementWithEmployerDetails();
	}

}
