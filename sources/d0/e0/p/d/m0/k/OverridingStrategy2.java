package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.j, reason: use source file name */
/* JADX INFO: compiled from: OverridingStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OverridingStrategy2 {
    public abstract void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor);

    public abstract void inheritanceConflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public abstract void overrideConflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public void setOverriddenDescriptors(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "member");
        Intrinsics3.checkNotNullParameter(collection, "overridden");
        callableMemberDescriptor.setOverriddenDescriptors(collection);
    }
}
