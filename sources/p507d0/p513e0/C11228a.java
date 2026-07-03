package p507d0.p513e0;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.a */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11228a implements GenericArrayType, Type {

    /* JADX INFO: renamed from: j */
    public final Type f22295j;

    public C11228a(Type type) {
        C12238m.checkNotNullParameter(type, "elementType");
        this.f22295j = type;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && C12238m.areEqual(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.f22295j;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return C11241n.access$typeToString(this.f22295j) + "[]";
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
