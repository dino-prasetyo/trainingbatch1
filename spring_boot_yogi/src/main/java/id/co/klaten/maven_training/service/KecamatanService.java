package id.co.klaten.maven_training.service;

import id.co.klaten.maven_training.dao.KecamatanRepo;
import id.co.klaten.maven_training.model.KecamatanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KecamatanService {

    @Autowired
    KecamatanRepo kecamatanRepo;

    public List<KecamatanEntity> takeKecamatan(){
        return kecamatanRepo.findAll();
    }
}
