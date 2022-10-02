package skywolf46.jabytecode.data.constants

import skywolf46.jabytecode.data.JabyteConstantReferenceInfoBase
import java.io.DataInputStream

// CONSTANT_FieldRef
// The class_index item of a CONSTANT_Fieldref_info structure may be either a class type or an interface type.
class JabyteConstantInfoFieldReference(stream: DataInputStream) : JabyteConstantReferenceInfoBase(stream) {
    override fun getTag(): Int {
        return 9
    }
}