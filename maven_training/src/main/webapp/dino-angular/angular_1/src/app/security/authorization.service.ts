import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable()
export class Authorization {

  _token : any = null;

  constructor(private http: HttpClient) {
  }


  login(userName:any, pasdword:any)
  {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Authorization', 'Basic ' + btoa("web-client:pass"))
      .append('Content-type', 'application/x-www-form-urlencoded; charset=utf-8');

    const bodyParam:HttpParams = new HttpParams()
    bodyParam.set("grant_type", "password");
    bodyParam.set("client_id", "web-client");
    bodyParam.set("client_secret", "pass");
    bodyParam.set("username", userName);
    bodyParam.set("password", pasdword);

    this.http.post("http://localhost:4200/oauth/token", bodyParam, {
      headers: headers
    })
      .subscribe((data:any)=>{
        this._token = data.access_token;
      });
  }

  post(url:any,body:any)
  {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Authorization', 'Bearer ' + this._token)
      .append('Content-type', 'application/json; charset=utf-8');

    this.http.post(url, body, {
      headers: headers
    })
      .subscribe();
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
