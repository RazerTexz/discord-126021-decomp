package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.Duration;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$DurationSerializer extends Serializer<Duration> {
    private TimeSerializers$DurationSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Duration read(Kryo kryo, Input input, Class<Duration> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Duration duration) {
        write2(kryo, output, duration);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Duration read2(Kryo kryo, Input input, Class<Duration> cls) {
        return Duration.ofSeconds(input.readLong(), input.readInt(true));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Duration duration) {
        output.writeLong(duration.getSeconds());
        output.writeInt(duration.getNano(), true);
    }

    public /* synthetic */ TimeSerializers$DurationSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }
}
