package skywolf46.jabytecode.data

import java.io.DataInputStream

class JabyteConstantPoolData(stream: DataInputStream) : MutableList<JabyteConstantInfoBase> by ArrayList() {
    init {
        for (x in 0 until stream.readShort().toInt()) {
            add(JabyteConstantInfoBase.parse(stream))
        }
    }
}