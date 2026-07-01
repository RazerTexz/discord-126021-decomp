package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Util;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$ClassSerializer extends Serializer<Class> {
    public DefaultSerializers$ClassSerializer() {
        setImmutable(true);
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Class read(Kryo kryo, Input input, Class<Class> cls) {
        return read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Class cls) {
        write2(kryo, output, cls);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public Class read(Kryo kryo, Input input, Class<Class> cls) {
        Registration registration = kryo.readClass(input);
        int i = input.read();
        Class type = registration != null ? registration.getType() : null;
        return (type == null || !type.isPrimitive() || i == 1) ? type : Util.getWrapperClass(type);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Class cls) {
        kryo.writeClass(output, cls);
        output.writeByte((cls == null || !cls.isPrimitive()) ? 0 : 1);
    }
}
