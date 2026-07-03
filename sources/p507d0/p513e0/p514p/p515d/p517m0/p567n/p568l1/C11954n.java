package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11912c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12015y;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.n */
/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11954n {

    /* JADX INFO: renamed from: a */
    public static final C11954n f24825a = new C11954n();

    public final boolean isSubtypeOfAny(AbstractC11932i1 abstractC11932i1) {
        C12238m.checkNotNullParameter(abstractC11932i1, "type");
        return C11912c.f24743a.hasNotNullSupertype(C11956p.f24827a.newBaseTypeCheckerContext(false, true), C12015y.lowerIfFlexible(abstractC11932i1), AbstractC11921f.b.C13335b.f24766a);
    }
}
