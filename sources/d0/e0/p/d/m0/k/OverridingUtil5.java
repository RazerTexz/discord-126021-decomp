package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.o, reason: use source file name */
/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OverridingUtil5 implements Function1<CallableMemberDescriptor, Unit> {
    public final /* synthetic */ OverridingStrategy2 j;
    public final /* synthetic */ CallableMemberDescriptor k;

    public OverridingUtil5(OverridingStrategy2 overridingStrategy2, CallableMemberDescriptor callableMemberDescriptor) {
        this.j = overridingStrategy2;
        this.k = callableMemberDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(CallableMemberDescriptor callableMemberDescriptor) {
        this.j.inheritanceConflict(this.k, callableMemberDescriptor);
        return Unit.a;
    }
}
