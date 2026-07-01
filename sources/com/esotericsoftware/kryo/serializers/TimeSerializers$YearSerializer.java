package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.Year;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$YearSerializer extends Serializer<Year> {
    private TimeSerializers$YearSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Year read(Kryo kryo, Input input, Class<Year> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Year year) {
        write2(kryo, output, year);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Year read2(Kryo kryo, Input input, Class<Year> cls) {
        return Year.of(input.readInt(true));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Year year) {
        output.writeInt(year.getValue(), true);
    }

    public /* synthetic */ TimeSerializers$YearSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }
}
