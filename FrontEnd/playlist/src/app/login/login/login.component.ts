import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData = {
    "username" : '',
    "password" : ''
  }

  constructor(private loginService:LoginService, private router:Router) { }

  ngOnInit(): void {
  }

  formSubmit(){
    // console.log("click en el boton de login");
    if(this.loginData.username.trim() == '' || this.loginData.username.trim() == null){
      alert("El nombre de usuario es requrido")
      return;
    }

    if(this.loginData.password.trim() == '' || this.loginData.password.trim() == null){
      alert("La contraseña es requerida")
      return;
    }

    this.loginService.genarateToken(this.loginData).subscribe(
      (data:any) => {
        console.log(data);
        this.loginService.loginUser(data.token)
        this.loginService.getCuerrentUser().subscribe((user:any) =>{
          this.loginService.setUser(user)
          console.log(user);

          if(this.loginService.getUserRol() == "ROLE_ADMIN"){
            //Dashboard admin
            // window.location.href = '/admin'
            this.router.navigate(['home']);
            this.loginService.loginStatusSubject.next(true);
          }else if(this.loginService.getUserRol() == "NORMAL"){
            // window.location.href = '/user-dasboard'
            this.router.navigate(['user-dashboard/0']);
            this.loginService.loginStatusSubject.next(true);
          }else{
            this.loginService.logout();
          }
        })
      },(error) => {
        console.log(error);
        alert("Detalles invalidos, vuelve a intentar")
      }
    )

  }

}
