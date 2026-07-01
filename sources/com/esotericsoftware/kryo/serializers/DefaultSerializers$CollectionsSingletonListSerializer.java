package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$CollectionsSingletonListSerializer extends Serializer<List> {
    public DefaultSerializers$CollectionsSingletonListSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ List read(Kryo kryo, Input input, Class<List> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, List list) {
        write2(kryo, output, list);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public List read2(Kryo kryo, Input input, Class<List> cls) {
        return Collections.singletonList(kryo.readClassAndObject(input));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, List list) {
        kryo.writeClassAndObject(output, list.get(0));
    }
}
