import { PessoaService } from './../../../../service/pessoa.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Navigation, Router } from '@angular/router';
import { Pessoa } from 'src/app/core/model/pessoa.model';

@Component({
  selector: 'app-cadastrar-pessoas',
  templateUrl: './cadastrar-pessoas.component.html',
  styleUrls: ['./cadastrar-pessoas.component.scss']
})
export class CadastrarPessoasComponent implements OnInit {

  title = 'Register for stuff';
  cadastro;
  data: any = {};
  routeState: any;

  constructor(private pessoaService: PessoaService, private formBuilder: FormBuilder, private router: Router) {
    this.cadastro = this.formBuilder.group({
      id: '',
      nomeCompleto: '',
      dataNascimento: '',
      email: '',
      cpf: '',
      celular: '',
      dataCriacao:''
    });

    if (this.router.getCurrentNavigation().extras.state) {
      this.routeState = this.router.getCurrentNavigation().extras.state;
      if (this.routeState) {
       this.cadastro.setValue(this.routeState.pessoaEdit ? JSON.parse(this.routeState.pessoaEdit) as Pessoa  : '')
      }
    }
  }

  ngOnInit(): void {

  }

  submit(): void {

    this.cadastro.markAllAsTouched();
    if (this.cadastro.invalid) {
      return;
    }

  const pessoa = this.cadastro.getRawValue() as Pessoa;
      this.salvar(pessoa)
  }

  private salvar(pessoa: Pessoa): void {
    this.pessoaService.salvar(pessoa).subscribe(
      sucess =>  this.router.navigateByUrl('pessoas'),
      error => console.log("Error")
      );
    }
  }
