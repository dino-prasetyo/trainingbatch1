package id.co.klaten.spring_boot_dino.api;

import id.co.klaten.spring_boot_dino.model.DesaEntity;
import id.co.klaten.spring_boot_dino.service.DesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/desa")
public class DesaApi
{
    @Autowired
    DesaService desaService;
    
    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DesaEntity> bacaDesa()
    {
        return desaService.bacaDesa();
    }
    
    @RequestMapping(value = "/searchByNama",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DesaEntity> searchByNamaDesa(@RequestParam String namaDesa)
    {
        return desaService.searchByNama(namaDesa);
    }
    
}
