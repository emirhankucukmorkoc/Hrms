package KodlamaIo.hrms.entities.concretes.Cv;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import KodlamaIo.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "curriculum_vitae")
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@OneToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVCoverLetter> coverLetter;

	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVEducation> educations;

	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVExperience> experiences;

	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVLanguage> languageLevels;

	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVLink> links;

	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVAbility> skills;

	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CVPhotograph> cvPhotographs;

}
