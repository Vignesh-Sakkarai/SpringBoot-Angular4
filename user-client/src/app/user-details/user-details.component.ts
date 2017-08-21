import { Component, Input } from '@angular/core';
import { User } from '../user';
import { DataService } from '../data.service';
import { FormGroup, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'user-form',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent {
  submitted = false;
  userarray: User[];
  constructor(private userService: DataService) { }
  userform: FormGroup;

  ngOnInit(user){
    this.userform = new FormGroup({
      userName: new FormControl("", Validators.required),
      jobTitle: new FormControl("", Validators.required)
    })
    this.loadUserDetails(this.userarray);    
  }

  myevent(event, user){
    if(event == 'GET'){
      this.loadUserDetails(this.userarray);
    }else if(event == 'POST'){
      this.createUser(user);
      this.userform.reset();
      this.loadUserDetails(this.userarray);
    }
  }

  createUser(user){
    this.userService.createUser(user).subscribe(
      data => {
        return true;  
      }, error =>{
        console.error("Error saving User!");
      })
      this.loadUserDetails(this.userarray);
  }

  loadUserDetails(userarray){
    userarray = this.userService.loadUserDetails().subscribe(
      data => { this.userarray = data},
      err => console.error(err)
    );
  }
}
