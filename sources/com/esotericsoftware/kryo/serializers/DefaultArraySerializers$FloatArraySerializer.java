package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers$FloatArraySerializer extends Serializer<float[]> {
    public DefaultArraySerializers$FloatArraySerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ float[] copy(Kryo kryo, float[] fArr) {
        return copy2(kryo, fArr);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ float[] read(Kryo kryo, Input input, Class<float[]> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, float[] fArr) {
        write2(kryo, output, fArr);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public float[] copy2(Kryo kryo, float[] fArr) {
        int length = fArr.length;
        float[] fArr2 = new float[length];
        System.arraycopy(fArr, 0, fArr2, 0, length);
        return fArr2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public float[] read2(Kryo kryo, Input input, Class<float[]> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        return input.readFloats(varInt - 1);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, float[] fArr) {
        if (fArr == null) {
            output.writeVarInt(0, true);
        } else {
            output.writeVarInt(fArr.length + 1, true);
            output.writeFloats(fArr);
        }
    }
}
