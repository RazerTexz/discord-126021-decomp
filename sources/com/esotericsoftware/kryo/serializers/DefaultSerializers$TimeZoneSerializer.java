package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$TimeZoneSerializer extends Serializer<TimeZone> {
    public DefaultSerializers$TimeZoneSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ TimeZone read(Kryo kryo, Input input, Class<TimeZone> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, TimeZone timeZone) {
        write2(kryo, output, timeZone);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public TimeZone read2(Kryo kryo, Input input, Class<TimeZone> cls) {
        return TimeZone.getTimeZone(input.readString());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, TimeZone timeZone) {
        output.writeString(timeZone.getID());
    }
}
