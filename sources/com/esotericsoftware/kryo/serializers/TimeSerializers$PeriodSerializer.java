package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.Period;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$PeriodSerializer extends Serializer<Period> {
    private TimeSerializers$PeriodSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Period read(Kryo kryo, Input input, Class<Period> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Period period) {
        write2(kryo, output, period);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Period read2(Kryo kryo, Input input, Class<Period> cls) {
        return Period.of(input.readInt(true), input.readInt(true), input.readInt(true));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Period period) {
        output.writeInt(period.getYears(), true);
        output.writeInt(period.getMonths(), true);
        output.writeInt(period.getDays(), true);
    }

    public /* synthetic */ TimeSerializers$PeriodSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }
}
