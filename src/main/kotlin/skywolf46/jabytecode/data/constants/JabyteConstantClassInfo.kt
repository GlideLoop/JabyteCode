package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantInfoBase
import java.io.DataInputStream

// CONSTANT_FieldRef
class JabyteConstantClassInfo(stream: DataInputStream) : JabyteConstantInfoBase(stream) {
    private val nameIndex = stream.readShort()

    override fun getTag(): Int {
        return 7
    }
}