package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.LocalDateTime;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$LocalDateTimeSerializer extends Serializer<LocalDateTime> {
    private TimeSerializers$LocalDateTimeSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ LocalDateTime read(Kryo kryo, Input input, Class<LocalDateTime> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, LocalDateTime localDateTime) {
        write2(kryo, output, localDateTime);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public LocalDateTime read2(Kryo kryo, Input input, Class<LocalDateTime> cls) {
        return LocalDateTime.of(TimeSerializers$LocalDateSerializer.read(input), TimeSerializers$LocalTimeSerializer.read(input));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, LocalDateTime localDateTime) {
        TimeSerializers$LocalDateSerializer.write(output, localDateTime.toLocalDate());
        TimeSerializers$LocalTimeSerializer.write(output, localDateTime.toLocalTime());
    }

    public /* synthetic */ TimeSerializers$LocalDateTimeSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }
}
