package KodlamaIo.hrms.entities.dtos;

import java.util.List;

import KodlamaIo.hrms.entities.concretes.JobSeeker;
import KodlamaIo.hrms.entities.concretes.Cv.CVAbility;
import KodlamaIo.hrms.entities.concretes.Cv.CVCoverLetter;
import KodlamaIo.hrms.entities.concretes.Cv.CVEducation;
import KodlamaIo.hrms.entities.concretes.Cv.CVExperience;
import KodlamaIo.hrms.entities.concretes.Cv.CVLanguage;
import KodlamaIo.hrms.entities.concretes.Cv.CVLink;
import KodlamaIo.hrms.entities.concretes.Cv.CVPhotograph;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVDto {


	public JobSeeker jobSeeker;
	public List<CVEducation> cvEducations;
	public List<CVExperience> cvExperiences;
	public List<CVLanguage> cvLanguages;
	public List<CVPhotograph> cvPhotograph;
	public List<CVLink> cvLinks;
	public List<CVAbility> cvAbilities;
	public List<CVCoverLetter> cvCoverLetters;

}