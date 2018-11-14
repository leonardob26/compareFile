import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'compare-file',
  templateUrl: './compare-file.component.html',
  styleUrls: ['./compare-file.component.css']
})
export class CompareFileComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  checkEqual() {
    console.log('checking');
  }

}
