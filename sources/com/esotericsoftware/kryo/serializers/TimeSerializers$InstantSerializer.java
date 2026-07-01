package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.Instant;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$InstantSerializer extends Serializer<Instant> {
    private TimeSerializers$InstantSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Instant read(Kryo kryo, Input input, Class<Instant> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Instant instant) {
        write2(kryo, output, instant);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Instant read2(Kryo kryo, Input input, Class<Instant> cls) {
        return Instant.ofEpochSecond(input.readLong(true), input.readInt(true));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Instant instant) {
        output.writeLong(instant.getEpochSecond(), true);
        output.writeInt(instant.getNano(), true);
    }

    public /* synthetic */ TimeSerializers$InstantSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }
}
