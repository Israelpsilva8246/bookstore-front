import { ErrorDialogComponent } from './../../../../shared/components/error-dialog/error-dialog.component';
import { CategoriaService } from './../../../services/categoria.service';
import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/components/model/categoria';
import { catchError, Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categoria-read',
  templateUrl: './categoria-read.component.html',
  styleUrls: ['./categoria-read.component.css']
})
export class CategoriaReadComponent implements OnInit {

  categorias$: Observable<Categoria[]>;
  displayedColumns = ['id', 'nome', 'descricao', 'livros', 'acoes'];

  // categoriaService: CategoriaService;

  constructor(
    private categoriaService: CategoriaService,
    public dialog: MatDialog,
    private router: Router) {
    // this.categoriaService = new CategoriaService();
    this.categorias$ = this.categoriaService.findAll()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar categorias.')
        return of([])
      })
    );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  ngOnInit(): void {

  }

  navegarParaCategoriaCreate() {
    this.router.navigate(["categorias/create"])
  }

}
