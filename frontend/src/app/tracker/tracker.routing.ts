import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ReportComponent} from './pages/report/report.component';
import {UploadComponent} from './pages/upload/upload.component';
import {DownloadComponent} from './pages/download/download.component';
import {DetailsComponent} from './details/details.component';
import {NewsComponent} from './pages/news/news.component';

const routes: Routes = [
    {path: 'Download', component: DownloadComponent},
    {path: 'Report', component: ReportComponent},
    {path: 'Details', component: DetailsComponent},
    {path: 'News', component: NewsComponent},
    {path: 'Upload', component: UploadComponent},
    {path: '**', redirectTo: 'Search'}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
    declarations: []
})
export class TrackerRouterModule {
}
