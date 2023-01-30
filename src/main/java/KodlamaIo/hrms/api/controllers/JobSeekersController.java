package KodlamaIo.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.concretes.JobSeekerManager;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

	private JobSeekerManager jobSeekerManager;

	@Autowired
	public JobSeekersController(JobSeekerManager jobSeekerManager) {
		this.jobSeekerManager = jobSeekerManager;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerManager.getAll();
	}

	@PostMapping("/register")
	public Result register(JobSeeker jobSeeker) throws Exception {

		return this.jobSeekerManager.register(jobSeeker);

	}
}
