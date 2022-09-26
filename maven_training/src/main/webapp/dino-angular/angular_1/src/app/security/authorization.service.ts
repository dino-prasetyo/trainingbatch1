import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable()
export class Authorization {

  _token : any = null;

  constructor(private http: HttpClient) {
  }


  login(userName:any, pasdword:any)
  {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + btoa("web-client:pass"))
      .set('Content-type', 'application/x-www-form-urlencoded; charset=utf-8');

    let bodyParam:HttpParams = new HttpParams()
          .set("grant_type", "password")
          .set("client_id", "web-client")
          .set("client_secret", "pass")
          .set("username", userName)
          .set("password", pasdword);

    this.http.post("http://localhost:4200/oauth/token", bodyParam, {
      headers: headers
    })
      .subscribe((data:any)=>{
        this._token = data.access_token;
        console.log(this._token)
      })
  }

  post(url:any,body:any, additionalFunction:any)
  {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Authorization', 'Bearer ' + this._token)
      .append('Content-type', 'application/json; charset=utf-8');

    this.http.post(url, body, {
      headers: headers
    })
      .subscribe((data)=>
      {
      }).add(additionalFunction);
  }

  get(url:any,param:any)
  {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Authorization', 'Bearer ' + this._token)
      .append('Content-type', 'application/json; charset=utf-8');

    this.http.get(url,{
      headers: headers,
      params:param
    })
      .subscribe();
  }
}
