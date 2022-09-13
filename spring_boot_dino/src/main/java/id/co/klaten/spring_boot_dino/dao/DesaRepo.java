package id.co.klaten.spring_boot_dino.dao;

import id.co.klaten.spring_boot_dino.model.DesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesaRepo extends JpaRepository<DesaEntity, Integer>
{

}
