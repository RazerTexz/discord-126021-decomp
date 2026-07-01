package d0.e0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KType;

/* JADX INFO: renamed from: d0.e0.i, reason: use source file name */
/* JADX INFO: compiled from: KTypeProjection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KTypeProjection {
    public final KVariance c;
    public final KType d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3190b = new a(null);
    public static final KTypeProjection a = new KTypeProjection(null, null);

    /* JADX INFO: renamed from: d0.e0.i$a */
    /* JADX INFO: compiled from: KTypeProjection.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KTypeProjection contravariant(KType kType) {
            Intrinsics3.checkNotNullParameter(kType, "type");
            return new KTypeProjection(KVariance.IN, kType);
        }

        public final KTypeProjection covariant(KType kType) {
            Intrinsics3.checkNotNullParameter(kType, "type");
            return new KTypeProjection(KVariance.OUT, kType);
        }

        public final KTypeProjection getSTAR() {
            return KTypeProjection.a;
        }

        public final KTypeProjection invariant(KType kType) {
            Intrinsics3.checkNotNullParameter(kType, "type");
            return new KTypeProjection(KVariance.INVARIANT, kType);
        }
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        String str;
        this.c = kVariance;
        this.d = kType;
        if ((kVariance == null) == (kType == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final KVariance component1() {
        return this.c;
    }

    public final KType component2() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTypeProjection)) {
            return false;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) obj;
        return Intrinsics3.areEqual(this.c, kTypeProjection.c) && Intrinsics3.areEqual(this.d, kTypeProjection.d);
    }

    public final KType getType() {
        return this.d;
    }

    public final KVariance getVariance() {
        return this.c;
    }

    public int hashCode() {
        KVariance kVariance = this.c;
        int iHashCode = (kVariance != null ? kVariance.hashCode() : 0) * 31;
        KType kType = this.d;
        return iHashCode + (kType != null ? kType.hashCode() : 0);
    }

    public String toString() {
        KVariance kVariance = this.c;
        if (kVariance == null) {
            return "*";
        }
        int iOrdinal = kVariance.ordinal();
        if (iOrdinal == 0) {
            return String.valueOf(this.d);
        }
        if (iOrdinal == 1) {
            StringBuilder sbU = outline.U("in ");
            sbU.append(this.d);
            return sbU.toString();
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sbU2 = outline.U("out ");
        sbU2.append(this.d);
        return sbU2.toString();
    }
}
