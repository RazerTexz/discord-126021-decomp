package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$StringBuilderSerializer extends Serializer<StringBuilder> {
    public DefaultSerializers$StringBuilderSerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ StringBuilder copy(Kryo kryo, StringBuilder sb) {
        return copy2(kryo, sb);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ StringBuilder read(Kryo kryo, Input input, Class<StringBuilder> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, StringBuilder sb) {
        write2(kryo, output, sb);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public StringBuilder copy2(Kryo kryo, StringBuilder sb) {
        return new StringBuilder(sb);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public StringBuilder read2(Kryo kryo, Input input, Class<StringBuilder> cls) {
        return input.readStringBuilder();
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, StringBuilder sb) {
        output.writeString(sb);
    }
}
