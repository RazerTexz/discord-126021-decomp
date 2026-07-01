package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends u {
    public final f1 a;

    public r(f1 f1Var) {
        d0.z.d.m.checkNotNullParameter(f1Var, "delegate");
        this.a = f1Var;
    }

    @Override // d0.e0.p.d.m0.c.u
    public f1 getDelegate() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.c.u
    public String getInternalDisplayName() {
        return getDelegate().getInternalDisplayName();
    }

    @Override // d0.e0.p.d.m0.c.u
    public u normalize() {
        u descriptorVisibility = t.toDescriptorVisibility(getDelegate().normalize());
        d0.z.d.m.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(delegate.normalize())");
        return descriptorVisibility;
    }
}
