package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$KryoSerializableSerializer extends Serializer<KryoSerializable> {
    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ KryoSerializable read(Kryo kryo, Input input, Class<KryoSerializable> cls) {
        return read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, KryoSerializable kryoSerializable) {
        write2(kryo, output, kryoSerializable);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public KryoSerializable read(Kryo kryo, Input input, Class<KryoSerializable> cls) {
        KryoSerializable kryoSerializable = (KryoSerializable) kryo.newInstance(cls);
        kryo.reference(kryoSerializable);
        kryoSerializable.read(kryo, input);
        return kryoSerializable;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, KryoSerializable kryoSerializable) {
        kryoSerializable.write(kryo, output);
    }
}
