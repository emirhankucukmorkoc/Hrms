package KodlamaIo.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.hrms.business.abstracts.cv.CurriculumVitaeService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.core.result.SuccessDataResult;
import KodlamaIo.hrms.core.result.SuccessResult;
import KodlamaIo.hrms.dataAccess.abstracts.Cv.CurriculumVitaeDao;
import KodlamaIo.hrms.entities.concretes.Cv.CurriculumVitae;
import KodlamaIo.hrms.entities.dtos.CVDto;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "All Cv Displayed");
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("curriculumV. added");
	}

	@Override
	public DataResult<CurriculumVitae> findByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.findByJobSeekerId(jobSeekerId),
				"CV Displayed");
	}

	@Override
	public DataResult<CVDto> getJobseekerCVById(int id) {
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.findByJobSeekerId(id);

		CVDto cv = new CVDto();

		cv.jobSeeker = curriculumVitae.getJobSeeker();
		cv.cvExperiences = curriculumVitae.getExperiences();
		cv.cvLanguages = curriculumVitae.getLanguageLevels();
		cv.cvPhotograph = curriculumVitae.getCvPhotographs();
		cv.cvLinks = curriculumVitae.getLinks();
		cv.cvAbilities = curriculumVitae.getSkills();
		cv.cvEducations = curriculumVitae.getEducations();
		cv.cvCoverLetters = curriculumVitae.getCoverLetter();

		return new SuccessDataResult<CVDto>(cv);
	}
}