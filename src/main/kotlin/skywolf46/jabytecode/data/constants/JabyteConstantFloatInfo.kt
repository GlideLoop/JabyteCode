package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantInfoBase
import java.io.DataInputStream

class JabyteConstantFloatInfo(stream: DataInputStream) : JabyteConstantInfoBase(stream){
    // ¯\_(ツ)_/¯
    private val data = stream.readFloat()

    override fun getTag(): Int {
        return 4
    }
}