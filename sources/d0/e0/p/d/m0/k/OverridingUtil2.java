package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.l, reason: use source file name */
/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OverridingUtil2 implements Function1<CallableMemberDescriptor, Boolean> {
    public final /* synthetic */ DeclarationDescriptor j;

    public OverridingUtil2(DeclarationDescriptor declarationDescriptor) {
        this.j = declarationDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(callableMemberDescriptor.getContainingDeclaration() == this.j);
    }
}
