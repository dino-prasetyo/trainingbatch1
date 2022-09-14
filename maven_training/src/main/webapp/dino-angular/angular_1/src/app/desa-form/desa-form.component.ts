import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, throwError} from 'rxjs';


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
  desaEntity: DesaEntity = {
    idDesa: "",
    idKecamatan: "",
    namaDesa: ""
  }

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get<DesaEntity>('http://localhost:4200/api/desa/all')
      .subscribe((data: any) => {
        this.getValue(data)
      });
    console.log(this.desaEntity)
  }

  getValue(data: DesaEntity[]) {
    if (data) {
      this.desaEntity.idDesa = data[0].idDesa;
      this.desaEntity.idKecamatan = data[0].idKecamatan;
      this.desaEntity.namaDesa = data[0].namaDesa;
    }
  }
}
