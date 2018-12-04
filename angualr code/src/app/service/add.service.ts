import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { ConstantService } from './constant.service';

@Injectable()
export class AddService {
  public respData;
  public url:any;

  constructor(private http: HttpClient, private constantService: ConstantService) { 
  this.url=constantService.getUrl();
  }

  add(data){
      return this.http.post(this.url+'/recipe/addRecipe',data);
  }
  addRecipe(data,callback){
    this.add(data).subscribe(resp=>{
        this.respData = resp;
        callback.addRecipe(this.respData)
    },
    error=>{
        console.log("error")
    });
  }
}