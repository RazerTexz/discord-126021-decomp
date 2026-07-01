package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers$ByteArraySerializer extends Serializer<byte[]> {
    public DefaultArraySerializers$ByteArraySerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ byte[] copy(Kryo kryo, byte[] bArr) {
        return copy2(kryo, bArr);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ byte[] read(Kryo kryo, Input input, Class<byte[]> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, byte[] bArr) {
        write2(kryo, output, bArr);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public byte[] copy2(Kryo kryo, byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public byte[] read2(Kryo kryo, Input input, Class<byte[]> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        return input.readBytes(varInt - 1);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, byte[] bArr) {
        if (bArr == null) {
            output.writeVarInt(0, true);
        } else {
            output.writeVarInt(bArr.length + 1, true);
            output.writeBytes(bArr);
        }
    }
}
