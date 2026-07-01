package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.YearMonth;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$YearMonthSerializer extends Serializer<YearMonth> {
    private TimeSerializers$YearMonthSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ YearMonth read(Kryo kryo, Input input, Class<YearMonth> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, YearMonth yearMonth) {
        write2(kryo, output, yearMonth);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public YearMonth read2(Kryo kryo, Input input, Class<YearMonth> cls) {
        return YearMonth.of(input.readInt(true), input.readByte());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, YearMonth yearMonth) {
        output.writeInt(yearMonth.getYear(), true);
        output.writeByte(yearMonth.getMonthValue());
    }

    public /* synthetic */ TimeSerializers$YearMonthSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }
}
