package com.discord.nullserializable;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NullSerializable$a<T> extends NullSerializable<T> {
    private final T value;

    public NullSerializable$a() {
        this(null, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NullSerializable$a(Object obj, int i) {
        super(null, null);
        int i2 = i & 1;
        this.value = null;
    }

    @Override // com.discord.nullserializable.NullSerializable
    public T a() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof NullSerializable$a) && m.areEqual(this.value, ((NullSerializable$a) obj).value);
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
        StringBuilder sbU = a.U("Null(value=");
        sbU.append(this.value);
        sbU.append(")");
        return sbU.toString();
    }
}
