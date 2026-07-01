package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.t.ReversedViews3;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.b, reason: use source file name */
/* JADX INFO: compiled from: ClassifierNamePolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ClassifierNamePolicy {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.b$a */
    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class a implements ClassifierNamePolicy {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.j.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer2 descriptorRenderer2) {
            Intrinsics3.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics3.checkNotNullExpressionValue(name, "classifier.name");
                return descriptorRenderer2.renderName(name, false);
            }
            FqNameUnsafe fqName = DescriptorUtils.getFqName(classifierDescriptor);
            Intrinsics3.checkNotNullExpressionValue(fqName, "getFqName(classifier)");
            return descriptorRenderer2.renderFqName(fqName);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.b$b */
    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class b implements ClassifierNamePolicy {
        public static final b a = new b();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [d0.e0.p.d.m0.c.h, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1, types: [d0.e0.p.d.m0.c.m] */
        /* JADX WARN: Type inference failed for: r2v2, types: [d0.e0.p.d.m0.c.m] */
        @Override // d0.e0.p.d.m0.j.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer2 descriptorRenderer2) {
            Intrinsics3.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics3.checkNotNullExpressionValue(name, "classifier.name");
                return descriptorRenderer2.renderName(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(classifierDescriptor.getName());
                classifierDescriptor = classifierDescriptor.getContainingDeclaration();
            } while (classifierDescriptor instanceof ClassDescriptor);
            return RenderingUtils.renderFqName(ReversedViews3.asReversedMutable(arrayList));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.b$c */
    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class c implements ClassifierNamePolicy {
        public static final c a = new c();

        public final String a(ClassifierDescriptor classifierDescriptor) {
            String strRender;
            Name name = classifierDescriptor.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "descriptor.name");
            String strRender2 = RenderingUtils.render(name);
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return strRender2;
            }
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                strRender = a((ClassifierDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof PackageFragmentDescriptor) {
                FqNameUnsafe unsafe = ((PackageFragmentDescriptor) containingDeclaration).getFqName().toUnsafe();
                Intrinsics3.checkNotNullExpressionValue(unsafe, "descriptor.fqName.toUnsafe()");
                strRender = RenderingUtils.render(unsafe);
            } else {
                strRender = null;
            }
            if (strRender == null || Intrinsics3.areEqual(strRender, "")) {
                return strRender2;
            }
            return ((Object) strRender) + '.' + strRender2;
        }

        @Override // d0.e0.p.d.m0.j.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer2 descriptorRenderer2) {
            Intrinsics3.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
            return a(classifierDescriptor);
        }
    }

    String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer2 descriptorRenderer2);
}
