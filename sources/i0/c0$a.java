package i0;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c0$a implements GenericArrayType {
    public final Type j;

    public c0$a(Type type) {
        this.j = type;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && c0.c(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.j;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return c0.p(this.j) + "[]";
    }
}
