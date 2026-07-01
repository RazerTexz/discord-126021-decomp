package com.esotericsoftware.kryo;

import b.e.a.a$a;
import com.esotericsoftware.kryo.util.Util;
import h0.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class Registration {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f2880id;
    private a instantiator;
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

    public a getInstantiator() {
        return this.instantiator;
    }

    public Serializer getSerializer() {
        return this.serializer;
    }

    public Class getType() {
        return this.type;
    }

    public void setInstantiator(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("instantiator cannot be null.");
        }
        this.instantiator = aVar;
    }

    public void setSerializer(Serializer serializer) {
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.serializer = serializer;
        a$a a_a = b.e.a.a.a;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[");
        sbU.append(this.f2880id);
        sbU.append(", ");
        sbU.append(Util.className(this.type));
        sbU.append("]");
        return sbU.toString();
    }
}
