import { Component, OnInit } from '@angular/core';
import { FormGroup, FormArray, FormBuilder, Validators } from '@angular/forms';
import { GlobalService } from '../service/global.service';
import { AddService } from '../service/add.service';

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {

  constructor(private fb: FormBuilder,private addService:AddService,public globalService:GlobalService) { }

  productForm: FormGroup;
  limit : number = 1;
  ngOnInit() {
    /* Initiate the form structure */
    this.productForm = this.fb.group({
      name: [null, Validators.required],
      ingredients: this.fb.array([this.fb.group({ing:''})])
    })
  }

  get ingredients() {
    return this.productForm.get('ingredients') as FormArray;
  }

  add(formdata){
    console.log(formdata)
    this.addService.addRecipe(formdata,this);
  }
  addRecipe(response){
    alert("Recipe added successfully");
    this.productForm.reset();
    //emitting the event so that the drpdown can be updated on the go
    this.globalService.notifyOther({option:'dropdown'})
  }
  addRecipeError(error){
    alert(error.error.message);
  }
  reset(){
    this.productForm.reset();
  }
  addSellingPoint() {
    this.limit = this.limit+1;
    if(this.limit <= 4)
    this.ingredients.push(this.fb.group({ing:''}));
    else{
    this.limit =  this.limit -1;
    alert("max ingredients reached")
    }
  }

  deleteSellingPoint(index) {
    this.limit = this.limit-1 ;
    if(this.limit >=1)
    this.ingredients.removeAt(index);
    else{
      this.limit = this.limit + 1;
    alert("min 1 ingredient needed")
    }
  }
}
