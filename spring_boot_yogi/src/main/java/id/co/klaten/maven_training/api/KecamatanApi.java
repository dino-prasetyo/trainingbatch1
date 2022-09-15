package id.co.klaten.maven_training.api;


import id.co.klaten.maven_training.model.KecamatanEntity;
import id.co.klaten.maven_training.service.KecamatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KecamatanApi {

    @Autowired
    KecamatanService kecamatanService;

    @RequestMapping(value = "/api/all/kecamatan",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<KecamatanEntity> takeKecamatan(){
        return kecamatanService.takeKecamatan();
    }
}
