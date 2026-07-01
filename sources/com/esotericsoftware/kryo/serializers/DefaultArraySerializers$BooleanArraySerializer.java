package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers$BooleanArraySerializer extends Serializer<boolean[]> {
    public DefaultArraySerializers$BooleanArraySerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ boolean[] copy(Kryo kryo, boolean[] zArr) {
        return copy2(kryo, zArr);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ boolean[] read(Kryo kryo, Input input, Class<boolean[]> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, boolean[] zArr) {
        write2(kryo, output, zArr);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public boolean[] copy2(Kryo kryo, boolean[] zArr) {
        int length = zArr.length;
        boolean[] zArr2 = new boolean[length];
        System.arraycopy(zArr, 0, zArr2, 0, length);
        return zArr2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public boolean[] read2(Kryo kryo, Input input, Class<boolean[]> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        int i = varInt - 1;
        boolean[] zArr = new boolean[i];
        for (int i2 = 0; i2 < i; i2++) {
            zArr[i2] = input.readBoolean();
        }
        return zArr;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, boolean[] zArr) {
        if (zArr == null) {
            output.writeVarInt(0, true);
            return;
        }
        output.writeVarInt(zArr.length + 1, true);
        for (boolean z2 : zArr) {
            output.writeBoolean(z2);
        }
    }
}
