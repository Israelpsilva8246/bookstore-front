import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, tap, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { Categoria } from './../model/categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

baseUrl: String = environment.baseUrl;

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Categoria[]> {
    const url = `${this.baseUrl}/categorias`
    return this.httpClient.get<Categoria[]>(url)
  }

  create(categoria: Categoria): Observable<Categoria> {
    const url =  `${this.baseUrl}/categorias`
    return this.httpClient.post<Categoria>(url, categoria)
  }

  findById(id: String): Observable<Categoria> {
    const url = `${this.baseUrl}/categorias/${id}`
    return this.httpClient.get<Categoria>(url)
  }

  delete(id: String): Observable<void> {
    const url = `${this.baseUrl}/categorias/${id}`
    return this.httpClient.delete<void>(url)
  }

  update(categoria: Categoria): Observable<void> {
    const url = `${this.baseUrl}/categorias/${categoria.id}`
    return this.httpClient.put<void>(url, categoria)
  }

}
