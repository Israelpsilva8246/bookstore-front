import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { CategoriaService } from './../../../services/categoria.service';

@Component({
  selector: 'app-categoria-create',
  templateUrl: './categoria-create.component.html',
  styleUrls: ['./categoria-create.component.css']
})
export class CategoriaCreateComponent implements OnInit {

  form: FormGroup;

  constructor(private FormBuilder: FormBuilder,
    private service: CategoriaService,
    private snackBar: MatSnackBar,
    private location: Location) {
      this.form = this.FormBuilder.group({
        nome: [null],
        descricao: [null]
      })
     }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.create(this.form.value).subscribe(result => this.onSuccess(), error => this.onError());
  }

  onCancel() {
    this.location.back();
  }

  private onSuccess() {
    this.snackBar.open('Categoria criado com sucesso', '', { duration: 5000 });
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao criar categoria', '', { duration: 5000 });
  }

}
