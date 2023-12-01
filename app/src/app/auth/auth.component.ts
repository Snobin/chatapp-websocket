import { Component } from '@angular/core';
import { Model } from '../model';
import { Router } from '@angular/router';
import { JwtService } from '../service/jwt.service';


@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent {
  user:Model=new Model();
  isLogin: boolean = true;
  constructor(private jwtservice:JwtService,private router:Router){};

  login() {
   
    console.log('Login clicked');
    this.jwtservice.authenticate(this.user).subscribe((response:any)=>{
      console.log(response);
      if(response.message=="Success"){
        alert("login Successful");
        console.log(response.token.token)
        localStorage.setItem('logintoken',response.token.token);

        this.router.navigate(['/chat']);
      }
      else if(response.message=="Error"){
        alert("Invalid Credentials")
      }
    });
   

  }

  signup() {
    console.log('Sign Up clicked',this.user);

    this.jwtservice.register(this.user).subscribe((response:any)=>{
      console.log(response);
      if(response.message=="Success"){
        alert("SignUp Successful")
        localStorage.setItem('logintoken',response.token.token);
        this.router.navigate(['/chat'])
        console.log(response.token.token)
      }
    });
    this.clearUser();
  }
  clearUser() {
    this.user = {
      // Reset user properties to their initial values or an empty state
      // For example:
      email:'',
      firstname: '',
      lastname:'',
      password: '',
      nickName:'',
    fullName:'',
    status:''
      // Add other properties as needed
    };}

  toggleForm() {
    this.isLogin = !this.isLogin;
  }
}
