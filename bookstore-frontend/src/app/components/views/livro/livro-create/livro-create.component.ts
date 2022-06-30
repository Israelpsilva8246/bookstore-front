import { Livro } from './../../../model/livro';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { LivroService } from './../../../services/livro.service';

@Component({
  selector: 'app-livro-create',
  templateUrl: './livro-create.component.html',
  styleUrls: ['./livro-create.component.css']
})
export class LivroCreateComponent implements OnInit {

  titulo = new FormControl("", [Validators.minLength(3)]);
  nome_autor = new FormControl("", [Validators.minLength(3)]);
  texto = new FormControl("", [Validators.minLength(10)]);

  form2: FormGroup;

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
    private route: ActivatedRoute) {
      this.form2 = this.FormBuilder.group({
        titulo: [null],
        nome_autor: [null],
        texto: [null]
      })
     }

  ngOnInit(): void {
    this.id_cat = this.route.snapshot.paramMap.get('id_cat')!
  }

  onCreate() {
    this.service.create(this.livro, this.id_cat).subscribe(resposta => this.onSuccess(), error => this.onError());
  }

  onSuccess() {
    this.snackBar.open('Livro criado com sucesso!', '', { duration: 5000 });
    this.onCancel();
  }

  onError() {
    this.snackBar.open('Erro ao criar Livro!', '', { duration: 5000 });
  }

  onCancel() {
    this.location.back();
  }

  getMessage() {
    if (this.titulo.invalid) {
      return "O campo TITULO deve conter entre 3 a 100 caracteres";
    }

    if (this.nome_autor.invalid) {
      return "O campo NOME DO AUTOR deve conter entre 3 a 100 caracteres";
    }

    if (this.texto.invalid) {
      return "O campo TEXTO deve conter entre 10 a 2.000.000 caracteres";
    }
    return false;
  }

}
