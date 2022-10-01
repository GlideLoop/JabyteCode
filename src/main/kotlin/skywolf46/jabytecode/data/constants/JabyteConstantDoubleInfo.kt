package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantInfoBase
import java.io.DataInputStream


class JabyteConstantDoubleInfo(stream: DataInputStream) : JabyteConstantInfoBase(stream) {
    val highBytes = stream.readInt()

    val lowBytes = stream.readInt()

    val evaluatedValue: Double by lazy { evaluate() }

    override fun getTag(): Int {
        return 6
    }

    private fun evaluate(): Double {
        val bits = ((highBytes shl 32) + lowBytes).toLong()
        val s = if (((bits shr 63) == 0L)) 1 else -1
        val e = ((bits shr 52) and 0x7ffL).toInt()
        return java.lang.Double.longBitsToDouble(
            (if (e == 0)
                (bits and 0xfffffffffffffL) shl 1
            else
                (bits and 0xfffffffffffffL) or 0x10000000000000L) * s
        )
    }

}