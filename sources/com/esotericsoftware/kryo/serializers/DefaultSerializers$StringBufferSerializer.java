package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$StringBufferSerializer extends Serializer<StringBuffer> {
    public DefaultSerializers$StringBufferSerializer() {
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ StringBuffer copy(Kryo kryo, StringBuffer stringBuffer) {
        return copy2(kryo, stringBuffer);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ StringBuffer read(Kryo kryo, Input input, Class<StringBuffer> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, StringBuffer stringBuffer) {
        write2(kryo, output, stringBuffer);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public StringBuffer copy2(Kryo kryo, StringBuffer stringBuffer) {
        return new StringBuffer(stringBuffer);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public StringBuffer read2(Kryo kryo, Input input, Class<StringBuffer> cls) {
        String string = input.readString();
        if (string == null) {
            return null;
        }
        return new StringBuffer(string);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, StringBuffer stringBuffer) {
        output.writeString(stringBuffer);
    }
}
