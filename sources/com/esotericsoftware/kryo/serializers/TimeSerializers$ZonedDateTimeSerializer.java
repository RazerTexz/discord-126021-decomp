package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.ZonedDateTime;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$ZonedDateTimeSerializer extends Serializer<ZonedDateTime> {
    private TimeSerializers$ZonedDateTimeSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ ZonedDateTime read(Kryo kryo, Input input, Class<ZonedDateTime> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, ZonedDateTime zonedDateTime) {
        write2(kryo, output, zonedDateTime);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public ZonedDateTime read2(Kryo kryo, Input input, Class<ZonedDateTime> cls) {
        return ZonedDateTime.of(TimeSerializers$LocalDateSerializer.read(input), TimeSerializers$LocalTimeSerializer.read(input), TimeSerializers$ZoneIdSerializer.read(input));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, ZonedDateTime zonedDateTime) {
        TimeSerializers$LocalDateSerializer.write(output, zonedDateTime.toLocalDate());
        TimeSerializers$LocalTimeSerializer.write(output, zonedDateTime.toLocalTime());
        TimeSerializers$ZoneIdSerializer.write(output, zonedDateTime.getZone());
    }

    public /* synthetic */ TimeSerializers$ZonedDateTimeSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }
}
