import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable()
export class PedidoService {

  url: string = `${environment.baseUrl}/api/pedidos`;

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get(this.url);
  }

  porId(id: number) {
    return this.http.get(`${this.url}/${id}`);
  }

  salvar(item) {
    if (item.id) {
      return this.http.put(this.url, item);
    } else {
      return this.http.post(this.url, item);
    }
  }

  excluir(id) {
    return this.http.delete(`${this.url}/${id}`);
  }
  
}
