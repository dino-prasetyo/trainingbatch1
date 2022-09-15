package id.co.klaten.maven_training.dao;

import id.co.klaten.maven_training.model.DesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesaRepo extends JpaRepository<DesaEntity,Integer>  {

    @Query("Select d from DesaEntity d where d.namaDesa=:namaDesa")
    public List<DesaEntity>getDesaByCollection();

    @Query("select d from DesaEntity d where d.namaDesa like :namaDesa")
    public List<DesaEntity> searchByNama(@Param("namaDesa") String strNamaDesa);

    List<DesaEntity> findByNamaDesaLike(String namaDesa);
}
