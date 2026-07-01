package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.u, reason: use source file name */
/* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ModuleAwareClassDescriptor implements ClassDescriptor {
    public static final a j = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.u$a */
    /* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final MemberScope3 getRefinedMemberScopeIfPossible$descriptors(ClassDescriptor classDescriptor, TypeSubstitution5 typeSubstitution5, KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
            Intrinsics3.checkNotNullParameter(typeSubstitution5, "typeSubstitution");
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            ModuleAwareClassDescriptor moduleAwareClassDescriptor = classDescriptor instanceof ModuleAwareClassDescriptor ? (ModuleAwareClassDescriptor) classDescriptor : null;
            if (moduleAwareClassDescriptor != null) {
                return moduleAwareClassDescriptor.getMemberScope(typeSubstitution5, kotlinTypeRefiner);
            }
            MemberScope3 memberScope = classDescriptor.getMemberScope(typeSubstitution5);
            Intrinsics3.checkNotNullExpressionValue(memberScope, "this.getMemberScope(\n                typeSubstitution\n            )");
            return memberScope;
        }

        public final MemberScope3 getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(ClassDescriptor classDescriptor, KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            ModuleAwareClassDescriptor moduleAwareClassDescriptor = classDescriptor instanceof ModuleAwareClassDescriptor ? (ModuleAwareClassDescriptor) classDescriptor : null;
            if (moduleAwareClassDescriptor != null) {
                return moduleAwareClassDescriptor.getUnsubstitutedMemberScope(kotlinTypeRefiner);
            }
            MemberScope3 unsubstitutedMemberScope = classDescriptor.getUnsubstitutedMemberScope();
            Intrinsics3.checkNotNullExpressionValue(unsubstitutedMemberScope, "this.unsubstitutedMemberScope");
            return unsubstitutedMemberScope;
        }
    }

    public abstract MemberScope3 getMemberScope(TypeSubstitution5 typeSubstitution5, KotlinTypeRefiner kotlinTypeRefiner);

    public abstract MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner);
}
