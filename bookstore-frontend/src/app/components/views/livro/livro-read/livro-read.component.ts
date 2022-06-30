import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

import { Livro } from './../../../model/livro';
import { LivroService } from './../../../services/livro.service';

@Component({
  selector: 'app-livro-read',
  templateUrl: './livro-read.component.html',
  styleUrls: ['./livro-read.component.css']
})
export class LivroReadComponent implements OnInit {

  id_cat: String = ''

  livro: Livro = {
    id: '',
    titulo: '',
    nome_autor: '',
    texto: ''
  }

  constructor(private FormBuilder: FormBuilder,
    private service: LivroService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id_cat = this.route.snapshot.paramMap.get('id_cat')!
    this.livro.id = this.route.snapshot.paramMap.get('id')!
    this.findById()
  }

  onUpdate() {
    this.service.update(this.livro).subscribe(resposta => this.onSuccess(), error => this.onError());
  }

  findById() {
    this.service.findById(this.livro.id).subscribe((resposta) => {
      this.livro = resposta
    })
  }

  onSuccess() {
    this.snackBar.open('Livro atualizado com sucesso!', '', { duration: 5000 });
    this.onCancel();
  }

  onError() {
    this.snackBar.open('Erro ao atualizar Livro!', '', { duration: 5000 });
  }

  onCancel() {
    this.location.back();
  }

}
