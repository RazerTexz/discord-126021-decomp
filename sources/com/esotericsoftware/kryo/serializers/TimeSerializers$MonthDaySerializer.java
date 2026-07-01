package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.MonthDay;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$MonthDaySerializer extends Serializer<MonthDay> {
    private TimeSerializers$MonthDaySerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ MonthDay read(Kryo kryo, Input input, Class<MonthDay> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, MonthDay monthDay) {
        write2(kryo, output, monthDay);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public MonthDay read2(Kryo kryo, Input input, Class<MonthDay> cls) {
        return MonthDay.of(input.readByte(), input.readByte());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, MonthDay monthDay) {
        output.writeByte(monthDay.getMonthValue());
        output.writeByte(monthDay.getDayOfMonth());
    }

    public /* synthetic */ TimeSerializers$MonthDaySerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }
}
