import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeModule} from '../home-module/home.module';

const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
    imports: [
        HomeModule,
        RouterModule.forRoot(routes),
    ],
    exports: [RouterModule]
})
export class AppRoutingModule { }