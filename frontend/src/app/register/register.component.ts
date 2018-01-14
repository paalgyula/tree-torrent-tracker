import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl, ValidationErrors, FormControl } from '@angular/forms';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit {

    public registerForm: FormGroup;

    constructor(fb: FormBuilder) {
        this.registerForm = fb.group({
            username: ['', [
                RegisterFormValidation.allowedCharactersInUsername,
                Validators.minLength(5),
                Validators.maxLength(14),
                Validators.required
            ]],
            password: ['', [Validators.required, Validators.minLength(6)]],
            passwordAgain: ['', Validators.required],
            email: ['', [Validators.required, Validators.email]],
            emailAgain: ['', Validators.required],
            gender: ['Male', Validators.required],
            past15: [false, Validators.requiredTrue],
            acceptTerms: [false, Validators.requiredTrue]
        }, {
                validator: RegisterFormValidation.MatchPasswordAndEmail
            });
    }

    ngOnInit() {
    }

    onSubmit(): void {
        if (this.registerForm.valid) {
            console.log(this.registerForm.value);
        }
    }
}

class RegisterFormValidation {
    static allowedCharactersInUsername(control: FormControl) {
        const pattern = /^[0-9a-zA-Z_\-\.]*$/g;
        const username = control.value;

        return pattern.test(control.value) ? null : {
            NotAllowedCharacters: {
                valid: false
            }
        };
    }

    static MatchPasswordAndEmail(control: AbstractControl): ValidationErrors | null {
        const password = control.get('password').value; // to get value in input tag
        const confirmPassword = control.get('passwordAgain').value; // to get value in input tag

        const email = control.get('email').value; // to get value in input tag
        const emailAgain = control.get('emailAgain').value; // to get value in input tag

        if (password !== confirmPassword) {
            control.get('passwordAgain').setErrors({ MatchPassword: true });
        }

        if (email !== emailAgain) {
            control.get('emailAgain').setErrors({ MatchEmail: true });
        } else {
            return null;
        }
    }
}
