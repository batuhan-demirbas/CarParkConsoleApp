package stage5

var endless = true
var parkSlot = MutableList(0) { "0" }
// TODO Park alanı oluşturma kontrolünü tek bir yerden olacak şekilde düzenle

fun park(licencePlate: String, carColor: String) {
    if (parkSlot.size == 0) {
        println("Sorry, a parking lot has not been created.")
    } else {
        for (i in 0..parkSlot.lastIndex) {
            if (parkSlot[i] == "0") {
                parkSlot[i] = "$licencePlate ${carColor.lowercase()}"
                println("$carColor car parked in spot ${i + 1}.")
                break
            } else if (parkSlot[parkSlot.lastIndex] != "0") {
                println("Sorry, the parking lot is full.")
                break
            }
        }
    }
}

fun leave(spotNumber: Int) {
    if (parkSlot.size == 0) {
        println("Sorry, a parking lot has not been created.")
    } else {
        if (parkSlot[spotNumber - 1] != "0") {
            parkSlot[spotNumber - 1] = "0 0"
            println("Spot $spotNumber is free.")
        } else {
            println("There is no car in spot 1.")
        }
    }
}

fun create(parkSlotNumber: Int) {
    parkSlot = MutableList(parkSlotNumber) { "0" }
    println("Created a parking lot with $parkSlotNumber spots.")
}

fun status() {
    if (parkSlot.size == 0) {
        println("Sorry, a parking lot has not been created.")
    } else {
        for (i in 0..parkSlot.lastIndex) {
            if (parkSlot[i] != "0") {
                println("${i + 1} ${parkSlot[i]}")
            }
        }

        if (parkSlot.all { parkSlot[0] == "0" }) {
            println("Parking lot is empty.")
        }
    }

}

fun spot_by_color(color: String) {
    if (parkSlot.size == 0) {
        println("Sorry, a parking lot has not been created.")
    } else {
        val colorList = mutableListOf<String>()
        for (i in 0..parkSlot.lastIndex) {
            val thisSlot = parkSlot[i].split(" ")
            if (thisSlot[1] == color.lowercase()) {
                colorList.add((i + 1).toString())
            }
        }

        if (colorList.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(colorList.joinToString(", "))
        }
    }
}

fun spot_by_reg(licencePlate: String) {
    if (parkSlot.size == 0) {
        println("Sorry, a parking lot has not been created.")
    } else {
        var flag = 0
        for (i in 0..parkSlot.lastIndex) {
            val thisSlot = parkSlot[i].split(" ")
            if (thisSlot[0] == licencePlate) {
                println(i + 1)
                flag++
            }
        }

        if (flag == 0) {
            println("No cars with registration number $licencePlate were found.")
        }
    }
}
fun reg_by_color(color: String) {
    if (parkSlot.size == 0) {
        println("Sorry, a parking lot has not been created.")
    } else {
        val licencePlateList = mutableListOf<String>()
        for (i in 0..parkSlot.lastIndex) {
            val thisSlot = parkSlot[i].split(" ")
            if (thisSlot[1] == color.lowercase()) {
                licencePlateList.add(thisSlot[0])
            }
        }

        if (licencePlateList.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(licencePlateList.joinToString(", "))
        }
    }
}

fun exit() {
    endless = false
}

fun startPark() {

    while (endless) {
        val userInput = readln().split(" ")

        when (userInput[0]) {
            "create" -> create(userInput[1].toInt())
            "status" -> status()
            "park" -> park(userInput[1], userInput[2])
            "leave" -> leave(userInput[1].toInt())
            "spot_by_reg" -> spot_by_reg(userInput[1])
            "spot_by_color" -> spot_by_color(userInput[1])
            "reg_by_color" -> reg_by_color(userInput[1])
            "exit" -> exit()
        }
    }
}

fun main() {
    startPark()
}