package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$CollectionsSingletonSetSerializer extends Serializer<Set> {
    public DefaultSerializers$CollectionsSingletonSetSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Set read(Kryo kryo, Input input, Class<Set> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Set set) {
        write2(kryo, output, set);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Set read2(Kryo kryo, Input input, Class<Set> cls) {
        return Collections.singleton(kryo.readClassAndObject(input));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Set set) {
        kryo.writeClassAndObject(output, set.iterator().next());
    }
}
