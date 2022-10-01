package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantInfoBase
import java.io.DataInputStream

class JabyteConstantInvokeDynamicInfo(stream: DataInputStream) : JabyteConstantInfoBase(stream) {
    val bootstrapMethodAttributeIndex = stream.readShort()
    val nameAndTypeIndex = stream.readShort()

    override fun getTag(): Int {
        return 18
    }

}