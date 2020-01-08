import {Component, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup, Validators} from '@angular/forms';
import {ProfileService} from '../providers/profile.service';

export interface Profile {
    firstName: string;
    lastName: string;
    profileImage: string;
    birthDate: string;
    description: string;
    gender: string;
    work: string;
    university: string;
    interests: [string];
    inclinations: [string];
    cleaningPolicy: string;
    smokingPolicy: string;
    petPolicy: string;
    guestsPolicy: string;
}

@Component({
    selector: 'app-profile-edit',
    templateUrl: './profile-edit.component.html',
    styleUrls: ['./profile-edit.component.scss']
})
export class ProfileEditComponent implements OnInit {

    profileImg: string;
    profileImageFile: File;
    startDate = new Date(2000, 0, 1);
    form: FormGroup;
    interests: FormArray;
    inclinations: FormArray;

    constructor(private profileClient: ProfileService) {
    }

    get interestsControl() {
        return (this.form.get('interests') as FormArray).controls;
    }

    get inclinationsControl() {
        return (this.form.get('inclinations') as FormArray).controls;
    }

    ngOnInit() {
        const interests = new FormArray([]);
        const inclinations = new FormArray([]);

        this.form = new FormGroup({
            firstName: new FormControl(null, Validators.required),
            lastName: new FormControl(null, Validators.required),
            profileImage: new FormControl(null),
            birthDate: new FormControl(null, Validators.required),
            description: new FormControl(null, Validators.required),
            gender: new FormControl(null, Validators.required),
            work: new FormControl(null),
            university: new FormControl(null),
            interests,
            inclinations,
            cleaningPolicy : new FormControl(null),
            smokingPolicy : new FormControl(null),
            petPolicy : new FormControl(null),
            guestsPolicy : new FormControl(null)
        });
    }

    onAddInterest() {
        (this.form.get('interests') as FormArray).push(
            new FormControl(null, Validators.required)

        );
    }

    onAddInclination() {
        (this.form.get('inclinations') as FormArray).push(
            new FormControl(null, Validators.required)

        );
    }


    OnSelectFile(event) {
        if (event.target.files && event.target.files[0]) {
            if (event.target.files[0].type.match('image.*')) {
                this.profileImageFile = event.target.files[0];
                const reader = new FileReader();
                reader.onload = () => this.profileImg = reader.result.toString();
                reader.readAsDataURL(event.target.files[0]);
            } else {
                // show error message
            }
        }
    }

    onDeleteInterest(i: number) {
        (this.form.get('interests') as FormArray).removeAt(i);
    }

    onDeleteInclination(i: number) {
        (this.form.get('inclinations') as FormArray).removeAt(i);
    }

    onSubmit() {
        console.log(this.form);
        const profile: Profile = {
            firstName: this.form.get('firstName').value,
            lastName: this.form.get('lastName').value,
            profileImage: this.profileImg,
            birthDate: this.form.get('birthDate').value,
            description: this.form.get('description').value,
            gender: this.form.get('gender').value,
            work: this.form.get('work').value,
            university: this.form.get('university').value,
            interests: this.form.get('interests').value,
            inclinations: this.form.get('inclinations').value,
            cleaningPolicy: this.form.get('cleaningPolicy').value,
            smokingPolicy: this.form.get('smokingPolicy').value,
            petPolicy: this.form.get('petPolicy').value,
            guestsPolicy: this.form.get('guestsPolicy').value,
        };
        this.profileClient.saveProfile(profile);
    }
}