import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Guitar } from './guitar';

@Injectable({
  providedIn: 'root'
})
export class GuitarService {
  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {} 

  getGuitars(): Observable<Guitar[]>{
    return this.http.get<Guitar[]>(`${this.baseUrl}/guitars`);
  }
}
