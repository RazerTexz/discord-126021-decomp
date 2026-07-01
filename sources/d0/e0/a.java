package d0.e0;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements GenericArrayType, Type {
    public final Type j;

    public a(Type type) {
        d0.z.d.m.checkNotNullParameter(type, "elementType");
        this.j = type;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && d0.z.d.m.areEqual(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.j;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return n.access$typeToString(this.j) + "[]";
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
