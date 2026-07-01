package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$CharsetSerializer extends Serializer<Charset> {
    public DefaultSerializers$CharsetSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Charset read(Kryo kryo, Input input, Class<Charset> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Charset charset) {
        write2(kryo, output, charset);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Charset read2(Kryo kryo, Input input, Class<Charset> cls) {
        return Charset.forName(input.readString());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Charset charset) {
        output.writeString(charset.name());
    }
}
