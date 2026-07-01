package com.esotericsoftware.kryo;

import b.d.b.a.outline;
import b.e.a.Log;
import com.esotericsoftware.kryo.util.Util;
import h0.b.a.ObjectInstantiator;

/* JADX INFO: loaded from: classes.dex */
public class Registration {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f2880id;
    private ObjectInstantiator instantiator;
    private Serializer serializer;
    private final Class type;

    public Registration(Class cls, Serializer serializer, int i) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.type = cls;
        this.serializer = serializer;
        this.f2880id = i;
    }

    public int getId() {
        return this.f2880id;
    }

    public ObjectInstantiator getInstantiator() {
        return this.instantiator;
    }

    public Serializer getSerializer() {
        return this.serializer;
    }

    public Class getType() {
        return this.type;
    }

    public void setInstantiator(ObjectInstantiator objectInstantiator) {
        if (objectInstantiator == null) {
            throw new IllegalArgumentException("instantiator cannot be null.");
        }
        this.instantiator = objectInstantiator;
    }

    public void setSerializer(Serializer serializer) {
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.serializer = serializer;
        Log.a aVar = Log.a;
    }

    public String toString() {
        StringBuilder sbU = outline.U("[");
        sbU.append(this.f2880id);
        sbU.append(", ");
        sbU.append(Util.className(this.type));
        sbU.append("]");
        return sbU.toString();
    }
}
