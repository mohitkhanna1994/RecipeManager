import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { RightNavComponent } from './right-nav/right-nav.component';
import { routing } from './app.routing';
import { AddComponent } from './add/add.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { DropDownService } from './service/dropdown.service';
import { ConstantService } from './service/constant.service';
import { AddService } from './service/add.service';
import { GetComponent } from './get/get.component';
import { GetRecipeService } from './service/getRecipe.service';
import { GlobalService } from './service/global.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RightNavComponent,
    AddComponent,
    HomeComponent,
    GetComponent    
  ],
  imports: [
    BrowserModule,
    routing,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [DropDownService,ConstantService,AddService,GetRecipeService,GlobalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
