package KodlamaIo.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithEmployerDto {

	private int id;
	private String nameOfCompany;
	private String nameOfJob;
	private int numberOfOpenPosition;
	private LocalDate applicationDeadline;
	private LocalDate createDate;


}
