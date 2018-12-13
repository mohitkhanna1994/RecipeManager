import { Component, OnInit } from '@angular/core';
import { GetRecipeService } from '../service/getRecipe.service';
import { GlobalService } from '../service/global.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-get',
  templateUrl: './get.component.html',
  styleUrls: ['./get.component.css'],
  providers:[GetRecipeService]
})
export class GetComponent implements OnInit {

  public subscription : Subscription;
  public recipe: any;
  public recipeName :any;
  public ingList :any;
  constructor(private getService:GetRecipeService,private globalService:GlobalService) { }

  ngOnInit() {
    this.getReciepeForId();
    //capturing the event so that the data can be updated when dropdown value changes
    this.subscription = this.globalService.notifyObservable$.subscribe((res) =>{
      if (res.hasOwnProperty('option') && res.option === 'update') {
        this.getReciepeForId();
      }
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
  
  //callback for get Recipe for id service call
  getRecipe(data){
    this.recipe = data.result;
    this.recipeName = this.recipe.name;
    this.ingList = this.recipe.ingredients;
    console.log(this.ingList)    
  }

  getReciepeForId(){
    var id=localStorage.getItem('id')
    this.getService.getRecipe(id,this);
  }
}
