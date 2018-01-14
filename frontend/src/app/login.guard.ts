import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanLoad } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { UserService } from './shared';

@Injectable()
export class LoginGuard implements CanActivate, CanLoad {
    constructor(private userService: UserService) {
    }

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        return this.userService.isLoggedIn();
    }

    canLoad() {
        return this.userService.isLoggedIn();
    }
}
