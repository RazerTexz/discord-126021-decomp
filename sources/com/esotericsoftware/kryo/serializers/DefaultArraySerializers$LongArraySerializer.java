package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers$LongArraySerializer extends Serializer<long[]> {
    public DefaultArraySerializers$LongArraySerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ long[] copy(Kryo kryo, long[] jArr) {
        return copy2(kryo, jArr);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ long[] read(Kryo kryo, Input input, Class<long[]> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, long[] jArr) {
        write2(kryo, output, jArr);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public long[] copy2(Kryo kryo, long[] jArr) {
        int length = jArr.length;
        long[] jArr2 = new long[length];
        System.arraycopy(jArr, 0, jArr2, 0, length);
        return jArr2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public long[] read2(Kryo kryo, Input input, Class<long[]> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        return input.readLongs(varInt - 1, false);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, long[] jArr) {
        if (jArr == null) {
            output.writeVarInt(0, true);
        } else {
            output.writeVarInt(jArr.length + 1, true);
            output.writeLongs(jArr, false);
        }
    }
}
