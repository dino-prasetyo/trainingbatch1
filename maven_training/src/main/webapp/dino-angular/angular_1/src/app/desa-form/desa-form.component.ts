import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Authorization} from "../security/authorization.service";


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
  @ViewChild("fileUpload") fileUpload: ElementRef = {} as ElementRef;

  desaEntity: DesaEntity[] = [];
  fileName = '';
  imageShow: any;
  username: any= "user1";
  password: any = "test";

  constructor(private http: HttpClient, private authorization:Authorization) {
  }

  ngOnInit(): void {
    // this.getAllData();
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

  login() {
    this.authorization.login(this.username, this.password)
  }
  fungsiTambahan()
  {
    console.log("test")
  }
  save()
  {
    const url :any = "/api/save"
    const  body:any=
      {
        idDesa:1,
        idKecamatan:1,
        namaDesa:"test est"
      }
    this.authorization.post(url, body, this.fungsiTambahan)
  }

}
