package p507d0.p513e0;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KType;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.i */
/* JADX INFO: compiled from: KTypeProjection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11236i {

    /* JADX INFO: renamed from: c */
    public final EnumC11237j f22302c;

    /* JADX INFO: renamed from: d */
    public final KType f22303d;

    /* JADX INFO: renamed from: b */
    public static final a f22301b = new a(null);

    /* JADX INFO: renamed from: a */
    public static final C11236i f22300a = new C11236i(null, null);

    /* JADX INFO: renamed from: d0.e0.i$a */
    /* JADX INFO: compiled from: KTypeProjection.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11236i contravariant(KType kType) {
            C12238m.checkNotNullParameter(kType, "type");
            return new C11236i(EnumC11237j.IN, kType);
        }

        public final C11236i covariant(KType kType) {
            C12238m.checkNotNullParameter(kType, "type");
            return new C11236i(EnumC11237j.OUT, kType);
        }

        public final C11236i getSTAR() {
            return C11236i.f22300a;
        }

        public final C11236i invariant(KType kType) {
            C12238m.checkNotNullParameter(kType, "type");
            return new C11236i(EnumC11237j.INVARIANT, kType);
        }
    }

    public C11236i(EnumC11237j enumC11237j, KType kType) {
        String str;
        this.f22302c = enumC11237j;
        this.f22303d = kType;
        if ((enumC11237j == null) == (kType == null)) {
            return;
        }
        if (enumC11237j == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + enumC11237j + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final EnumC11237j component1() {
        return this.f22302c;
    }

    public final KType component2() {
        return this.f22303d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11236i)) {
            return false;
        }
        C11236i c11236i = (C11236i) obj;
        return C12238m.areEqual(this.f22302c, c11236i.f22302c) && C12238m.areEqual(this.f22303d, c11236i.f22303d);
    }

    public final KType getType() {
        return this.f22303d;
    }

    public final EnumC11237j getVariance() {
        return this.f22302c;
    }

    public int hashCode() {
        EnumC11237j enumC11237j = this.f22302c;
        int iHashCode = (enumC11237j != null ? enumC11237j.hashCode() : 0) * 31;
        KType kType = this.f22303d;
        return iHashCode + (kType != null ? kType.hashCode() : 0);
    }

    public String toString() {
        EnumC11237j enumC11237j = this.f22302c;
        if (enumC11237j == null) {
            return "*";
        }
        int iOrdinal = enumC11237j.ordinal();
        if (iOrdinal == 0) {
            return String.valueOf(this.f22303d);
        }
        if (iOrdinal == 1) {
            StringBuilder sbM833U = C1643a.m833U("in ");
            sbM833U.append(this.f22303d);
            return sbM833U.toString();
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sbM833U2 = C1643a.m833U("out ");
        sbM833U2.append(this.f22303d);
        return sbM833U2.toString();
    }
}
