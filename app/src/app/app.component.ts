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
export class AppComponent {
constructor(public service:ServiceService){}
objec:Model=new Model();
connect() {
  this.service.sendMessage(this.objec)
// throw new Error('Method not implemented.');
}
onLogout() {
throw new Error('Method not implemented.');
}
sendMessage() {
throw new Error('Method not implemented.');
}
loggedIn: any;
messageFormVisible: any;
messageContent: any;
  
}
