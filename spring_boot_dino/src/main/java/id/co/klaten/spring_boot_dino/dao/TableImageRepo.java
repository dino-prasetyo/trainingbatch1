package id.co.klaten.spring_boot_dino.dao;

import id.co.klaten.spring_boot_dino.model.DesaEntity;
import id.co.klaten.spring_boot_dino.model.TableImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableImageRepo extends JpaRepository<TableImageEntity, Integer>
{
}
