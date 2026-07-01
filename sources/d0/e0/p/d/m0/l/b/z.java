package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.f.c$c;
import d0.e0.p.d.m0.f.q$b$c;
import d0.e0.p.d.m0.f.s$c;
import d0.e0.p.d.m0.n.j1;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: ProtoEnumFlags.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public static final z a = new z();

    public final d0.e0.p.d.m0.c.f classKind(c$c c_c) {
        d0.e0.p.d.m0.c.f fVar = d0.e0.p.d.m0.c.f.CLASS;
        switch (c_c == null ? -1 : z$a.f3511b[c_c.ordinal()]) {
            case 1:
            default:
                return fVar;
            case 2:
                return d0.e0.p.d.m0.c.f.INTERFACE;
            case 3:
                return d0.e0.p.d.m0.c.f.ENUM_CLASS;
            case 4:
                return d0.e0.p.d.m0.c.f.ENUM_ENTRY;
            case 5:
                return d0.e0.p.d.m0.c.f.ANNOTATION_CLASS;
            case 6:
            case 7:
                return d0.e0.p.d.m0.c.f.OBJECT;
        }
    }

    public final d0.e0.p.d.m0.c.z modality(d0.e0.p.d.m0.f.k kVar) {
        int i = kVar == null ? -1 : z$a.a[kVar.ordinal()];
        if (i == 1) {
            return d0.e0.p.d.m0.c.z.FINAL;
        }
        if (i == 2) {
            return d0.e0.p.d.m0.c.z.OPEN;
        }
        if (i != 3) {
            return i != 4 ? d0.e0.p.d.m0.c.z.FINAL : d0.e0.p.d.m0.c.z.SEALED;
        }
        return d0.e0.p.d.m0.c.z.ABSTRACT;
    }

    public final j1 variance(s$c s_c) {
        d0.z.d.m.checkNotNullParameter(s_c, "variance");
        int iOrdinal = s_c.ordinal();
        if (iOrdinal == 0) {
            return j1.IN_VARIANCE;
        }
        if (iOrdinal == 1) {
            return j1.OUT_VARIANCE;
        }
        if (iOrdinal == 2) {
            return j1.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final j1 variance(q$b$c q_b_c) {
        d0.z.d.m.checkNotNullParameter(q_b_c, "projection");
        int iOrdinal = q_b_c.ordinal();
        if (iOrdinal == 0) {
            return j1.IN_VARIANCE;
        }
        if (iOrdinal == 1) {
            return j1.OUT_VARIANCE;
        }
        if (iOrdinal == 2) {
            return j1.INVARIANT;
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException(d0.z.d.m.stringPlus("Only IN, OUT and INV are supported. Actual argument: ", q_b_c));
    }
}
