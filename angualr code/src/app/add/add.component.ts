import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { AddService } from '../service/add.service';
import { GlobalService } from '../service/global.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
  providers:[AddService]
})
export class AddComponent implements OnInit {

  addForm : FormGroup;

  constructor(private fb: FormBuilder, private addService:AddService,public globalService:GlobalService) {
    this.addForm = fb.group({
      'name' : [null, Validators.required],
      'ing1' : [null, Validators.required],
      'ing2' : [null],
      'ing3' : [null],
      'ing4' : [null],
    });
   }

  ngOnInit() {
  }

  add(formdata){
    console.log(formdata)
    this.addService.addRecipe(formdata,this);
  }
  addRecipe(response){
    alert("Recipe added successfully");
    this.addForm.reset();
    //emitting the event so that the drpdown can be updated on the go
    this.globalService.notifyOther({option:'dropdown'})
  }
  reset(){
    this.addForm.reset();
  }
  addRecipeError(error){
    alert(error.error.message);
  }
}
