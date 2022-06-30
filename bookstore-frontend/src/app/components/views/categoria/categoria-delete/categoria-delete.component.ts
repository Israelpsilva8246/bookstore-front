import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

import { Categoria } from './../../../model/categoria';
import { CategoriaService } from './../../../services/categoria.service';

@Component({
  selector: 'app-categoria-delete',
  templateUrl: './categoria-delete.component.html',
  styleUrls: ['./categoria-delete.component.css']
})
export class CategoriaDeleteComponent implements OnInit {

  categoria: Categoria = {
    id: '',
    nome: '',
    descricao: ''
  }

  constructor(private service: CategoriaService,
     private route: ActivatedRoute,
     private snackBar: MatSnackBar,
     private location: Location) { }

  ngOnInit(): void {
    this.categoria.id = this.route.snapshot.paramMap.get('id')!
    this.findById()
  }

  findById() {
    this.service.findById(this.categoria.id!).subscribe((resposta) => {
      this.categoria.nome = resposta.nome
      this.categoria.descricao = resposta.descricao
      console.log(this.categoria)
    })
  }

  onDelete() {
    this.service.delete(this.categoria.id!).subscribe((resposta) => this.onSuccess(), error => this.onError())
  }

  onCancel() {
    this.location.back();
  }

  onSuccess() {
    this.snackBar.open('Categoria deletada com sucesso', '', { duration: 5000 });
    this.onCancel();
  }

  onError() {
    this.snackBar.open('Categoria não pode ser deletada! Possui livros associados', '', { duration: 5000 });
  }
}
