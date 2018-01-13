import { Injectable, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { TrackerUser } from '../domain/tracker-user';
import { LOGIN_DATA } from './login-mock';
import { of } from 'rxjs/observable/of';
import { RouterStateSnapshot, Router } from '@angular/router';

@Injectable()
export class LoginService {
    constructor(private router: Router) {
    }

    private currentUser: TrackerUser;
    userChange: EventEmitter<TrackerUser> = new EventEmitter();

    public isLoggedIn(): Observable<boolean> {
        return of(this.currentUser != null);
    }

    public getUser(): TrackerUser {
        return this.currentUser;
    }

    public login(username: string, password: string): Observable<TrackerUser | null> {
        const loginObserver = of(LOGIN_DATA);
        loginObserver.subscribe((loginData) => {
            if (loginData != null) {
                this.currentUser = loginData;
                this.router.navigate(['News']);
                this.userChange.emit(loginData);
            }
        });

        return loginObserver;
    }
}
