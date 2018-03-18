import { Injectable, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { LOGIN_DATA } from './login-mock';
import { TrackerUser } from '../domain';

const TRACKER_USER_KEY = 'TrackerUser';

@Injectable()
export class UserService {

    constructor(private router: Router) {
    }

    private currentUser: TrackerUser;
    /** User change event emitter */
    userChange: EventEmitter<TrackerUser> = new EventEmitter();

    private checkLocalUser(): void {
        if (this.currentUser == null) {
            const user = localStorage.getItem(TRACKER_USER_KEY);
            if (user) {
                this.currentUser = JSON.parse(user);
                this.userChange.emit(this.currentUser);
            }
        }
    }

    /** Checks for logged in user returns false if its not logged in */
    public isLoggedIn(): Observable<boolean> {
        this.checkLocalUser();
        return of(this.currentUser != null);
    }

    /** Returns the current user */
    public getUser(): TrackerUser {
        this.checkLocalUser();
        return this.currentUser;
    }

    /**
     * Tries to login into the backend
     * @param username Username
     * @param password Password
     */
    public login(username: string, password: string): Observable<TrackerUser | null> {
        const loginObserver = of(LOGIN_DATA);
        loginObserver.subscribe((loginData) => {
            if (loginData != null) {
                localStorage.setItem(TRACKER_USER_KEY, JSON.stringify(loginData));
                this.currentUser = loginData;
                this.router.navigate(['News']);
                this.userChange.emit(loginData);
            }
        });

        return loginObserver;
    }

    /**
     * This method tries to register a new user in the backend
     *
     * @param username Username for registration
     * @param email Email address
     * @param password Password
     */
    public register(username: string, email: string, password: string): Observable<{ success: boolean, reason?: string }> {
        return of({ success: false, reason: 'This method is not implemented yet' }); // TODO: implement
    }
}
