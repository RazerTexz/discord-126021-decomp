package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.OffsetTime;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$OffsetTimeSerializer extends Serializer<OffsetTime> {
    private TimeSerializers$OffsetTimeSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ OffsetTime read(Kryo kryo, Input input, Class<OffsetTime> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, OffsetTime offsetTime) {
        write2(kryo, output, offsetTime);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public OffsetTime read2(Kryo kryo, Input input, Class<OffsetTime> cls) {
        return OffsetTime.of(TimeSerializers$LocalTimeSerializer.read(input), TimeSerializers$ZoneOffsetSerializer.read(input));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, OffsetTime offsetTime) {
        TimeSerializers$LocalTimeSerializer.write(output, offsetTime.toLocalTime());
        TimeSerializers$ZoneOffsetSerializer.write(output, offsetTime.getOffset());
    }

    public /* synthetic */ TimeSerializers$OffsetTimeSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }
}
