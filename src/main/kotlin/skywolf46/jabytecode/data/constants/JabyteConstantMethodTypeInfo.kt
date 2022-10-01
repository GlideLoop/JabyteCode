package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantInfoBase
import java.io.DataInputStream

class JabyteConstantMethodTypeInfo(stream: DataInputStream) : JabyteConstantInfoBase(stream) {
    val descriptorIndex = stream.readShort()
    override fun getTag(): Int {
        return 16
    }

}