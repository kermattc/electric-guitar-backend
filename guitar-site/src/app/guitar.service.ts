import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Guitar } from './guitar';

@Injectable({
  providedIn: 'root'
})
export class GuitarService {
  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {
  } 

  // constructor(private http: HttpClient) {
  //   this.corsHeaders = new HttpHeaders({
  //     'Content-Type': 'application/json',
  //     'Accept': 'application/json'
  //   });
  // }

  
  getGuitars(keywords: string[]): Observable<Guitar[]>{
    let api_keywords = "";

    keywords.forEach((keyword) => {
      api_keywords += ("words="+keyword + "&") 
    })    

    if (keywords.length > 0) {
      api_keywords = api_keywords.substring(0, api_keywords.length - 1)
    }
    console.log("keywords in api call: ", this.baseUrl+"/guitars?"+api_keywords)
    return this.http.get<Guitar[]>(`${this.baseUrl}/guitars?${api_keywords}`);
  }
}
