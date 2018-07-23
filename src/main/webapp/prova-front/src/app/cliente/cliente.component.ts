import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../app/service/cliente.service';
import { FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'cliente-page',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {
 
  frm: any;
  item: any;

  ufPattern: any = /^(ac|AC|al|AL|am|AM|ap|AP|ba|BA|ce|CE|df|DF|es|ES|go|GO|ma|MA|mg|MG|ms|MS|mt|MT|pa|PA|pb|PB|pe|PE|pi|PI|pr|PR|rj|RJ|rn|RN|ro|RO|rr|RR|rs|RS|sc|SC|se|SE|sp|SP|to|TO)$/;
  
  displayedColumns = ['nome','uf','cidade','acoes'];
  datasource;

  constructor(private fb: FormBuilder, 
    private clienteService: ClienteService,
    public snackBar: MatSnackBar) { 
    this.limpar();
  }

  limpar() {
    this.frm = this.fb.group({
      id: null,
      nome: ['', Validators.required],
      uf: ['', [Validators.required, Validators.pattern(this.ufPattern)]],
      cidade: ['', Validators.required],
      dataNascimento: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.clienteService.listar().subscribe(response => {
      this.datasource = response;
    });
  }

  editar(id) {
    this.clienteService.porId(id).subscribe(response => {
      this.frm.setValue(response);
    });
  }

  salvar() {
    if (this.frm.valid) {
      this.clienteService.salvar(this.frm.value).subscribe(response => { 
        this.snackBar.open('Operação realizada com sucesso');
        this.limpar();
        this.listar();
      });
    }
  }

}
