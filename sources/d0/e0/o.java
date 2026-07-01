package d0.e0;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements WildcardType, Type {
    public final Type l;
    public final Type m;
    public static final o$a k = new o$a(null);
    public static final o j = new o(null, null);

    public o(Type type, Type type2) {
        this.l = type;
        this.m = type2;
    }

    public static final /* synthetic */ o access$getSTAR$cp() {
        return j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.m;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        if (this.m != null) {
            StringBuilder sbU = b.d.b.a.a.U("? super ");
            sbU.append(n.access$typeToString(this.m));
            return sbU.toString();
        }
        Type type = this.l;
        if (type == null || !(!d0.z.d.m.areEqual(type, Object.class))) {
            return "?";
        }
        StringBuilder sbU2 = b.d.b.a.a.U("? extends ");
        sbU2.append(n.access$typeToString(this.l));
        return sbU2.toString();
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.l;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public String toString() {
        return getTypeName();
    }
}
