package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.ZoneId;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$ZoneIdSerializer extends Serializer<ZoneId> {
    private TimeSerializers$ZoneIdSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ ZoneId read(Kryo kryo, Input input, Class<ZoneId> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, ZoneId zoneId) {
        write2(kryo, output, zoneId);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public ZoneId read2(Kryo kryo, Input input, Class<ZoneId> cls) {
        return read(input);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, ZoneId zoneId) {
        write(output, zoneId);
    }

    public /* synthetic */ TimeSerializers$ZoneIdSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }

    public static ZoneId read(Input input) {
        return ZoneId.of(input.readString());
    }

    public static void write(Output output, ZoneId zoneId) {
        output.writeString(zoneId.getId());
    }
}
