package stage2

fun main() {
    val input = readln().split(" ")
    val parkSlot = mutableListOf<Boolean>(true, false)

    when (input[0]) {
        "park" -> {
            if (!parkSlot[0]) {
                parkSlot[0] = true
                print("${input[2]} car parked in spot 1.")

            } else {
                if (!parkSlot[1]) {
                    parkSlot[1] = true
                    print("${input[2]} car parked in spot 2.")
                } else {

                }
            }
        }
        "leave" -> {
            when (input[1]) {
                "1" -> {
                    if (parkSlot[0]) {
                        parkSlot[0] = false
                        print("Spot 1 is free.")
                    } else {
                        print("There is no car in spot 1.")
                    }
                }
                "2" -> {
                    if (parkSlot[1]) {
                        parkSlot[1] = false
                        print("Spot 2 is free.")
                    } else {
                        print("There is no car in spot 2.")
                    }
                }
            }
        }
        else -> {
            print("")
        }
    }

    fun park(which: Int, color: String){
        parkSlot[which] = true
        print("${input[2]} car parked in spot ${which + 1}")
    }

    fun leave(which: Int, color: String) {
        parkSlot[which] = false
        print("Spot ${which + 1} is free")
    }
}
