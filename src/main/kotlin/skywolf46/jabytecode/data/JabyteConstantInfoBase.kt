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
                JabyteConstantInfoClass(it)
            }

            registerProvider(9) {
                JabyteConstantInfoFieldReference(it)
            }

            registerProvider(10) {
                JabyteConstantInfoMethodReference(it)
            }

            registerProvider(11) {
                JabyteConstantInfoInterfaceMethodReference(it)
            }

            registerProvider(8) {
                JabyteConstantInfoString(it)
            }

            registerProvider(3) {
                JabyteConstantInfoInteger(it)
            }

            registerProvider(4) {
                JabyteConstantInfoFloat(it)
            }

            registerProvider(5) {
                JabyteConstantInfoLong(it)
            }

            registerProvider(6) {
                JabyteConstantInfoDouble(it)
            }

            registerProvider(12) {
                JabyteConstantInfoNameAndType(it)
            }

            registerProvider(1) {
                JabyteConstantInfoInterfaceMethodReference(it)
            }

            registerProvider(15) {
                JabyteConstantInfoMethodHandle(it)
            }

            registerProvider(16) {
                JabyteConstantInfoMethodType(it)
            }

            registerProvider(18) {
                JabyteConstantInfoInvokeDynamic(it)
            }
        }
    }

    abstract fun getTag(): Int
}