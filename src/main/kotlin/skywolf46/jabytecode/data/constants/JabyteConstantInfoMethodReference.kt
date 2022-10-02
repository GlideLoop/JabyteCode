package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantReferenceInfoBase
import java.io.DataInputStream

// CONSTANT_MethodRef
// The class_index item of a CONSTANT_InterfaceMethodref_info structure must be an interface type.
class JabyteConstantInfoMethodReference(stream: DataInputStream) : JabyteConstantReferenceInfoBase(stream) {
    override fun getTag(): Int {
        return 10
    }
}