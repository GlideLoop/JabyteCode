package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantInfoBase
import java.io.DataInputStream

class JabyteConstantInfoMethodHandle(stream: DataInputStream) : JabyteConstantInfoBase(stream) {
    val referenceKind = stream.read()
    val referenceIndex = stream.readShort()

    override fun getTag(): Int {
        return 15
    }
}