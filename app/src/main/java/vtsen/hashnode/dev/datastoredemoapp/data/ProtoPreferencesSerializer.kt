package vtsen.hashnode.dev.datastoredemoapp.data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import vtsen.hashnode.dev.datastoredemoapp.ProtoPreferences
import java.io.InputStream
import java.io.OutputStream

/**
 * Serializer for the [ProtoPreferences] object defined in ProtoPreferences.proto.
 */
object ProtoPreferencesSerializer : Serializer<ProtoPreferences> {
    override val defaultValue: ProtoPreferences
        = ProtoPreferences.getDefaultInstance()

    override suspend fun readFrom(
        input: InputStream
    ): ProtoPreferences {
        try {
            return ProtoPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: ProtoPreferences,
        output: OutputStream) = t.writeTo(output)
}
