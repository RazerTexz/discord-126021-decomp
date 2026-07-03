package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.r */
/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11460r extends AbstractC11466u {

    /* JADX INFO: renamed from: a */
    public final AbstractC11335f1 f23076a;

    public AbstractC11460r(AbstractC11335f1 abstractC11335f1) {
        C12238m.checkNotNullParameter(abstractC11335f1, "delegate");
        this.f23076a = abstractC11335f1;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
    public AbstractC11335f1 getDelegate() {
        return this.f23076a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
    public String getInternalDisplayName() {
        return getDelegate().getInternalDisplayName();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
    public AbstractC11466u normalize() {
        AbstractC11466u descriptorVisibility = C11464t.toDescriptorVisibility(getDelegate().normalize());
        C12238m.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(delegate.normalize())");
        return descriptorVisibility;
    }
}
