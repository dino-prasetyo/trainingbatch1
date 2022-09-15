package id.co.klaten.maven_training.api;

import id.co.klaten.maven_training.model.DesaEntity;
import id.co.klaten.maven_training.service.DesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DesaApi {
    @Autowired
    DesaService desaService;

    @RequestMapping(value = "/api/all/desa",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DesaEntity> bacaDesa(){
        return desaService.bacaDesa();
    }

    @RequestMapping(value = "/api/desa/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody DesaEntity desaEntity ){
        desaService.save(desaEntity);
    }

    @RequestMapping(value = "/search",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DesaEntity> searchByNamaDesa(@RequestParam String namaDesa){
        return desaService.searchByNama(namaDesa);
    }


}
