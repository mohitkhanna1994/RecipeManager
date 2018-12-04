import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { ConstantService } from './constant.service';

@Injectable()
export class GetRecipeService {
  public data;
  public url:any;

  constructor(private http: HttpClient, private constantService: ConstantService) { 
  this.url=constantService.getUrl();
  }

  get(data){
      return this.http.get(this.url+'/recipe/getRecipe?id='+data);
  }
  getRecipe(data,callback){
    this.get(data).subscribe(resp=>{
        this.data = resp;
        callback.getRecipe(this.data);
    },
    error=>{
        console.log("error");
    });
  }
}