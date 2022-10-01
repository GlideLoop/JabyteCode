package skywolf46.jabytecode.data

import java.io.ByteArrayInputStream
import java.io.DataInputStream

class JabyteVersionInfo(stream: DataInputStream) {
    val majorVersion = stream.readShort()
    val minorVersion = stream.readShort()
}