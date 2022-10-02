package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantInfoBase
import java.io.DataInputStream

class JabyteConstantInfoUtf8(stream: DataInputStream) : JabyteConstantInfoBase(stream) {
    val length = stream.readShort()
    val data = ByteArray(length.toInt()).apply {
        stream.read(this)
    }

    override fun getTag(): Int {
        return 1
    }

}