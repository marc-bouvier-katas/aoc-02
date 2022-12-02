    package hiker
    import io.kotlintest.specs.StringSpec
    import io.kotlintest.shouldBe
    import io.kotlintest.shouldNotBe
    import hiker.readInput as readInput

    class HikerTest : StringSpec() {

        init {
            "Part 1 sample" {

                val testInput = readInput("input-sample")
                hiker.part1(testInput) shouldBe 41
            }

            "Part 1 result" {
                val testInput = readInput("input")
                hiker.part1(testInput) shouldBe 42
            }

            "Part 2 sample" {
                val testInput = readInput("input-sample")
                hiker.part2(testInput) shouldBe 42
            }

            "Part 2 result" {
                val testInput = readInput("input")
                hiker.part2(testInput) shouldBe 42
            }


        }
    }