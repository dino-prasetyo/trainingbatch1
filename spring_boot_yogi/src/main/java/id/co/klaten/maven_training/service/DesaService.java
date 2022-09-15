package id.co.klaten.maven_training.service;

import id.co.klaten.maven_training.dao.DesaRepo;
import id.co.klaten.maven_training.model.DesaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesaService {
    @Autowired
    DesaRepo desaRepo;

    public List<DesaEntity>bacaDesa() {
        return desaRepo.findAll();
    }

    public DesaEntity save(DesaEntity desaEntity){
        return desaRepo.save(desaEntity);
    }
    public List<DesaEntity>searchByNama(String strNamaDesa){
        return desaRepo.findByNamaDesaLike(strNamaDesa);
    }
}
