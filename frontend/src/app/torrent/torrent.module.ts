import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchComponent } from './search/search.component';
import { DetailsComponent } from './details/details.component';
import { UploadComponent } from './upload/upload.component';
import { ReportComponent } from './report/report.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [SearchComponent, DetailsComponent, UploadComponent, ReportComponent]
})
export class TorrentModule { }
