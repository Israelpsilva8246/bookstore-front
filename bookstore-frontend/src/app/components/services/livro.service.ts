import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Livro } from './../model/livro';

@Injectable({
  providedIn: 'root',
})
export class LivroService {
  baseUrl: String = environment.baseUrl;

  constructor(private httpClient: HttpClient) {}

  findAllByCategoria(id_cat: String): Observable<Livro[]> {
    const url = `${this.baseUrl}/livros?categoria=${id_cat}`;
    return this.httpClient.get<Livro[]>(url);
  }

  findById(id: String): Observable<Livro> {
    const url = `${this.baseUrl}/livros/${id}`;
    return this.httpClient.get<Livro>(url);
  }

  update(livro: Livro): Observable<Livro> {
    const url = `${this.baseUrl}/livros/${livro.id}`
    return this.httpClient.put<Livro>(url, livro)
  }

  delete(id: String): Observable<void> {
    const url = `${this.baseUrl}/livros/${id}`
    return this.httpClient.delete<void>(url)
  }

  create(livro: Livro, id_cat: String): Observable<Livro> {
    const url = `${this.baseUrl}/livros?categoria=${id_cat}`;
    return this.httpClient.post<Livro>(url, livro);
  }
}
