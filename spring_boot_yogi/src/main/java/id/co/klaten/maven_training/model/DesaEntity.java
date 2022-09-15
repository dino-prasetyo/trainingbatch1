package id.co.klaten.maven_training.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name="DESA")
@Data              
@AllArgsConstructor
@NoArgsConstructor 
public class DesaEntity {


  @Id
  @Column(name="ID_DESA", nullable = false)
  private Integer idDesa;

  @Column(name="ID_KECAMATAN")
  private Integer idKecamatan;

  @Column(name="NAMA_DESA")
  private String namaDesa;

}
