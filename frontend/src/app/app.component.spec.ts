import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import {
    RouterTestingModule
} from '@angular/router/testing';
import { SharedModule } from './shared/shared.module';

describe('AppComponent', () => {
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                AppComponent,
                MenuComponent
            ],
            imports: [RouterTestingModule, SharedModule]
        }).compileComponents();
    }));
    it('should create the app', async(() => {
        const fixture = TestBed.createComponent(AppComponent);
        const app = fixture.debugElement.componentInstance;
        expect(app).toBeTruthy();
    }));
    it(`should have as title 'app'`, async(() => {
        const fixture = TestBed.createComponent(AppComponent);
        const app = fixture.debugElement.componentInstance;
        expect(app.title).toEqual('app');
    }));
});
