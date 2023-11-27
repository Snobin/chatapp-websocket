import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import * as SockJS from 'sockjs-client';
import * as Stomp from 'stompjs';
import { ServiceService } from './service/service.service';
import { Model } from './model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

constructor(public service:ServiceService){

}
  ngOnInit(): void {
    
  }
objec:Model=new Model();
connect() {
  this.service.sendMessage(this.objec)
  this.loggedIn=true
// throw new Error('Method not implemented.');
}
onLogout() {
throw new Error('Method not implemented.');
}
sendMessage() {
throw new Error('Method not implemented.');
}

messageFormVisible: any=true;
messageContent: any;
loggedIn:any=false;
  
}
