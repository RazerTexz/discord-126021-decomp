package d0.e0;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: KTypeProjection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public final j c;
    public final KType d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i$a f3190b = new i$a(null);
    public static final i a = new i(null, null);

    public i(j jVar, KType kType) {
        String str;
        this.c = jVar;
        this.d = kType;
        if ((jVar == null) == (kType == null)) {
            return;
        }
        if (jVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + jVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final j component1() {
        return this.c;
    }

    public final KType component2() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return d0.z.d.m.areEqual(this.c, iVar.c) && d0.z.d.m.areEqual(this.d, iVar.d);
    }

    public final KType getType() {
        return this.d;
    }

    public final j getVariance() {
        return this.c;
    }

    public int hashCode() {
        j jVar = this.c;
        int iHashCode = (jVar != null ? jVar.hashCode() : 0) * 31;
        KType kType = this.d;
        return iHashCode + (kType != null ? kType.hashCode() : 0);
    }

    public String toString() {
        j jVar = this.c;
        if (jVar == null) {
            return "*";
        }
        int iOrdinal = jVar.ordinal();
        if (iOrdinal == 0) {
            return String.valueOf(this.d);
        }
        if (iOrdinal == 1) {
            StringBuilder sbU = b.d.b.a.a.U("in ");
            sbU.append(this.d);
            return sbU.toString();
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sbU2 = b.d.b.a.a.U("out ");
        sbU2.append(this.d);
        return sbU2.toString();
    }
}
