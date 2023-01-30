package KodlamaIo.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.cv.CVAbilityService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVAbility;

@RestController
@RequestMapping("api/abilities")
public class CVAbilitiesController {
    private CVAbilityService cvAbilityService;

    @Autowired
    public CVAbilitiesController(CVAbilityService cvAbilityService) {
        this.cvAbilityService = cvAbilityService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CVAbility cvAbility){
        return this.cvAbilityService.add(cvAbility);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CVAbility cvAbility){
        return this.cvAbilityService.update(cvAbility);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id){
        return this.cvAbilityService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<CVAbility>> getAll(){
        return this.cvAbilityService.getAll();
    }

    @GetMapping("/getAllByCandidateId")
    public DataResult<List<CVAbility>> getAllByJobseekerId(@RequestParam int id){
        return this.cvAbilityService.getAllByCandidateId(id);
    }
}
