package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.OffsetDateTime;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$OffsetDateTimeSerializer extends Serializer<OffsetDateTime> {
    private TimeSerializers$OffsetDateTimeSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ OffsetDateTime read(Kryo kryo, Input input, Class<OffsetDateTime> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, OffsetDateTime offsetDateTime) {
        write2(kryo, output, offsetDateTime);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public OffsetDateTime read2(Kryo kryo, Input input, Class<OffsetDateTime> cls) {
        return OffsetDateTime.of(TimeSerializers$LocalDateSerializer.read(input), TimeSerializers$LocalTimeSerializer.read(input), TimeSerializers$ZoneOffsetSerializer.read(input));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, OffsetDateTime offsetDateTime) {
        TimeSerializers$LocalDateSerializer.write(output, offsetDateTime.toLocalDate());
        TimeSerializers$LocalTimeSerializer.write(output, offsetDateTime.toLocalTime());
        TimeSerializers$ZoneOffsetSerializer.write(output, offsetDateTime.getOffset());
    }

    public /* synthetic */ TimeSerializers$OffsetDateTimeSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }
}
