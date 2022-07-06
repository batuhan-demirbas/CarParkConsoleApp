package stage3

fun main() {
    val parkSlot = MutableList(20) { 0 }
    var endless = true

    while (endless) {
        val input = readln().split(" ")

        when (input[0]) {
            "park" -> {
                for (i in 0..parkSlot.lastIndex) {
                    if (parkSlot[i] == 0) {
                        parkSlot[i] = 1
                        println("${input[2]} car parked in spot ${i + 1}.")
                        break
                    } else if (parkSlot[19] == 1) {
                        println("Sorry, the parking lot is full.")
                        break
                    }
                }
            }
            "leave" -> {

                if (parkSlot[input[1].toInt() - 1] == 1) {
                    parkSlot[input[1].toInt() - 1] = 0
                    println("Spot ${input[1]} is free.")
                } else {
                    println("There is no car in spot 1.")
                }
            }
            "exit" -> {
                endless = false
            }
        }
    }
}