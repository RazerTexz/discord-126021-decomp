package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers$IntArraySerializer extends Serializer<int[]> {
    public DefaultArraySerializers$IntArraySerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ int[] copy(Kryo kryo, int[] iArr) {
        return copy2(kryo, iArr);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ int[] read(Kryo kryo, Input input, Class<int[]> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, int[] iArr) {
        write2(kryo, output, iArr);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public int[] copy2(Kryo kryo, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public int[] read2(Kryo kryo, Input input, Class<int[]> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        return input.readInts(varInt - 1, false);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, int[] iArr) {
        if (iArr == null) {
            output.writeVarInt(0, true);
        } else {
            output.writeVarInt(iArr.length + 1, true);
            output.writeInts(iArr, false);
        }
    }
}
