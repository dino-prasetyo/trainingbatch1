import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";


export interface DesaEntity {
  idDesa: any;
  idKecamatan: any;
  namaDesa: string;
}

@Component({
  selector: 'app-desa-form',
  templateUrl: './desa-form.component.html',
  styleUrls: ['./desa-form.component.less']
})

export class DesaFormComponent implements OnInit {
  @ViewChild("fileUpload") fileUpload: ElementRef = {} as ElementRef ;

  desaEntity: DesaEntity[] = [];
  fileName = '';
  imageShow: any;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    // this.getAllData();
    console.log(this.desaEntity)
  }

  getAllData() {
    this.http.get<DesaEntity>('http://localhost:4200/api/desa/all')
      .subscribe((data: any) => {
        this.getValue(data)
      });
  }

  getValue(data: DesaEntity[]) {
    if (data) {
      data.forEach((obj) => {
        this.desaEntity.push(obj);
      });
    }
  }

  simpan() {
    let id = Math.random() * 100;
    let desaObj: any = {
      idDesa: id,
      idKecamatan: 1,
      namaDesa: "Desa_" + id
    }
    this.http.post('http://localhost:4200/api/desa/save'
      , desaObj)
      .subscribe();
    this.desaEntity = [];
    this.getAllData();
  }

  saveImage() {

    const file: File = this.fileUpload.nativeElement.files[0];

    if (file) {

      this.fileName = file.name;

      const formData = new FormData();

      formData.append("dataImage", file);

      this.http.post("http://localhost:4200/api/desa/saveImage", formData, {responseType: "blob"})
        .subscribe((data: any) => {
          var reader = new FileReader();
          reader.readAsDataURL(data)
          reader.onload = (_event) => {
            this.imageShow = reader.result;
          }
        });


    }
  }
}
