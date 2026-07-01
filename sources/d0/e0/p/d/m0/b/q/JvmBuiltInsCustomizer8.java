package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.p.DFS;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.m, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer8 implements DFS.c<CallableMemberDescriptor> {
    public static final JvmBuiltInsCustomizer8 a = new JvmBuiltInsCustomizer8();

    @Override // d0.e0.p.d.m0.p.DFS.c
    public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
    }
}
