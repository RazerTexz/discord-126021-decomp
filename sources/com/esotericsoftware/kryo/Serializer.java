package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public abstract class Serializer<T> {
    private boolean acceptsNull;
    private boolean immutable;

    public Serializer() {
    }

    public T copy(Kryo kryo, T t) {
        if (isImmutable()) {
            return t;
        }
        StringBuilder sbM833U = C1643a.m833U("Serializer does not support copy: ");
        sbM833U.append(getClass().getName());
        throw new KryoException(sbM833U.toString());
    }

    public boolean getAcceptsNull() {
        return this.acceptsNull;
    }

    public boolean isImmutable() {
        return this.immutable;
    }

    public abstract T read(Kryo kryo, Input input, Class<T> cls);

    public void setAcceptsNull(boolean z2) {
        this.acceptsNull = z2;
    }

    public void setGenerics(Kryo kryo, Class[] clsArr) {
    }

    public void setImmutable(boolean z2) {
        this.immutable = z2;
    }

    public abstract void write(Kryo kryo, Output output, T t);

    public Serializer(boolean z2) {
        this.acceptsNull = z2;
    }

    public Serializer(boolean z2, boolean z3) {
        this.acceptsNull = z2;
        this.immutable = z3;
    }
}
