package KodlamaIo.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.hrms.business.abstracts.cv.CVLanguageService;
import KodlamaIo.hrms.core.result.DataResult;
import KodlamaIo.hrms.core.result.Result;
import KodlamaIo.hrms.entities.concretes.Cv.CVLanguage;

@RestController
@RequestMapping("api/languages")
public class CVLanguagesController {
    private CVLanguageService cvLanguageService;

    @Autowired
    public CVLanguagesController(CVLanguageService cvLanguageService) {
        this.cvLanguageService = cvLanguageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CVLanguage cvLanguage) {
        return this.cvLanguageService.add(cvLanguage);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CVLanguage cvLanguage) {
        return this.cvLanguageService.update(cvLanguage);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id) {
        return this.cvLanguageService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<CVLanguage>> getAll() {
        return this.cvLanguageService.getAll();
    }

    @GetMapping("/getAllByJobSeekerId")
    public DataResult<List<CVLanguage>> getAllByCandidateId(@RequestParam int id) {
        return this.cvLanguageService.getAllByCandidateId(id);

    }
}
