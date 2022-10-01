package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantInfoBase
import java.io.DataInputStream

class JabyteConstantNameAndTypeInfo(stream: DataInputStream) : JabyteConstantInfoBase(stream) {
    private val nameIndex = stream.readShort()

    private val descriptorIndex = stream.readShort()

    override fun getTag(): Int {
        return 12
    }
}