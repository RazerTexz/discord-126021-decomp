package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Collections;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$CollectionsSingletonMapSerializer extends Serializer<Map> {
    public DefaultSerializers$CollectionsSingletonMapSerializer() {
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Map read(Kryo kryo, Input input, Class<Map> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Map map) {
        write2(kryo, output, map);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Map read2(Kryo kryo, Input input, Class<Map> cls) {
        return Collections.singletonMap(kryo.readClassAndObject(input), kryo.readClassAndObject(input));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Map map) {
        Map$Entry map$Entry = (Map$Entry) map.entrySet().iterator().next();
        kryo.writeClassAndObject(output, map$Entry.getKey());
        kryo.writeClassAndObject(output, map$Entry.getValue());
    }
}
