package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.LocalTime;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$LocalTimeSerializer extends Serializer<LocalTime> {
    private TimeSerializers$LocalTimeSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ LocalTime read(Kryo kryo, Input input, Class<LocalTime> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, LocalTime localTime) {
        write2(kryo, output, localTime);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public LocalTime read2(Kryo kryo, Input input, Class<LocalTime> cls) {
        return read(input);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, LocalTime localTime) {
        write(output, localTime);
    }

    public /* synthetic */ TimeSerializers$LocalTimeSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }

    public static LocalTime read(Input input) {
        int i;
        int i2;
        int i3 = input.readByte();
        int i4 = 0;
        if (i3 >= 0) {
            byte b2 = input.readByte();
            if (b2 < 0) {
                int i5 = ~b2;
                i2 = 0;
                i4 = i5;
                i = 0;
            } else {
                byte b3 = input.readByte();
                if (b3 < 0) {
                    i = ~b3;
                    i4 = b2;
                } else {
                    int i6 = input.readInt(true);
                    i = b3;
                    i2 = i6;
                    i4 = b2;
                }
            }
            return LocalTime.of(i3, i4, i, i2);
        }
        i3 = ~i3;
        i = 0;
        i2 = 0;
        return LocalTime.of(i3, i4, i, i2);
    }

    public static void write(Output output, LocalTime localTime) {
        if (localTime.getNano() == 0) {
            if (localTime.getSecond() == 0) {
                if (localTime.getMinute() == 0) {
                    output.writeByte(~localTime.getHour());
                    return;
                } else {
                    output.writeByte(localTime.getHour());
                    output.writeByte(~localTime.getMinute());
                    return;
                }
            }
            output.writeByte(localTime.getHour());
            output.writeByte(localTime.getMinute());
            output.writeByte(~localTime.getSecond());
            return;
        }
        output.writeByte(localTime.getHour());
        output.writeByte(localTime.getMinute());
        output.writeByte(localTime.getSecond());
        output.writeInt(localTime.getNano(), true);
    }
}
