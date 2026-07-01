package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.OptionalDouble;

/* JADX INFO: loaded from: classes.dex */
public class OptionalSerializers$OptionalDoubleSerializer extends Serializer<OptionalDouble> {
    private OptionalSerializers$OptionalDoubleSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ OptionalDouble read(Kryo kryo, Input input, Class<OptionalDouble> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, OptionalDouble optionalDouble) {
        write2(kryo, output, optionalDouble);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public OptionalDouble read2(Kryo kryo, Input input, Class<OptionalDouble> cls) {
        return input.readBoolean() ? OptionalDouble.of(input.readDouble()) : OptionalDouble.empty();
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, OptionalDouble optionalDouble) {
        output.writeBoolean(optionalDouble.isPresent());
        if (optionalDouble.isPresent()) {
            output.writeDouble(optionalDouble.getAsDouble());
        }
    }

    public /* synthetic */ OptionalSerializers$OptionalDoubleSerializer(OptionalSerializers$1 optionalSerializers$1) {
        this();
    }
}
