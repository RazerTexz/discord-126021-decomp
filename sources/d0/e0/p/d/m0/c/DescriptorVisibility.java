package d0.e0.p.d.m0.c;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.r, reason: use source file name */
/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorVisibility extends DescriptorVisibility2 {
    public final Visibility2 a;

    public DescriptorVisibility(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "delegate");
        this.a = visibility2;
    }

    @Override // d0.e0.p.d.m0.c.DescriptorVisibility2
    public Visibility2 getDelegate() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.c.DescriptorVisibility2
    public String getInternalDisplayName() {
        return getDelegate().getInternalDisplayName();
    }

    @Override // d0.e0.p.d.m0.c.DescriptorVisibility2
    public DescriptorVisibility2 normalize() {
        DescriptorVisibility2 descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(getDelegate().normalize());
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(delegate.normalize())");
        return descriptorVisibility;
    }
}
