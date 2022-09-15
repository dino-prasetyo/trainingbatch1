package id.co.klaten.maven_training.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name="KECAMATAN")
@Data              
@AllArgsConstructor
@NoArgsConstructor 
public class KecamatanEntity{


  @Id
  @Column(name="ID_KECAMATAN", nullable = false)
  private Integer idKecamatan;

  @Column(name="ID_KABUPATEN")
  private Integer idKabupaten;

  @Column(name="NAMA_KECAMATAN")
  private String namaKecamatan;

}
