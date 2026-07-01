package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers$CharArraySerializer extends Serializer<char[]> {
    public DefaultArraySerializers$CharArraySerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ char[] copy(Kryo kryo, char[] cArr) {
        return copy2(kryo, cArr);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ char[] read(Kryo kryo, Input input, Class<char[]> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, char[] cArr) {
        write2(kryo, output, cArr);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public char[] copy2(Kryo kryo, char[] cArr) {
        int length = cArr.length;
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, 0, cArr2, 0, length);
        return cArr2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public char[] read2(Kryo kryo, Input input, Class<char[]> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        return input.readChars(varInt - 1);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, char[] cArr) {
        if (cArr == null) {
            output.writeVarInt(0, true);
        } else {
            output.writeVarInt(cArr.length + 1, true);
            output.writeChars(cArr);
        }
    }
}
