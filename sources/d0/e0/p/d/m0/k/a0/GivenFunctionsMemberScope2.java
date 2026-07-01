package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.k.OverridingStrategy;
import d0.e0.p.d.m0.k.OverridingUtil;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.f, reason: use source file name */
/* JADX INFO: compiled from: GivenFunctionsMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GivenFunctionsMemberScope2 extends OverridingStrategy {
    public final /* synthetic */ ArrayList<DeclarationDescriptor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GivenFunctionsMemberScope f3457b;

    public GivenFunctionsMemberScope2(ArrayList<DeclarationDescriptor> arrayList, GivenFunctionsMemberScope givenFunctionsMemberScope) {
        this.a = arrayList;
        this.f3457b = givenFunctionsMemberScope;
    }

    @Override // d0.e0.p.d.m0.k.OverridingStrategy2
    public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "fakeOverride");
        OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
        this.a.add(callableMemberDescriptor);
    }

    @Override // d0.e0.p.d.m0.k.OverridingStrategy
    public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "fromSuper");
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor2, "fromCurrent");
        throw new IllegalStateException(("Conflict in scope of " + this.f3457b.c + ": " + callableMemberDescriptor + " vs " + callableMemberDescriptor2).toString());
    }
}
