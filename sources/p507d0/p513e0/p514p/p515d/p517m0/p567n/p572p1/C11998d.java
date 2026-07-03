package p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.d */
/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11998d {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11477z0 f24859a;

    /* JADX INFO: renamed from: b */
    public final AbstractC11913c0 f24860b;

    /* JADX INFO: renamed from: c */
    public final AbstractC11913c0 f24861c;

    public C11998d(InterfaceC11477z0 interfaceC11477z0, AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1) {
        C12238m.checkNotNullParameter(interfaceC11477z0, "typeParameter");
        C12238m.checkNotNullParameter(abstractC11913c0, "inProjection");
        C12238m.checkNotNullParameter(abstractC11913c1, "outProjection");
        this.f24859a = interfaceC11477z0;
        this.f24860b = abstractC11913c0;
        this.f24861c = abstractC11913c1;
    }

    public final AbstractC11913c0 getInProjection() {
        return this.f24860b;
    }

    public final AbstractC11913c0 getOutProjection() {
        return this.f24861c;
    }

    public final InterfaceC11477z0 getTypeParameter() {
        return this.f24859a;
    }

    public final boolean isConsistent() {
        return InterfaceC11946f.f24806a.isSubtypeOf(this.f24860b, this.f24861c);
    }
}
