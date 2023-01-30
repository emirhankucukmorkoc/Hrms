package KodlamaIo.hrms.api.controllers.cv;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.cv.CVLinkService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVLink;

@RestController
@RequestMapping("api/links")
public class CVLinksController {
    private CVLinkService cvLinkService;

    @Autowired
    public CVLinksController(CVLinkService cvLinkService) {
        this.cvLinkService = cvLinkService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CVLink cvLink){
        return this.cvLinkService.add(cvLink);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CVLink cvLink){
        return this.cvLinkService.update(cvLink);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id){
        return this.cvLinkService.delete(id);
    }


    @GetMapping("/getAll")
    public DataResult<List<CVLink>> getAll(){
        return this.cvLinkService.getAll();
    }

    @GetMapping("/getAllByCandidateId")
    public DataResult<List<CVLink>> getAllByCandidateId(@RequestParam int id){
        return this.cvLinkService.getAllByCandidateId(id);
    }
}
