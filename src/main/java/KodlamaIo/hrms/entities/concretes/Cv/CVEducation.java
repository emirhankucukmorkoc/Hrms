package KodlamaIo.hrms.entities.concretes.Cv;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import KodlamaIo.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_educations")
public class CVEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	@NotNull
	@JsonIgnore
	private JobSeeker jobSeeker;

	@Column(name = "school_name")
	@NotNull
	private String schoolName;

	@Column(name = "department_name")
	@NotNull
	private String departmentName;

	@Column(name = "graduation_year")
	@NotNull
	private String graduationYear;

	@Column(name = "start_year")
	@NotNull
	private String startYear;

	@Column(name = "starting_date")
	@NotNull
	private LocalDate startingDate;

	@Column(name = "ending_date")
	private LocalDate endingDate;

	@ManyToOne
	@JoinColumn(name = "curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;

	public String getEndingDate() {
		if (endingDate == null) {
			return "Devam ediyor.";

		}
		return endingDate.toString();
	}
}
