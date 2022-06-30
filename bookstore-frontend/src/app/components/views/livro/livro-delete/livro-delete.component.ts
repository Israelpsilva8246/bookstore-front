import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Livro } from 'src/app/components/model/livro';
import { LivroService } from 'src/app/components/services/livro.service';

@Component({
  selector: 'app-livro-delete',
  templateUrl: './livro-delete.component.html',
  styleUrls: ['./livro-delete.component.css']
})
export class LivroDeleteComponent implements OnInit {

  id_cat: String = ''

  livro: Livro = {
    id: '',
    titulo: '',
    nome_autor: '',
    texto: ''
  }

  constructor(private service: LivroService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id_cat = this.route.snapshot.paramMap.get('id_cat')!
    this.livro.id = this.route.snapshot.paramMap.get('id')!
    this.findById()
  }

  onDelete() {
    this.service.delete(this.livro.id).subscribe(() => this.onSuccess(), error => this.onError());
  }

  findById() {
    this.service.findById(this.livro.id).subscribe((resposta) => {
      this.livro = resposta
    })
  }

  onSuccess() {
    this.snackBar.open('Livro deletado com sucesso!', '', { duration: 5000 });
    this.onCancel();
  }

  onError() {
    this.snackBar.open('Erro ao deletar Livro!', '', { duration: 5000 });
  }

  onCancel() {
    this.location.back();
  }

}
