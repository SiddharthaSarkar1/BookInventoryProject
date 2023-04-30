import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiuserService } from 'src/app/services/apiuser.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {
  sidData:any;
  sidId:any;
  constructor(private router: Router, private userService: ApiuserService) { }

  ngOnInit(): void {
    this.sidId = sessionStorage.getItem('CuserId');
    console.log(this.sidId);
    this.getSidData(this.sidId);
  }

  edituprof(id:number){
    this.router.navigate(['/userprofileedit/'+id]);
  }

  getSidData(id:any){
    this.userService.getUserByID(id).subscribe((res) => {
      console.log(res)
      this.sidData = res; 
    })
  }

}
