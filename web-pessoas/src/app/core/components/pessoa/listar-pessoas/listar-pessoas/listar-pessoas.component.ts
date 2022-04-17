import { Router } from '@angular/router';
import { Pessoa } from './../../../../model/pessoa.model';
import { PessoaService } from './../../../../service/pessoa.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-listar-pessoas',
  templateUrl: './listar-pessoas.component.html',
  styleUrls: ['./listar-pessoas.component.scss']
})
export class ListarPessoasComponent implements OnInit {


  displayedColumns: string[] = ['id', 'nome', 'dataNascimento', 'email', 'celular', 'cpf', 'dataCriacao', 'acoes'];

  pageEvent: PageEvent;
  dataSource: MatTableDataSource<Pessoa>;
  pageIndex: number;
  pageSize: number;
  length: number;
  cpf = ''

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private pessoaService: PessoaService, private router: Router) {
  }

  ngOnInit() {
    this.buscarRegistros(new PageEvent());
  }

  public buscarRegistros(event?: PageEvent) {
    this.pessoaService.buscarRegistros(event).subscribe(
      response => {
        this.dataSource = new MatTableDataSource<Pessoa>(response.content);
        this.pageIndex = response.pageable.pageNumber;
        this.pageSize = response.pageable.pageSize;
        this.length = response.totalElements;
        this.dataSource.paginator = this.paginator;
      },
      error => {

      }
    );
    return event;
  }

  edit(pessoa) {
    this.router.navigate(['/cadastrar'], { state: { pessoaEdit: JSON.stringify(pessoa) } });
  }

  buscarPorCpf() {
    this.pessoaService.buscarPorCpf(this.cpf).subscribe(
      response => {
        this.dataSource = new MatTableDataSource<Pessoa>(response.content);
      }
    )
  }

  delete(id: number) {
    this.pessoaService.deletar(id).subscribe(
      response => {
        this.buscarRegistros(new PageEvent());

      }
    )
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}


