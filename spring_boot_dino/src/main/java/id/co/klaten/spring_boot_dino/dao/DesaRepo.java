package id.co.klaten.spring_boot_dino.dao;

import id.co.klaten.spring_boot_dino.model.DesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesaRepo extends JpaRepository<DesaEntity, Integer>
{
    @Query("select d from DesaEntity d where d.namaDesa like :namaDesa")
    public List<DesaEntity> searchByNama(@Param("namaDesa") String strNamaDesa);
    
    List<DesaEntity> findByNamaDesaLike(String namaDesa);
}
