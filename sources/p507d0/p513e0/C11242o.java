package p507d0.p513e0;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.o */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11242o implements WildcardType, Type {

    /* JADX INFO: renamed from: l */
    public final Type f22316l;

    /* JADX INFO: renamed from: m */
    public final Type f22317m;

    /* JADX INFO: renamed from: k */
    public static final a f22315k = new a(null);

    /* JADX INFO: renamed from: j */
    public static final C11242o f22314j = new C11242o(null, null);

    /* JADX INFO: renamed from: d0.e0.o$a */
    /* JADX INFO: compiled from: TypesJVM.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11242o getSTAR() {
            return C11242o.f22314j;
        }
    }

    public C11242o(Type type, Type type2) {
        this.f22316l = type;
        this.f22317m = type2;
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
        Type type = this.f22317m;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        if (this.f22317m != null) {
            StringBuilder sbM833U = C1643a.m833U("? super ");
            sbM833U.append(C11241n.access$typeToString(this.f22317m));
            return sbM833U.toString();
        }
        Type type = this.f22316l;
        if (type == null || !(!C12238m.areEqual(type, Object.class))) {
            return "?";
        }
        StringBuilder sbM833U2 = C1643a.m833U("? extends ");
        sbM833U2.append(C11241n.access$typeToString(this.f22316l));
        return sbM833U2.toString();
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.f22316l;
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
