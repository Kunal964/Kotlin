fun main() {
    // Creating the object of SmartTvDevice
    val tv = SmartTvDevice("AndroidTV", "SmartTV")

    // Set the value of speaker and channel
    tv.speakerVolume = 90
    tv.channelNumber = 40

    // Get the value of speaker and channel
    println("Before increment volume of the speaker: " + tv.speakerVolume)
    println("Before increment channel number: " + tv.channelNumber)
    println("After Increment")
    tv.increaseSpeakerVolume()
    tv.nextChannel()
    tv.turnOn()
    tv.turnOff()

    // Creating the object of SmartLightDevice
    val light = SmartLightDevice("PhilipsHue", "Light")
    light.increaseBrightness()
    light.turnOn()
    light.turnOff()

    // Creating the object of SmartHome
    val home = SmartHome(tv) // passing the smart tv instance to the smarthome
    home.turnOnTv()
    home.turnOffTv()
}
// Showing the inheritance
open class SmartDevice(val name: String, val category: String) {
    var deviceStatus = "offline"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"

    }
}
// class SmartTvDevice Inherit from SmartDevice
class SmartTvDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    var speakerVolume = 2
        // Demonstrate the concept of Getter and Setter
        get() = field
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    var channelNumber = 1
        // Demonstrate the concept of Getter and Setter
        get() = field
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber.")
    }

    override fun turnOff() {
        super.turnOff()
        println("$name is turned off.")
    }
}

// class SmartLightDevice Inherit from SmartDevice
class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    var brightnessLevel = 0
        // Demonstrate the concept of Getter and Setter
        get() = field
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        // Demonstrate the concept of Super Keyword
        super.turnOn()
        brightnessLevel = 2
        println("$name is turned on. The brightness level is set to $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$name is turned off.")
    }
}
// Building a HAS-A relationship
class SmartHome(val tv: SmartTvDevice) {
    fun turnOnTv() {
        println("Turning on TV...")
        tv.turnOn()
    }

    fun turnOffTv() {
        println("Turning off TV...")
        tv.turnOff()
    }
}
