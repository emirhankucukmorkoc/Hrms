package KodlamaIo.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.cv.CVExperienceService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVExperience;

@RestController
@RequestMapping("api/experiences")
public class CVExperiencesController {
    private CVExperienceService cvExperienceService;

    @Autowired
    public CVExperiencesController(CVExperienceService cvExperienceService) {
        this.cvExperienceService = cvExperienceService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody CVExperience cvExperience) {
        return this.cvExperienceService.add(cvExperience);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CVExperience cvExperience) {
        return this.cvExperienceService.update(cvExperience);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id) {
        return this.cvExperienceService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<CVExperience>> getAll() {
        return this.cvExperienceService.getAll();
    }

    @GetMapping("/getAllByCandidateIdOrderByLeaveDateDesc")
    public DataResult<List<CVExperience>> getAllByCandidateIdOrderByLeaveDateDesc(@RequestParam("id") int id){
        return this.cvExperienceService.getAllByCandidateIdOrderByLeaveDateDesc(id);
    }

    @GetMapping("/getAllByCandidateId")
    public DataResult<List<CVExperience>> getAllByCandidateId(@RequestParam int id){
        return this.cvExperienceService.getAllByCandidateId(id);
    }
}
