import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'byteformat'
})
export class ByteformatPipe implements PipeTransform {

  transform(value: number, args?: any): any {
        const i = Math.floor( Math.log(value) / Math.log(1024) );
        return ( value / Math.pow(1024, i) ).toFixed(2) + ' ' + ['B', 'kB', 'MB', 'GB', 'TB'][i];
  }

}
