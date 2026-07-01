package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers$DoubleArraySerializer extends Serializer<double[]> {
    public DefaultArraySerializers$DoubleArraySerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ double[] copy(Kryo kryo, double[] dArr) {
        return copy2(kryo, dArr);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ double[] read(Kryo kryo, Input input, Class<double[]> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, double[] dArr) {
        write2(kryo, output, dArr);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public double[] copy2(Kryo kryo, double[] dArr) {
        int length = dArr.length;
        double[] dArr2 = new double[length];
        System.arraycopy(dArr, 0, dArr2, 0, length);
        return dArr2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public double[] read2(Kryo kryo, Input input, Class<double[]> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        return input.readDoubles(varInt - 1);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, double[] dArr) {
        if (dArr == null) {
            output.writeVarInt(0, true);
        } else {
            output.writeVarInt(dArr.length + 1, true);
            output.writeDoubles(dArr);
        }
    }
}
