package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.ResolutionScope;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a, reason: use source file name */
/* JADX INFO: compiled from: SealedClassInheritorsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SealedClassInheritorsProvider extends SealedClassInheritorsProvider2 {
    public static final SealedClassInheritorsProvider a = new SealedClassInheritorsProvider();

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(ClassDescriptor classDescriptor, LinkedHashSet<ClassDescriptor> linkedHashSet, MemberScope3 memberScope3, boolean z2) {
        for (DeclarationDescriptor declarationDescriptor : ResolutionScope.a.getContributedDescriptors$default(memberScope3, MemberScope2.o, null, 2, null)) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor;
                if (DescriptorUtils.isDirectSubclass(classDescriptor2, classDescriptor)) {
                    linkedHashSet.add(declarationDescriptor);
                }
                if (z2) {
                    MemberScope3 unsubstitutedInnerClassesScope = classDescriptor2.getUnsubstitutedInnerClassesScope();
                    Intrinsics3.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "descriptor.unsubstitutedInnerClassesScope");
                    a(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, z2);
                }
            }
        }
    }

    public Collection<ClassDescriptor> computeSealedSubclasses(ClassDescriptor classDescriptor, boolean z2) {
        DeclarationDescriptor next;
        DeclarationDescriptor containingDeclaration;
        Intrinsics3.checkNotNullParameter(classDescriptor, "sealedClass");
        if (classDescriptor.getModality() != Modality.SEALED) {
            return Collections2.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z2) {
            Iterator<DeclarationDescriptor> it = DescriptorUtils2.getParents(classDescriptor).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(next instanceof PackageFragmentDescriptor));
            containingDeclaration = next;
        } else {
            containingDeclaration = classDescriptor.getContainingDeclaration();
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            a(classDescriptor, linkedHashSet, ((PackageFragmentDescriptor) containingDeclaration).getMemberScope(), z2);
        }
        MemberScope3 unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
        Intrinsics3.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
        a(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, true);
        return linkedHashSet;
    }
}
