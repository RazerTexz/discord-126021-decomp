package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.LocalDate;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$LocalDateSerializer extends Serializer<LocalDate> {
    private TimeSerializers$LocalDateSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ LocalDate read(Kryo kryo, Input input, Class<LocalDate> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, LocalDate localDate) {
        write2(kryo, output, localDate);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public LocalDate read2(Kryo kryo, Input input, Class<LocalDate> cls) {
        return read(input);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, LocalDate localDate) {
        write(output, localDate);
    }

    public /* synthetic */ TimeSerializers$LocalDateSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }

    public static LocalDate read(Input input) {
        return LocalDate.of(input.readInt(true), input.readByte(), input.readByte());
    }

    public static void write(Output output, LocalDate localDate) {
        output.writeInt(localDate.getYear(), true);
        output.writeByte(localDate.getMonthValue());
        output.writeByte(localDate.getDayOfMonth());
    }
}
