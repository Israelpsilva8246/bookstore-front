import { ErrorDialogComponent } from './../../../../shared/components/error-dialog/error-dialog.component';
import { LivroService } from './../../../services/livro.service';
import { Livro } from './../../../model/livro';
import { catchError, Observable, of } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-livro-read-all',
  templateUrl: './livro-read-all.component.html',
  styleUrls: ['./livro-read-all.component.css']
})
export class LivroReadAllComponent implements OnInit {

  livros$: Observable<Livro[]>;
  displayedColumns = ['id', 'titulo', 'livros', 'acoes'];

  livros: Livro[] = []

  id_cat: String = ''

  constructor(
    private livroService: LivroService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.id_cat = this.route.snapshot.paramMap.get('id_cat')!
    this.livros$ = this.livroService.findAllByCategoria(this.id_cat)
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar categorias.')
        return of([])
      })
    )
    this.findAll();
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  ngOnInit(): void {

  }

  findAll() {
    this.livroService.findAllByCategoria(this.id_cat).subscribe((resposta) => {
      this.livros = resposta;
      console.log(this.livros)
    })
  }

  navegarParaCriarLivro() {
    this.router.navigate([`categorias/${this.id_cat}/livros/create`])
  }
}
