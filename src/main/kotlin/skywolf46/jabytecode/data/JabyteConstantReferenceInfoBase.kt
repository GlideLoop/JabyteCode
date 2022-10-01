package skywolf46.jabytecode.data

import java.io.DataInputStream

abstract class JabyteConstantReferenceInfoBase(stream: DataInputStream) : JabyteConstantInfoBase(stream) {
    val classIndex = stream.readShort()
    val nameAndTypeIndex = stream.readShort()
}