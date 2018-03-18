import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DownloadComponent} from './pages/download/download.component';
import {DetailsComponent} from './pages/details/details.component';
import {UploadComponent} from './pages/upload/upload.component';
import {ReportComponent} from './pages/report/report.component';
import {RouterModule} from '@angular/router';
import {SharedModule} from '../shared/shared.module';
import {TrackerRouterModule} from './tracker.routing';
import {NewsComponent} from './pages/news/news.component';

@NgModule({
    imports: [
        TrackerRouterModule,
        CommonModule,
        SharedModule
    ],
    exports: [RouterModule],
    declarations: [
        DownloadComponent,
        DetailsComponent,
        UploadComponent,
        ReportComponent,
        NewsComponent
    ]
})
export class TrackerModule {
}
