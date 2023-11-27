import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
declare var SockJS;
declare var Stomp;
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  public stompClient;
  public msg = [];

  constructor(private http: HttpClient) {
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection() {
    const serverUrl = 'http://localhost:8088/sockt';
    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;

    this.stompClient.connect({}, function (frame) {

      that.stompClient.subscribe(`/user/public`, (message) => {
        if (message.body) {
          that.msg.push(message.body);
        }
      });

    });


  }

  nickname: string;
  sendMessage(obj: any) {
    const that = this; // Store reference to 'this' for use inside the callback
    this.nickname = obj.nickName;
    if (this.stompClient && this.stompClient.connected) {

      const a = this.nickname;
      console.log(a)
      that.stompClient.subscribe(`/user/${this.nickname}/queue/public`, (message) => {
        if (message.body) {
          that.msg.push(message.body);
        }
      });
      this.stompClient.send('/app/user.adduser', {}, JSON.stringify(obj));

      this.findAndDisplayConnectedUsers().then();
    } else {
      console.error('WebSocket connection is not established.');
    }
  }
  async findAndDisplayConnectedUsers(): Promise<void> {
    try {
      const connectedUsers = await this.http.get<any[]>('http://localhost:8088/users').toPromise();
      console.log(connectedUsers);

      // Assuming that the API response is an array of users directly
      const filteredUsers = connectedUsers.filter((user: any) => user.nickName !== this.nickname);

      const connectedUsersList = document.getElementById('connectedUsers') as HTMLUListElement;
      console.log(connectedUsersList);

      if (connectedUsersList) {
        connectedUsersList.innerHTML = '';

        filteredUsers.forEach((user: any, index: number) => {
          console.log(index);
          const listItem = document.createElement('li');
          listItem.textContent = user.nickName;
          connectedUsersList.appendChild(listItem);

          // Add separator if not the last user
          // if (index < filteredUsers.length - 1) {
          //   const separator = document.createElement('li');
          //   separator.classList.add('separator');
          //   connectedUsersList.appendChild(separator);
          // }
        });
      } else {
        console.error('Connected Users List Element not found');
      }
    } catch (error) {
      console.error('Error fetching or processing connected users:', error);
    }
  }


  appendUserElement(user: any, parentElement: HTMLUListElement): void {
    // Implement the logic to create and append user elements to the list
    // For example, create an li element, set its content or attributes, and append it to the parentElement.
  }

}
