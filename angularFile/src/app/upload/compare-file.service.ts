import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompareFileService {

  private _url: string = "http://localhost:8080/";
  constructor(private http: HttpClient) { }

  getResultCompareFile(){
      return this.http.get(this._url);
  }
}
