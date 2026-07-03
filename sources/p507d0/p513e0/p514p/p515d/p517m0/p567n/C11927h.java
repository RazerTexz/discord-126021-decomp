package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.h */
/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11927h extends AbstractC11970n {

    /* JADX INFO: renamed from: l */
    public final InterfaceC11344g f24779l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11927h(AbstractC11934j0 abstractC11934j0, InterfaceC11344g interfaceC11344g) {
        super(abstractC11934j0);
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        this.f24779l = interfaceC11344g;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return this.f24779l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public C11927h replaceDelegate(AbstractC11934j0 abstractC11934j0) {
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        return new C11927h(abstractC11934j0, getAnnotations());
    }
}
