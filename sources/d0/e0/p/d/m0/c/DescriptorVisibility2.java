package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.k.a0.p.ReceiverValue;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.u, reason: use source file name */
/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorVisibility2 {
    public final Integer compareTo(DescriptorVisibility2 descriptorVisibility2) {
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibility");
        return getDelegate().compareTo(descriptorVisibility2.getDelegate());
    }

    public abstract Visibility2 getDelegate();

    public abstract String getInternalDisplayName();

    public final boolean isPublicAPI() {
        return getDelegate().isPublicAPI();
    }

    public abstract boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor);

    public abstract DescriptorVisibility2 normalize();

    public final String toString() {
        return getDelegate().toString();
    }
}
