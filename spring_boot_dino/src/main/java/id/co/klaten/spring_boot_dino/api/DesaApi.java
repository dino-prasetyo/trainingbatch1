package id.co.klaten.spring_boot_dino.api;

import id.co.klaten.spring_boot_dino.model.DesaEntity;
import id.co.klaten.spring_boot_dino.model.TableImageEntity;
import id.co.klaten.spring_boot_dino.service.DesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(value = "/api/desa")
public class DesaApi
{
    @Autowired
    DesaService desaService;
    
    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DesaEntity> bacaDesa()
    {
        return desaService.bacaDesa();
    }
    
    @RequestMapping(value = "/searchByNama",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DesaEntity> searchByNamaDesa(@RequestParam String namaDesa)
    {
        return desaService.searchByNama(namaDesa);
    }
    
    @RequestMapping(value = "/save",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody DesaEntity desa)
    {
         desaService.save(desa);
    }
    @RequestMapping(value = "/saveImage",
        method = RequestMethod.POST,
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> saveImage(@RequestPart("dataImage") MultipartFile fileUpload)
    {
        System.out.println("........>>>>> Panjang data = "+fileUpload.getSize());
        
        
        try
        {
            String originalFilename = fileUpload.getOriginalFilename();
            File file = new File("LOKASI_FILE" + originalFilename);
            InputStream inputStream = fileUpload.getInputStream();
            TableImageEntity tableImageEntity = new TableImageEntity();
            byte[] data = new byte[(int)fileUpload.getSize()];
            inputStream.read(data);
            tableImageEntity.setImage(data);
            desaService.saveImage(tableImageEntity);
    
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(inputStreamResource);
                    //.body(new InputStreamResource(bis));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return ResponseEntity.ok(null);
    }
    
}
