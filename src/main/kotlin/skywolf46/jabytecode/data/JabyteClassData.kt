package skywolf46.jabytecode.data

import skywolf46.jabytecode.exceptions.UnidentifiedJavaFileException
import java.io.DataInputStream

const val JAVA_MAGIC_CODE = 0xCAFEBABE.toInt()
class JabyteClassData(stream: DataInputStream, ignoreMagicCode: Boolean = false) {
    init {
        if (!ignoreMagicCode && stream.readInt() != JAVA_MAGIC_CODE)
            throw UnidentifiedJavaFileException("Cannot parse file : Class file magic code not matched")

    }
    val metaData = JabyteVersionInfo(stream)

    val constantPool = JabyteConstantPoolInfo(stream)
}