<?php

require_once 'Day01.php';

use PHPUnit\Framework\TestCase;

class Day01Test extends TestCase
{

    public function testPart_01_sample()
    {
        $highiestTotalCaloriesCarriedByOneElve = partOne(getInput("input-sample.txt"));

        $this->assertEquals(24000, $highiestTotalCaloriesCarriedByOneElve);
    }

    public function testPart_01()
    {
        $result = partOne(getInput("input.txt"));

        $this->assertEquals($result, 42);
    }

    public function testPart_02_sample()
    {
        $result = partOne(getInput("input-sample.txt"));

        $this->assertEquals($result, 42);
    }

    public function testPart_02()
    {
        $partTwo = partTwo(getInput("input.txt"));

        $this->assertEquals(207576, $partTwo);
    }

}

function getInput($fileName = "input.txt")
{
    return explode(
        "\n",
        trim(file_get_contents($fileName,
            true)));
}

?>