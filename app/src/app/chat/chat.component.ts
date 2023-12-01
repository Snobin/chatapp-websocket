import { Component, OnInit } from '@angular/core';
import { Model } from '../model';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  constructor(public service: ServiceService) {

  }
  ngOnInit(): void {
    window.onbeforeunload = () => this.onLogout();
  }
  objec: Model = new Model();
  connect() {
    this.service.onConnected(this.objec)
    this.loggedIn = true

  }
  onLogout() {

    this.service.onLogout();
  }
  SendMessage() {

    const syntheticEvent = new Event('syntheticEvent');


    this.service.sendMessage(syntheticEvent);
  }

  messageFormVisible: any = true;
  messageContent: any;
  loggedIn: any = false;

}
