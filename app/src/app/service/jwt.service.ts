import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JwtService {


  constructor(private httpclient:HttpClient) { }
   getHeaders(): HttpHeaders {
    // Retrieve the token from where you stored it (e.g., localStorage)
    const token = localStorage.getItem('logintoken');

    // Set headers with Authorization Bearer token
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    });
  }

  register(obj:any):Observable<any>{
    const apiUrl="http://localhost:8084/jwt/register";
    return this.httpclient.post(apiUrl,obj);
  }
  authenticate(obj:any):Observable<any>{
    const apiUrl="http://localhost:8084/jwt/authenticate";
    console.log(obj)
    return this.httpclient.post(apiUrl,obj);
  }
}
