package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantInfoBase
import java.io.DataInputStream

class JabyteConstantInfoString(stream: DataInputStream) : JabyteConstantInfoBase(stream) {
    val stringIndex = stream.readShort()

    override fun getTag(): Int {
        return 8
    }
}