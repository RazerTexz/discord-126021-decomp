package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.v, reason: use source file name */
/* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ModuleAwareClassDescriptor2 {
    public static final MemberScope3 getRefinedMemberScopeIfPossible(ClassDescriptor classDescriptor, TypeSubstitution5 typeSubstitution5, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(typeSubstitution5, "typeSubstitution");
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return ModuleAwareClassDescriptor.j.getRefinedMemberScopeIfPossible$descriptors(classDescriptor, typeSubstitution5, kotlinTypeRefiner);
    }

    public static final MemberScope3 getRefinedUnsubstitutedMemberScopeIfPossible(ClassDescriptor classDescriptor, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return ModuleAwareClassDescriptor.j.getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(classDescriptor, kotlinTypeRefiner);
    }
}
