import { HttpClient } from '@angular/common/http';
import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { PhoneNumber } from './PhoneNumber';
import { PhoneNumberResponse } from './PhoneNumbersResponse';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  phoneNumbers: PhoneNumber[];
  phoneNumbersResponse: PhoneNumberResponse;
  
  country: string = null;
  state: string = null;
  pageNum: number = 0;
  pageSize: number = 5;
  totalPages: number = 1;


  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.getPhoneNumbers();
  }

  getPhoneNumbers() {
    var url:string = `http://localhost:8081/jumia-customers/phone-numbers?pageNum=${this.pageNum}&pageSize=${this.pageSize}`;

    if (this.country !== null && this.state !== null) {
      url = url.concat(`&country=${this.country}&state=${this.state}`);
    } else if (this.country !== null) {
      url = url.concat(`&country=${this.country}`);
    } else if (this.state !== null) {
      url = url.concat(`&state=${this.state}`);
    }

    console.log(url);

    this.httpClient.get<PhoneNumberResponse>(url).subscribe(
      response => {
        this.phoneNumbersResponse = response;
        this.phoneNumbers = response["content"];
        this.totalPages = response["totalPages"];
        console.log(response);
        console.log(this.totalPages);
      }
    );
  }

  onCountryChange(countryValue: string) {
    if(countryValue == "Select country") {
      this.country = null;
    } else {
      this.country = countryValue;
    }
  }

  onStateChange(stateValue: string) {
    if(stateValue == "Select state") {
      this.state = null;
    } else {
      this.state = stateValue;
    }
  }

  counter(i: number) {
    return new Array(i);
  } 

  onPageChange(index: number) {
    this.pageNum = index;
    this.getPhoneNumbers();
  }

  onSearch() {
    this.pageNum = 0;
    this.getPhoneNumbers();
  }
}
