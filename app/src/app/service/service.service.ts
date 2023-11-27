import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Model } from '../model';
declare var SockJS;
declare var Stomp;
@Injectable({
  providedIn: 'root'
})
export class ServiceService  {

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
  userObj:any=new Model();
  onConnected(obj: any) {
    this.userObj=obj;
    this.stompClient.subscribe(`/user/${this.nickname}/queue/messages`, this.onMessageReceived.bind(this));

// Subscribe to the public message queue
this.stompClient.subscribe(`/user/public`, this.onMessageReceived.bind(this));
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
          // console.log(index);
          // const listItem = document.createElement('li');
          // listItem.textContent = user.nickName;
          // connectedUsersList.appendChild(listItem);

          this.appendUserElement(user, connectedUsersList);

          // Add separator if not the last user
          if (index < filteredUsers.length - 1) {
            const separator = document.createElement('li');
            separator.classList.add('separator');
            connectedUsersList.appendChild(separator);
          }
        });
      } else {
        console.error('Connected Users List Element not found');
      }
    } catch (error) {
      console.error('Error fetching or processing connected users:', error);
    }
  }


  appendUserElement(user: any, connectedUsersList: any): void {
    const listItem = document.createElement('li');
    // listItem.classList.add('user-item');
    listItem.id = user.nickName;

    const userImage = document.createElement('img');
    userImage.src = '../assets/img/user_icon.jpg';
    userImage.alt = user.fullName;
    userImage.width = 40; // Set the desired width
    userImage.height = 40;

    const usernameSpan = document.createElement('span');
    usernameSpan.textContent = user.fullName;
    usernameSpan.style.margin = '10px'; // Adjust the left margin as needed
    usernameSpan.style.fontSize = '16px';


    const receivedMsgs = document.createElement('span');
    receivedMsgs.textContent = '0';
    receivedMsgs.classList.add('nbr-msg', 'hidden');
    receivedMsgs.style.margin = '10px'; // Adjust the left margin as needed
    receivedMsgs.style.fontSize = '16px';

    listItem.appendChild(userImage);
    listItem.appendChild(usernameSpan);
    listItem.appendChild(receivedMsgs);

    listItem.addEventListener('click', this.userItemClick);

    connectedUsersList.appendChild(listItem);
  }

  userItemClick = (event: MouseEvent): void => {
    // Remove 'active' class from all user items
    document.querySelectorAll('.user-item').forEach(item => {
      item.classList.remove('active');
    });

    // Show the message form
    const messageForm = document.getElementById('messageForm');
    messageForm.classList.remove('hidden');

    // Add 'active' class to the clicked user
    const clickedUser = event.currentTarget as HTMLLIElement;
    clickedUser.classList.add('active');

    // Get the ID of the clicked user
    const selectedUserId = clickedUser.getAttribute('id');

    console.log(selectedUserId);
    // Fetch and display user chat
    this.fetchAndDisplayUserChat(selectedUserId).then();
    this.selectedUserId = selectedUserId;
    console.log("global", this.selectedUserId);
    console.log("local", selectedUserId);
    // Hide and reset the number of messages
    const nbrMsg = clickedUser.querySelector('.nbr-msg') as HTMLSpanElement;
    nbrMsg.classList.add('hidden');
    nbrMsg.textContent = '0';
  }


  // Example usage
  selectedUserId: any;

  async fetchAndDisplayUserChat(selectedUserId: string): Promise<void> {
    try {
      const userChatResponse = await this.http.get<any>(`http://localhost:8088/messages/${this.nickname}/${selectedUserId}`).toPromise();
      // const userChat = await userChatResponse.json();

      // Assuming chatArea is defined somewhere in your class
      const chatArea = document.getElementById('chat-messages') as HTMLDivElement;

      if (chatArea) {
        chatArea.innerHTML = '';

        userChatResponse.forEach(chat => {
          this.displayMessage(chat.senderId, chat.content);
        });

        chatArea.scrollTop = chatArea.scrollHeight;
      } else {
        console.error('Chat Area Element not found');
      }
    } catch (error) {
      console.error('Error fetching or processing user chat:', error);
    }
  }

  displayMessage(senderId: string, content: string): void {
    const messageContainer = document.createElement('div');
    messageContainer.classList.add('message');

    // Assuming nickname is a property in your class
    if (senderId === this.nickname) {
      messageContainer.classList.add('sender');
    } else {
      messageContainer.classList.add('receiver');
    }

    const message = document.createElement('p');
    message.textContent = content;

    messageContainer.appendChild(message);

    // Assuming chatArea is a property in your class
    const chatArea = document.getElementById('chat-messages') as HTMLDivElement;

    if (chatArea) {
      chatArea.appendChild(messageContainer);
    } else {
      console.error('Chat Area Element not found');
    }
  }
  // Assuming this is a method inside your service
  sendMessage(event: Event): void {
    const messageInput = document.getElementById('message') as HTMLInputElement;

    if (messageInput && this.stompClient) {
      const messageContent = messageInput.value.trim();

      if (messageContent) {
        const chatMessage = {
          senderId: this.nickname,
          recipientId: this.selectedUserId,
          content: messageContent,
          timestamp: new Date()
        };

        this.stompClient.send("/app/chat", {}, JSON.stringify(chatMessage));
        this.displayMessage(this.nickname, messageContent);
        messageInput.value = '';
      }
    }

    // Assuming chatArea is a property in your class
    const chatArea = document.getElementById('chat-messages') as HTMLDivElement;

    if (chatArea) {
      chatArea.scrollTop = chatArea.scrollHeight;
    } else {
      console.error('Chat Area Element not found');
    }

    event.preventDefault();
  }

  async onMessageReceived(payload: any): Promise<void> {
    await this.findAndDisplayConnectedUsers();
    console.log('Message received', payload);
    const message = JSON.parse(payload.body);

    // Assuming selectedUserId, displayMessage, chatArea, messageForm are properties of your class
    if (this.selectedUserId && this.selectedUserId === message.senderId) {
        this.displayMessage(message.senderId, message.content);
        const chatArea = document.getElementById('chat-messages') as HTMLDivElement;
        if (chatArea) {
            chatArea.scrollTop = chatArea.scrollHeight;
        }
    }

    if (this.selectedUserId) {
        const selectedUserElement = document.querySelector(`#${this.selectedUserId}`);
        if (selectedUserElement) {
            selectedUserElement.classList.add('active');
        }
    } else {
        const messageForm = document.getElementById('messageForm') as HTMLFormElement;
        if (messageForm) {
            messageForm.classList.add('hidden');
        }
    }

    const notifiedUser = document.querySelector(`#${message.senderId}`);
    if (notifiedUser && !notifiedUser.classList.contains('active')) {
        const nbrMsg = notifiedUser.querySelector('.nbr-msg') as HTMLSpanElement;
        if (nbrMsg) {
            nbrMsg.classList.remove('hidden');
            nbrMsg.textContent = '';
        }
    }
}

onLogout(){
  this.userObj.status="OFFLINE"
  this.stompClient.send('/app/user.disconnectUser',{},JSON.stringify(this.userObj));
  window.location.reload();
}

}

