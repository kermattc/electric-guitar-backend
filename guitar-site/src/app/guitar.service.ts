import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Guitar } from './guitar';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GuitarService {
  private baseUrl = 'http://localhost:8080/api/v1';
  // private baseUrl = 'https://vcjshzd57g.execute-api.us-east-2.amazonaws.com/dev';
  // private baseUrl = 'https://electric-guitar-lookup.azurewebsites.net/api/v1';
  constructor(private http: HttpClient) {}

  getGuitars(keywords: string[]): Observable<Guitar[]> {
    let api_keywords = "";
    keywords.forEach((keyword) => {
      api_keywords += ("words=" + keyword + "&");
    });

    if (keywords.length > 0) {
      api_keywords = api_keywords.substring(0, api_keywords.length - 1);
    }

    const headers = new HttpHeaders({
      'content-type': 'application/json',
    });

    console.log("keywords in api call: ", `${this.baseUrl}/guitars?${api_keywords}`);
    // return this.http.get<Guitar[]>(`${this.baseUrl}/guitars?${api_keywords}`);
 
    return this.http.get<Guitar[]>(`${this.baseUrl}/guitars?${api_keywords}`, { headers });
  }
}
