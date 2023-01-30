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
@Table(name = "cv_experiencesc")

public class CVExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    @NotNull
    @JsonIgnore
    private JobSeeker jobSeeker;

    @Column(name = "company_name")
    @NotNull
    private String companyName;

    @Column(name = "position")
    @NotNull
    private String position;

    @Column(name = "start_date")
    @NotNull
    private LocalDate startDate;

    @Column(name = "leave_date")
    private LocalDate leaveDate;

    @Column(name = "reason_leaving")
    private String reasonLeaving;
    
    @ManyToOne
    @JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;
    
    public String getLeaveDate(){
        if (leaveDate == null){
            return "Devam ediyor.";

        }
        return leaveDate.toString();
    }

}
