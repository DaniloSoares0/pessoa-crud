import { Pessoa } from './../model/pessoa.model';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';

const url = 'http://localhost:8080/api/v1/pessoa'

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private http: HttpClient) { }

  salvar(pessoa: Pessoa): Observable<Pessoa> {
    return this.http.post<Pessoa>(url, pessoa);
  }

  deletar(id: number): Observable<any>{
    return this.http.delete(url+"/deletar/"+id)
  }

  buscarPorCpf(cpf): Observable<any>{
    return this.http.get(url+"/buscar-por-cpf/"+cpf)
  }


  buscarRegistros(page): Observable<any>{

    let queryParams = new HttpParams();
    queryParams.append("pageIndex",page.pageIndex);
    queryParams.append("pageSize",page.pageSize);
    queryParams.append("length",page.length);
    queryParams = queryParams

    return this.http.get(url, {
      params: queryParams
    });
  }
}
