package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$IntSerializer extends Serializer<Integer> {
    public DefaultSerializers$IntSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Integer read(Kryo kryo, Input input, Class<Integer> cls) {
        return read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Integer num) {
        write2(kryo, output, num);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public Integer read(Kryo kryo, Input input, Class<Integer> cls) {
        return Integer.valueOf(input.readInt(false));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Integer num) {
        output.writeInt(num.intValue(), false);
    }
}
