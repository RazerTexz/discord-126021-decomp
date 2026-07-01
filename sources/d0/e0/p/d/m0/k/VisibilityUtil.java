package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.t, reason: use source file name */
/* JADX INFO: compiled from: VisibilityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VisibilityUtil {
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(Collection<? extends CallableMemberDescriptor> collection) {
        Integer numCompare;
        Intrinsics3.checkNotNullParameter(collection, "descriptors");
        collection.isEmpty();
        CallableMemberDescriptor callableMemberDescriptor = null;
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            if (callableMemberDescriptor == null || ((numCompare = DescriptorVisibilities.compare(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && numCompare.intValue() < 0)) {
                callableMemberDescriptor = callableMemberDescriptor2;
            }
        }
        Intrinsics3.checkNotNull(callableMemberDescriptor);
        return callableMemberDescriptor;
    }
}
