import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Categoria } from 'src/app/components/model/categoria';

import { CategoriaService } from './../../../services/categoria.service';

@Component({
  selector: 'app-categoria-update',
  templateUrl: './categoria-update.component.html',
  styleUrls: ['./categoria-update.component.css'],
})
export class CategoriaUpdateComponent implements OnInit {
  categoria: Categoria = {
    id: '',
    nome: '',
    descricao: '',
  };

  constructor(
    private service: CategoriaService,
    private route: ActivatedRoute,
    private location: Location,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.categoria.id = this.route.snapshot.paramMap.get('id')!;
    this.findById();
  }

  findById() {
    this.service.findById(this.categoria.id).subscribe((resposta) => {
      this.categoria.nome = resposta.nome;
      this.categoria.descricao = resposta.descricao;
    });
  }

  onUpdate() {
    this.service.update(this.categoria).subscribe((resposta) => this.onSuccess())
  }

  onCancel() {
    this.location.back();
  }

  onSuccess() {
    this.snackBar.open('Categoria atualizada com sucesso', '', { duration: 5000 });
    this.onCancel();
  }

  onError() {
    this.snackBar.open('Erro ao atualizar categoria', '', { duration: 5000 });
  }
}
