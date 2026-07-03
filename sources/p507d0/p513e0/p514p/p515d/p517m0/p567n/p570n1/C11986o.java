package p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1;

import kotlin.NoWhenBranchMatchedException;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.n1.o */
/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11986o {
    public static final EnumC11989r convertVariance(EnumC11935j1 enumC11935j1) {
        C12238m.checkNotNullParameter(enumC11935j1, "<this>");
        int iOrdinal = enumC11935j1.ordinal();
        if (iOrdinal == 0) {
            return EnumC11989r.INV;
        }
        if (iOrdinal == 1) {
            return EnumC11989r.IN;
        }
        if (iOrdinal == 2) {
            return EnumC11989r.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
