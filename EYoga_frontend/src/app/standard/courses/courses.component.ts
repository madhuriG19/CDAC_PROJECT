import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  constructor(private _router : Router) { }

  ngOnInit(): void {
  }

  gotologinpage(){
 
  this._router.navigate(['/login']);

}
}
