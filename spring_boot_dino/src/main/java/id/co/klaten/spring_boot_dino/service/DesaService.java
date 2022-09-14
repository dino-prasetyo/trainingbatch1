package id.co.klaten.spring_boot_dino.service;

import id.co.klaten.spring_boot_dino.dao.DesaRepo;
import id.co.klaten.spring_boot_dino.model.DesaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesaService
{
    @Autowired
    DesaRepo desaRepo;
    
    public List<DesaEntity> bacaDesa()
    {
        return desaRepo.findAll();
    }
    public void save(DesaEntity desa)
    {
         desaRepo.save(desa);
    }
    public List<DesaEntity> searchByNama(String strNamaDesa)
    {
        return desaRepo.findByNamaDesaLike(strNamaDesa);
    }
}
