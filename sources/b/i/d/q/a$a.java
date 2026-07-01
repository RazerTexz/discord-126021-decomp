package b.i.d.q;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: $Gson$Types.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type componentType;

    public a$a(Type type) {
        this.componentType = a.a(type);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && a.c(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.componentType;
    }

    public int hashCode() {
        return this.componentType.hashCode();
    }

    public String toString() {
        return a.i(this.componentType) + "[]";
    }
}
