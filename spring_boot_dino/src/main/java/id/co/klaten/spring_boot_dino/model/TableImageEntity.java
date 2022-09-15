package id.co.klaten.spring_boot_dino.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name="TABLE_IMAGE")
@Data              
@AllArgsConstructor
@NoArgsConstructor 
public class TableImageEntity {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="IMAGE")
  private byte[] image;
}
