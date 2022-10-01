package skywolf46.jabytecode.data

import skywolf46.jabytecode.data.constants.*
import skywolf46.jabytecode.exceptions.UnidentifiedConstantPoolInfoException
import java.io.DataInputStream

abstract class JabyteConstantInfoBase(
    @Suppress("UNUSED_PARAMETER") stream: DataInputStream
) {
    companion object {
        private val providers = mutableMapOf<Int, (DataInputStream) -> JabyteConstantInfoBase>()

        fun registerProvider(value: Int, provider: (DataInputStream) -> JabyteConstantInfoBase) {
            providers[value] = provider
        }

        fun parse(data: Int, stream: DataInputStream): JabyteConstantInfoBase {
            return providers[data]?.invoke(stream)
                ?: throw UnidentifiedConstantPoolInfoException("플래그 ${data}는 알려지지 않은 const pool 번호입니다.")
        }

        fun parse(stream: DataInputStream): JabyteConstantInfoBase {
            return parse(stream.read(), stream)
        }

        internal fun init() {
            registerProvider(7) {
                JabyteConstantClassInfo(it)
            }

            registerProvider(9) {
                JabyteConstantFieldReferenceInfo(it)
            }

            registerProvider(10) {
                JabyteConstantMethodReferenceInfo(it)
            }

            registerProvider(11) {
                JabyteConstantInterfaceMethodReferenceInfo(it)
            }

            registerProvider(8) {
                JabyteConstantStringInfo(it)
            }

            registerProvider(3) {
                JabyteConstantIntegerInfo(it)
            }

            registerProvider(4) {
                JabyteConstantFloatInfo(it)
            }

            registerProvider(5) {
                JabyteConstantLongInfo(it)
            }

            registerProvider(6) {
                JabyteConstantDoubleInfo(it)
            }

            registerProvider(12) {
                JabyteConstantNameAndTypeInfo(it)
            }

            registerProvider(1) {
                JabyteConstantInterfaceMethodReferenceInfo(it)
            }

            registerProvider(15) {
                JabyteConstantMethodHandleInfo(it)
            }

            registerProvider(16) {
                JabyteConstantMethodTypeInfo(it)
            }

            registerProvider(18) {
                JabyteConstantInvokeDynamicInfo(it)
            }
        }
    }

    abstract fun getTag(): Int
}