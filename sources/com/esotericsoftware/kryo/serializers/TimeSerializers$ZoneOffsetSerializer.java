package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.time.ZoneOffset;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class TimeSerializers$ZoneOffsetSerializer extends Serializer<ZoneOffset> {
    private TimeSerializers$ZoneOffsetSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ ZoneOffset read(Kryo kryo, Input input, Class<ZoneOffset> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, ZoneOffset zoneOffset) {
        write2(kryo, output, zoneOffset);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public ZoneOffset read2(Kryo kryo, Input input, Class<ZoneOffset> cls) {
        return read(input);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, ZoneOffset zoneOffset) {
        write(output, zoneOffset);
    }

    public /* synthetic */ TimeSerializers$ZoneOffsetSerializer(TimeSerializers$1 timeSerializers$1) {
        this();
    }

    public static ZoneOffset read(Input input) {
        byte b2 = input.readByte();
        return b2 == 127 ? ZoneOffset.ofTotalSeconds(input.readInt()) : ZoneOffset.ofTotalSeconds(b2 * 900);
    }

    public static void write(Output output, ZoneOffset zoneOffset) {
        int totalSeconds = zoneOffset.getTotalSeconds();
        int i = totalSeconds % 900 == 0 ? totalSeconds / 900 : Opcodes.LAND;
        output.writeByte(i);
        if (i == 127) {
            output.writeInt(totalSeconds);
        }
    }
}
