package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.g, reason: use source file name */
/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinTypeRefiner {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.g$a */
    /* JADX INFO: compiled from: KotlinTypeRefiner.kt */
    public static final class a extends KotlinTypeRefiner {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.n.l1.KotlinTypeRefiner
        public ClassDescriptor findClassAcrossModuleDependencies(ClassId classId) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            return null;
        }

        @Override // d0.e0.p.d.m0.n.l1.KotlinTypeRefiner
        public <S extends MemberScope3> S getOrPutScopeForClass(ClassDescriptor classDescriptor, Function0<? extends S> function0) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics3.checkNotNullParameter(function0, "compute");
            return function0.invoke();
        }

        @Override // d0.e0.p.d.m0.n.l1.KotlinTypeRefiner
        public boolean isRefinementNeededForModule(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
            return false;
        }

        @Override // d0.e0.p.d.m0.n.l1.KotlinTypeRefiner
        public boolean isRefinementNeededForTypeConstructor(TypeConstructor typeConstructor) {
            Intrinsics3.checkNotNullParameter(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // d0.e0.p.d.m0.n.l1.KotlinTypeRefiner
        public ClassDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor) {
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "descriptor");
            return null;
        }

        @Override // d0.e0.p.d.m0.n.l1.KotlinTypeRefiner
        public Collection<KotlinType> refineSupertypes(ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            Intrinsics3.checkNotNullExpressionValue(supertypes, "classDescriptor.typeConstructor.supertypes");
            return supertypes;
        }

        @Override // d0.e0.p.d.m0.n.l1.KotlinTypeRefiner
        public KotlinType refineType(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "type");
            return kotlinType;
        }
    }

    public abstract ClassDescriptor findClassAcrossModuleDependencies(ClassId classId);

    public abstract <S extends MemberScope3> S getOrPutScopeForClass(ClassDescriptor classDescriptor, Function0<? extends S> function0);

    public abstract boolean isRefinementNeededForModule(ModuleDescriptor2 moduleDescriptor2);

    public abstract boolean isRefinementNeededForTypeConstructor(TypeConstructor typeConstructor);

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor);

    public abstract Collection<KotlinType> refineSupertypes(ClassDescriptor classDescriptor);

    public abstract KotlinType refineType(KotlinType kotlinType);
}
