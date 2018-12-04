import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DropDownService } from '../service/dropdown.service';
import { GlobalService } from '../service/global.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-right-nav',
  templateUrl: './right-nav.component.html',
  styleUrls: ['./right-nav.component.css'],
  providers:[DropDownService]
})
export class RightNavComponent implements OnInit {

  recipeData:any;
  recipe:any=-1;
  public subscription : Subscription;

  constructor( private router:Router,private dropService:DropDownService,private globalService:GlobalService) { }

  ngOnInit() {
    this.dropService.getDropDown(this);
    //capturing the event so that the drpdown can be updated on the go
    this.subscription = this.globalService.notifyObservable$.subscribe((res) =>{
      if (res.hasOwnProperty('option') && res.option === 'dropdown') {
        this.dropService.getDropDown(this);
      }
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
  
  getDropdown(data){
    this.recipeData = data.result;
  }

  onValChange(data){
    if(data != -1){
      this.router.navigate(['get'])
    }
    localStorage.setItem('id',data);
    //emitting the event so that the data can be updated dropdown value change
    this.globalService.notifyOther({option:'update'})
  }

  add(){
    this.recipe = -1
    this.router.navigate(['add'])
  }
}
