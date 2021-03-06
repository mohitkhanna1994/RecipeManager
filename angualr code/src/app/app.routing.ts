import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AddComponent } from './add/add.component';
import { HomeComponent } from './home/home.component';
import { GetComponent } from './get/get.component';
import { AddRecipeComponent } from './add-recipe/add-recipe.component';

const appRoutes: Routes = [
   
    { path: 'add', component: AddRecipeComponent},
    { path: 'get', component: GetComponent},
    { path: 'home', component:HomeComponent},
    { path:'**',component:HomeComponent}
];

export const routing = RouterModule.forRoot(appRoutes);
