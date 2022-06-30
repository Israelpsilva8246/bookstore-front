import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';

import { ErrorDialogComponent } from './../../shared/component/error-dialog/error-dialog.component';
import { Cliente } from './../model/cliente';
import { ClientesService } from './../services/clientes.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.scss']
})
export class ClientesComponent implements OnInit {

  clientes$: Observable<Cliente[]>;

  displayedColumns = ["_id", "nome", "sobrenome", "idade", "actions"]

  // clientesService: ClientesService;

  constructor(
    private clientesService: ClientesService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute) {
   // this.clientesService = new ClientesService;
  //   this.clientesService.list()
  //  .subscribe(clientes => this.clientes = clientes);
  this.clientes$ = this.clientesService.list()
  .pipe(
    catchError(error => {
      this.onError('Error loading clients.');
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

  onAdd() {
    this.router.navigate(['new'], {relativeTo: this.route})
  }

  onEdit() {
    console.log('Edit')
  }

  onDelete() {
    console.log('Delete')
  }

}
