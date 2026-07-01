package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers$ShortArraySerializer extends Serializer<short[]> {
    public DefaultArraySerializers$ShortArraySerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ short[] copy(Kryo kryo, short[] sArr) {
        return copy2(kryo, sArr);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ short[] read(Kryo kryo, Input input, Class<short[]> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, short[] sArr) {
        write2(kryo, output, sArr);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public short[] copy2(Kryo kryo, short[] sArr) {
        int length = sArr.length;
        short[] sArr2 = new short[length];
        System.arraycopy(sArr, 0, sArr2, 0, length);
        return sArr2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public short[] read2(Kryo kryo, Input input, Class<short[]> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        return input.readShorts(varInt - 1);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, short[] sArr) {
        if (sArr == null) {
            output.writeVarInt(0, true);
        } else {
            output.writeVarInt(sArr.length + 1, true);
            output.writeShorts(sArr);
        }
    }
}
