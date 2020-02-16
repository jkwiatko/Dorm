import {Component, Input, OnInit} from '@angular/core';
import {ProfileModel} from '../../profile-module/models/profile.model';


@Component({
  selector: 'app-profile-sticky-info',
  templateUrl: './profile-sticky-info.component.html',
  styleUrls: ['./profile-sticky-info.component.scss']
})
export class ProfileStickyInfoComponent implements OnInit {

  @Input() profile: ProfileModel;

  constructor() { }

  ngOnInit() {
  }

}