import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchComponent } from './search/search.component';
import { DetailsComponent } from './details/details.component';
import { UploadComponent } from './upload/upload.component';
import { ReportComponent } from './report/report.component';
import { RouterModule, Routes } from '@angular/router';
import { LoginGuard } from '../login.guard';
import { SharedModule } from '../shared/shared.module';
import { ByteformatPipe } from '../shared/pipes/byteformat.pipe';

const routes: Routes = [
    { path: 'Search', component: SearchComponent, canActivate: [LoginGuard] },
    { path: 'Report', component: ReportComponent },
    { path: 'Details', component: DetailsComponent },
    { path: 'Upload', component: UploadComponent, canActivate: [LoginGuard] },
    { path: '**', redirectTo: 'Search' }
];

@NgModule({
    imports: [
        RouterModule.forChild(routes),
        CommonModule,
        SharedModule
    ],
    exports: [RouterModule],
    declarations: [
        SearchComponent,
        DetailsComponent,
        UploadComponent,
        ReportComponent
    ]
})
export class TorrentModule { }
