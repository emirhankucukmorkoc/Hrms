package KodlamaIo.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.cv.CVEducationService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVEducation;

@RestController
@RequestMapping("api/educations")
public class CVEducationsController {
    private CVEducationService cvEducationService;

    @Autowired
    public CVEducationsController(CVEducationService cvEducationService) {
        this.cvEducationService = cvEducationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CVEducation cvEducation) {
        return this.cvEducationService.add(cvEducation);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CVEducation cvEducation) {
        return this.cvEducationService.update(cvEducation);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id) {
        return this.cvEducationService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<CVEducation>> getAll() {
        return this.cvEducationService.getAll();
    }

    @GetMapping("/getAllByCandidateIdOrderByGraduationYearDesc")
    public DataResult<List<CVEducation>> getAllByCandidateIdOrderByGraduationYearDesc (@RequestParam int id){
        return this.cvEducationService.getAllByCandidateIdOrderByGraduationYearDesc(id);
    }
    @GetMapping("/getAllByCandidateId")
    public DataResult<List<CVEducation>> getAllByCandidateId(@RequestParam int id){
        return this.cvEducationService.getAllByCandidateId(id);
    }
}
