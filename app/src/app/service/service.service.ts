import { Injectable } from '@angular/core';

declare var SockJS;
declare var Stomp;
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor() {
    this.initializeWebSocketConnection();
  }
  public stompClient;
  public msg = [];
  initializeWebSocketConnection() {
    const serverUrl = 'http://localhost:8088/sockt';
    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
   
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe('/message', (message) => {
        if (message.body) {
          that.msg.push(message.body);
        }
      });
    });
  }
  
  sendMessage(obj:Object) {
    if (this.stompClient && this.stompClient.connected) {
      this.stompClient.send('/app/user.adduser' , {}, JSON.stringify(obj));
  } else {
      console.error('WebSocket connection is not established.');
  }
  }
}
