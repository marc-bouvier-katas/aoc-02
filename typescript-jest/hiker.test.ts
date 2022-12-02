import {part1, part2} from './hiker'
import * as fs from 'fs';

describe('answer', () => {

    describe('Part 1', () => {
        it('sample ', function () {
            const testInput = readInput("input-sample.txt")
            expect(part1(testInput)).toBe(42)
        });

        // Remove .skip
        it.skip('real', function () {
            const testInput = readInput("input.txt")
            expect(part1(testInput)).toBe(1)
        });
    });

    //Remove .skip
    describe.skip('Part 2', () => {

        //Remove .skip
        it.skip('sample ', function () {
            const testInput = readInput("input-sample.txt")
            expect(part2(testInput)).toBe(1)
        });

        //Remove .skip
        it('real', function () {
            const testInput = readInput("input.txt")
            expect(part2(testInput)).toBe(1)
        });
    });

})


function readInput(fileName="input.txt"){
  return fs.readFileSync(fileName, 'utf8').split("\n");
}
