import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { NgModule } from '@angular/core';

export interface DesaEntity {
  idDesa:any;
  idKecamatan:any;
  namaDesa:String;
}

export interface KecamatanEntity {
  idKecamatan:any;
  idKabupaten:any;
  namaKecamatan:String;
}

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})


export class ContactComponent implements OnInit {

  desaEntity:DesaEntity[]=[];
  kecamatanEntity:KecamatanEntity[]=[];

  message = " default value"
  idDesaNew="";
  idKecamatanNew="";
  namaDesaNew="";


  keydown(e:any)
  {
    this.message =e.target.value;
  }
  constructor(private http: HttpClient) { }

  ngOnInit(): void {

    this.getAllData();
    console.log(this.desaEntity)


    this.getAllDataKecamatan()
    console.log(this.kecamatanEntity)


  }
//get all data kecamatan

  getAllDataKecamatan()
  {
    this.http.get<KecamatanEntity>( 'http://localhost:4200/api/all/kecamatan')
      .subscribe((dataKecamatan:any)=>{
        this.getValueKecamatan(dataKecamatan)
      });
    console.log(this.kecamatanEntity)
  }

  getValueKecamatan(dataKecamatan:KecamatanEntity[]){
    if (dataKecamatan){
      dataKecamatan.forEach((obj)=>{
        this.kecamatanEntity.push(obj);
      })
    }
  }


  //get all desa
  getAllData()
  {
    this.http.get<DesaEntity>('http://localhost:4200/api/all/desa')
      .subscribe((data:any) =>{
        this.getValue(data)
      });
    console.log(this.desaEntity)
  }

  getValue(data:DesaEntity[]){
    if (data){
      data.forEach((obj)=>{
        this.desaEntity.push(obj);
      })
      // length = data.length;
      // this.desaEntity.idDesa=data[2].idDesa;
      // this.desaEntity.idKecamatan=data[2].idKecamatan;
      // this.desaEntity.namaDesa=data[2].namaDesa
    }
  }

  addData(){
    let id = Math.random()*100;
    let desaObj:any={
      idDesa:id,
        idKecamatan:1,
      namaDesa:"Desa "+id
    }
    this.http.post('http://localhost:4200/api/desa/save',
      desaObj)
      .subscribe();
    this.desaEntity=[];
    this.getAllData();
  }

  addDataNew(){
    if (this.idDesaNew !== "" && this.idKecamatanNew !== "" && this.namaDesaNew !=="")
    {
      let desaObj:any={
        idDesa:this.idDesaNew,
        idKecamatan:this.idKecamatanNew,
        namaDesa:this.namaDesaNew
      }
      this.http.post('http://localhost:4200/api/desa/save',
        desaObj)
        .subscribe();
      this.desaEntity=[];
      this.getAllData();
    }
  }
}
