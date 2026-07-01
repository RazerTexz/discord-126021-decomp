package d0.e0;

import d0.z.d.Intrinsics3;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: d0.e0.a, reason: use source file name */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypesJVM implements GenericArrayType, Type {
    public final Type j;

    public TypesJVM(Type type) {
        Intrinsics3.checkNotNullParameter(type, "elementType");
        this.j = type;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && Intrinsics3.areEqual(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.j;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return TypesJVM5.access$typeToString(this.j) + "[]";
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
