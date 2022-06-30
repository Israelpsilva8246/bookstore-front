import { LivroService } from './../../../services/livro.service';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Livro } from './../../../model/livro';

@Component({
  selector: 'app-livro-update',
  templateUrl: './livro-update.component.html',
  styleUrls: ['./livro-update.component.css']
})
export class LivroUpdateComponent implements OnInit {

  titulo = new FormControl("", [Validators.minLength(3)]);
  nome_autor = new FormControl("", [Validators.minLength(3)]);
  texto = new FormControl("", [Validators.minLength(10)]);

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
