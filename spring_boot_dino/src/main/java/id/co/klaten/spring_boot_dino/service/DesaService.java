package id.co.klaten.spring_boot_dino.service;

import id.co.klaten.spring_boot_dino.dao.DesaRepo;
import id.co.klaten.spring_boot_dino.dao.TableImageRepo;
import id.co.klaten.spring_boot_dino.model.DesaEntity;
import id.co.klaten.spring_boot_dino.model.TableImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesaService
{
    @Autowired
    DesaRepo desaRepo;
    
    @Autowired
    TableImageRepo tableImageRepo;
    
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
    public void saveImage(TableImageEntity imageEntity)
    {
        tableImageRepo.save(imageEntity);
    }
}
