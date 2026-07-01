package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.OptionalLong;

/* JADX INFO: loaded from: classes.dex */
public class OptionalSerializers$OptionalLongSerializer extends Serializer<OptionalLong> {
    private OptionalSerializers$OptionalLongSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ OptionalLong read(Kryo kryo, Input input, Class<OptionalLong> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, OptionalLong optionalLong) {
        write2(kryo, output, optionalLong);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public OptionalLong read2(Kryo kryo, Input input, Class<OptionalLong> cls) {
        return input.readBoolean() ? OptionalLong.of(input.readLong()) : OptionalLong.empty();
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, OptionalLong optionalLong) {
        output.writeBoolean(optionalLong.isPresent());
        if (optionalLong.isPresent()) {
            output.writeLong(optionalLong.getAsLong());
        }
    }

    public /* synthetic */ OptionalSerializers$OptionalLongSerializer(OptionalSerializers$1 optionalSerializers$1) {
        this();
    }
}
