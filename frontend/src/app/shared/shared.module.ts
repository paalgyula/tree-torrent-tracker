import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ByteformatPipe } from './pipes/byteformat.pipe';
import { TorrentsService } from './services/torrents.service';
import { UserService } from './services/user.service';

@NgModule({
  imports: [
    CommonModule
  ],
  providers: [TorrentsService, UserService],
  declarations: [ByteformatPipe],
  exports: [ByteformatPipe]
})
export class SharedModule { }
