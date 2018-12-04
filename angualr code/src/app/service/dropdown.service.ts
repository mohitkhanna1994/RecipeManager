import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { ConstantService } from './constant.service';

@Injectable()
export class DropDownService {
  public data;
  public url:any;

  constructor(private http: HttpClient, private constantService: ConstantService) { 
  this.url=constantService.getUrl();
  }
  dropdown(){
      return this.http.get(this.url+'/recipe/getDropdown')
  }
  getDropDown(callback){
    this.dropdown().subscribe(resp=>{
        this.data = resp;
        callback.getDropdown(this.data)
    },
    error => {
        console.log(error);
        console.log("Error Occured");
      } );
  }

}