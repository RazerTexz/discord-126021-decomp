package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$DoubleSerializer extends Serializer<Double> {
    public DefaultSerializers$DoubleSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Double read(Kryo kryo, Input input, Class<Double> cls) {
        return read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Double d) {
        write2(kryo, output, d);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public Double read(Kryo kryo, Input input, Class<Double> cls) {
        return Double.valueOf(input.readDouble());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Double d) {
        output.writeDouble(d.doubleValue());
    }
}
