package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11977f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.v */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12009v extends AbstractC11932i1 implements InterfaceC11977f {

    /* JADX INFO: renamed from: k */
    public final AbstractC11934j0 f24887k;

    /* JADX INFO: renamed from: l */
    public final AbstractC11934j0 f24888l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC12009v(AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1) {
        super(null);
        C12238m.checkNotNullParameter(abstractC11934j0, "lowerBound");
        C12238m.checkNotNullParameter(abstractC11934j1, "upperBound");
        this.f24887k = abstractC11934j0;
        this.f24888l = abstractC11934j1;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return getDelegate().getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public List<InterfaceC12012w0> getArguments() {
        return getDelegate().getArguments();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC12008u0 getConstructor() {
        return getDelegate().getConstructor();
    }

    public abstract AbstractC11934j0 getDelegate();

    public final AbstractC11934j0 getLowerBound() {
        return this.f24887k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC11770i getMemberScope() {
        return getDelegate().getMemberScope();
    }

    public final AbstractC11934j0 getUpperBound() {
        return this.f24888l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public abstract String render(AbstractC11746c abstractC11746c, InterfaceC11751h interfaceC11751h);

    public String toString() {
        return AbstractC11746c.f24227c.renderType(this);
    }
}
