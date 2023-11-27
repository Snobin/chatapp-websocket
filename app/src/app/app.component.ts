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
  this.service.onConnected(this.objec)
  this.loggedIn=true
// throw new Error('Method not implemented.');
}
onLogout() {
throw new Error('Method not implemented.');
}
callSendMessage() {
  // Assuming you have an event object to pass, you can create a synthetic one
  const syntheticEvent = new Event('syntheticEvent');

  // Call the sendMessage method
  this.service.sendMessage(syntheticEvent);
}

messageFormVisible: any=true;
messageContent: any;
loggedIn:any=false;
  
}
