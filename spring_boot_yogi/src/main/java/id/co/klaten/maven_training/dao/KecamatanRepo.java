package id.co.klaten.maven_training.dao;


import id.co.klaten.maven_training.model.KecamatanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KecamatanRepo extends JpaRepository<KecamatanEntity,Integer> {

}
