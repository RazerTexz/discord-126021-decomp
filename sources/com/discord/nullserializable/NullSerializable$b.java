package com.discord.nullserializable;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NullSerializable$b<T> extends NullSerializable<T> {
    private final T value;

    public NullSerializable$b(T t) {
        super(t, null);
        this.value = t;
    }

    @Override // com.discord.nullserializable.NullSerializable
    public T a() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof NullSerializable$b) && m.areEqual(this.value, ((NullSerializable$b) obj).value);
        }
        return true;
    }

    public int hashCode() {
        T t = this.value;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Value(value=");
        sbU.append(this.value);
        sbU.append(")");
        return sbU.toString();
    }
}
