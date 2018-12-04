import { Injectable } from '@angular/core';

@Injectable()
export class ConstantService {

  public url:String;

  constructor() {
    this.url="http://192.168.50.202:8080";
   
   }
   getUrl(){
     return this.url;
   }
}
