package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.h0 */
/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11928h0 extends AbstractC11970n {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11928h0(AbstractC11934j0 abstractC11934j0) {
        super(abstractC11934j0);
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public boolean isMarkedNullable() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public C11928h0 replaceDelegate(AbstractC11934j0 abstractC11934j0) {
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        return new C11928h0(abstractC11934j0);
    }
}
