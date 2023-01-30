package KodlamaIo.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import KodlamaIo.hrms.entities.concretes.JobAdvertisement;
import KodlamaIo.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("Select new KodlamaIo.hrms.entities.dtos.JobAdvertisementWithEmployerDto(j.id, e.nameOfCompany, p.nameOfJob, j.numberOfOpenPosition, j.applicationDeadline, j.createDate ) FROM  Employer e Inner Join e.jobAdvertisements j Inner Join j.jobPosition p  where e.nameOfCompany=:companyName and j.isActive=true")
	List<JobAdvertisementWithEmployerDto> getAllJobAdvertisementWithEmployerDtoByCompanyNameAndActive(
			String companyName);

	@Query("Select new KodlamaIo.hrms.entities.dtos.JobAdvertisementWithEmployerDto(j.id, e.nameOfCompany, p.nameOfJob, j.numberOfOpenPosition, j.applicationDeadline, j.createDate ) FROM  Employer e Inner Join e.jobAdvertisements j Inner Join j.jobPosition p  where j.isActive=true ORDER BY application_deadline ASC ")
	List<JobAdvertisementWithEmployerDto> getAllJobAdvertisementWithEmployerDtoByApplicationDeadline();

	@Modifying
	@Transactional
	@Query("Update JobAdvertisement j set j.isActive = false where j.id=:id")
	void changeIsActive(int id);

	@Query("Select new KodlamaIo.hrms.entities.dtos.JobAdvertisementWithEmployerDto(j.id, e.nameOfCompany, p.nameOfJob, j.numberOfOpenPosition, j.applicationDeadline, j.createDate ) FROM  Employer e Inner Join e.jobAdvertisements j Inner Join j.jobPosition p  where j.isActive=true")
	List<JobAdvertisementWithEmployerDto> getJobAdvertisementWithEmployerDetails();
}
