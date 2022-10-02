package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantInfoBase
import java.io.DataInputStream

class JabyteConstantInfoInteger(stream: DataInputStream) : JabyteConstantInfoBase(stream){
    // ¯\_(ツ)_/¯
    private val data = stream.readInt()

    override fun getTag(): Int {
        return 3
    }
}