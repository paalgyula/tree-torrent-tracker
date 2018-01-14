import { ByteformatPipe } from './byteformat.pipe';

describe('ByteformatPipe', () => {
    it('create an instance', () => {
        const pipe = new ByteformatPipe();
        expect(pipe).toBeTruthy();
    });

    it('Test with some megabytes', () => {
        const pipe = new ByteformatPipe();
        const ret = pipe.transform(51251612412);
        expect(ret).toBe('47.73 GB');
    });
});
