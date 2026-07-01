package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.OptionalInt;

/* JADX INFO: loaded from: classes.dex */
public class OptionalSerializers$OptionalIntSerializer extends Serializer<OptionalInt> {
    private OptionalSerializers$OptionalIntSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ OptionalInt read(Kryo kryo, Input input, Class<OptionalInt> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, OptionalInt optionalInt) {
        write2(kryo, output, optionalInt);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public OptionalInt read2(Kryo kryo, Input input, Class<OptionalInt> cls) {
        return input.readBoolean() ? OptionalInt.of(input.readInt()) : OptionalInt.empty();
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, OptionalInt optionalInt) {
        output.writeBoolean(optionalInt.isPresent());
        if (optionalInt.isPresent()) {
            output.writeInt(optionalInt.getAsInt());
        }
    }

    public /* synthetic */ OptionalSerializers$OptionalIntSerializer(OptionalSerializers$1 optionalSerializers$1) {
        this();
    }
}
