import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenuComponent } from './menu/menu.component';
import { LayoutModule } from '@angular/cdk/layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatToolbarModule, MatDatepickerModule, MatNativeDateModule,
  MatFormFieldModule, MatSelectModule, MatButtonModule, MatInputModule, MatTableModule,
  MatSidenavModule, MatIconModule, MatListModule, MatCardModule, MatSnackBarModule,
  MatDialogModule } from '@angular/material';
import { ClienteComponent } from './cliente/cliente.component';
import { ProdutoComponent } from './produto/produto.component';
import { PedidoComponent } from './pedido/pedido.component';
import { ClienteService } from '../app/service/cliente.service';
import { ProdutoService } from '../app/service/produto.service';
import { PedidoService } from '../app/service/pedido.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

const appRoutes: Routes = [
  { path: 'cliente', component: ClienteComponent},
  { path: 'produto', component: ProdutoComponent},
  { path: 'pedido', component: PedidoComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ClienteComponent,
    ProdutoComponent,
    PedidoComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    CommonModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule,    
    LayoutModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatToolbarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatSnackBarModule,
    MatTableModule,
    MatDialogModule
  ],
  providers: [
    MatDatepickerModule, MatSnackBarModule, MatTableModule,
    ClienteService, ProdutoService, PedidoService
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
