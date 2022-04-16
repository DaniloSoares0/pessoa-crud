import { CadastrarPessoasComponent } from './core/components/pessoa/cadastrar-pessoas/cadastrar-pessoas/cadastrar-pessoas.component';
import { ListarPessoasComponent } from './core/components/pessoa/listar-pessoas/listar-pessoas/listar-pessoas.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'pessoas',
    pathMatch: 'full'
  },
  {
   path: 'pessoas',
   component: ListarPessoasComponent
  },
  {
   path: 'cadastrar',
   component: CadastrarPessoasComponent
  }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
