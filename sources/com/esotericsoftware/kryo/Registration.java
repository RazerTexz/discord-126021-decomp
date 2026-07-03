package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.util.Util;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p106e.p107a.C1644a;
import p617h0.p620b.p621a.InterfaceC12436a;

/* JADX INFO: loaded from: classes.dex */
public class Registration {

    /* JADX INFO: renamed from: id */
    private final int f19417id;
    private InterfaceC12436a instantiator;
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
        this.f19417id = i;
    }

    public int getId() {
        return this.f19417id;
    }

    public InterfaceC12436a getInstantiator() {
        return this.instantiator;
    }

    public Serializer getSerializer() {
        return this.serializer;
    }

    public Class getType() {
        return this.type;
    }

    public void setInstantiator(InterfaceC12436a interfaceC12436a) {
        if (interfaceC12436a == null) {
            throw new IllegalArgumentException("instantiator cannot be null.");
        }
        this.instantiator = interfaceC12436a;
    }

    public void setSerializer(Serializer serializer) {
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.serializer = serializer;
        C1644a.a aVar = C1644a.f3007a;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[");
        sbM833U.append(this.f19417id);
        sbM833U.append(", ");
        sbM833U.append(Util.className(this.type));
        sbM833U.append("]");
        return sbM833U.toString();
    }
}
