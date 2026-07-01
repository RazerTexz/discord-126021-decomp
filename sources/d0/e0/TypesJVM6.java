package d0.e0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.o, reason: use source file name */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypesJVM6 implements WildcardType, Type {
    public final Type l;
    public final Type m;
    public static final a k = new a(null);
    public static final TypesJVM6 j = new TypesJVM6(null, null);

    /* JADX INFO: renamed from: d0.e0.o$a */
    /* JADX INFO: compiled from: TypesJVM.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final TypesJVM6 getSTAR() {
            return TypesJVM6.j;
        }
    }

    public TypesJVM6(Type type, Type type2) {
        this.l = type;
        this.m = type2;
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
            StringBuilder sbU = outline.U("? super ");
            sbU.append(TypesJVM5.access$typeToString(this.m));
            return sbU.toString();
        }
        Type type = this.l;
        if (type == null || !(!Intrinsics3.areEqual(type, Object.class))) {
            return "?";
        }
        StringBuilder sbU2 = outline.U("? extends ");
        sbU2.append(TypesJVM5.access$typeToString(this.l));
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
