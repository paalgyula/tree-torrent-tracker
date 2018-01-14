import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ByteformatPipe } from './pipes/byteformat.pipe';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [ByteformatPipe],
  exports: [ByteformatPipe]
})
export class SharedModule { }
