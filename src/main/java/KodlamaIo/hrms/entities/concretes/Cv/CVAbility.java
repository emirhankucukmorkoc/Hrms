package KodlamaIo.hrms.entities.concretes.Cv;


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
@Table(name = "cv_abilities")

public class CVAbility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    @NotNull
    @JsonIgnore
    private JobSeeker jobSeeker;

    @Column(name = "technology_name")
    private String technologyName;
    
    
    @ManyToOne
	@JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;
}
	