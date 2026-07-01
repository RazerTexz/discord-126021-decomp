package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.factories.SerializerFactory;

/* JADX INFO: loaded from: classes.dex */
public final class Kryo$DefaultSerializerEntry {
    public final SerializerFactory serializerFactory;
    public final Class type;

    public Kryo$DefaultSerializerEntry(Class cls, SerializerFactory serializerFactory) {
        this.type = cls;
        this.serializerFactory = serializerFactory;
    }
}
