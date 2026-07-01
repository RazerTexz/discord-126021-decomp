package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.Visibility2;
import d0.e0.p.d.m0.c.j1.JavaVisibilities;
import d0.e0.p.d.m0.c.j1.JavaVisibilities2;
import d0.e0.p.d.m0.c.j1.JavaVisibilities3;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.a0.p.ReceiverValue;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.w, reason: use source file name */
/* JADX INFO: compiled from: JavaDescriptorVisibilities.java */
/* JADX INFO: loaded from: classes3.dex */
public class JavaDescriptorVisibilities {
    public static final DescriptorVisibility2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DescriptorVisibility2 f3359b;
    public static final DescriptorVisibility2 c;
    public static final Map<Visibility2, DescriptorVisibility2> d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.w$a */
    /* JADX INFO: compiled from: JavaDescriptorVisibilities.java */
    public static class a extends DescriptorVisibility {
        public a(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                return JavaDescriptorVisibilities.c(declarationDescriptorWithVisibility, declarationDescriptor);
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.w$b */
    /* JADX INFO: compiled from: JavaDescriptorVisibilities.java */
    public static class b extends DescriptorVisibility {
        public b(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                return JavaDescriptorVisibilities.b(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.w$c */
    /* JADX INFO: compiled from: JavaDescriptorVisibilities.java */
    public static class c extends DescriptorVisibility {
        public c(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            }
            if (declarationDescriptor != null) {
                return JavaDescriptorVisibilities.b(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            }
            a(1);
            throw null;
        }
    }

    static {
        a aVar = new a(JavaVisibilities.c);
        a = aVar;
        b bVar = new b(JavaVisibilities3.c);
        f3359b = bVar;
        c cVar = new c(JavaVisibilities2.c);
        c = cVar;
        d = new HashMap();
        d(aVar);
        d(bVar);
        d(cVar);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i != 5 && i != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            a(0);
            throw null;
        }
        if (declarationDescriptor == null) {
            a(1);
            throw null;
        }
        if (c(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility), declarationDescriptor)) {
            return true;
        }
        return DescriptorVisibilities.c.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
    }

    public static boolean c(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            a(2);
            throw null;
        }
        if (declarationDescriptor2 == null) {
            a(3);
            throw null;
        }
        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor2, PackageFragmentDescriptor.class, false);
        return (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || !packageFragmentDescriptor.getFqName().equals(packageFragmentDescriptor2.getFqName())) ? false : true;
    }

    public static void d(DescriptorVisibility2 descriptorVisibility2) {
        d.put(descriptorVisibility2.getDelegate(), descriptorVisibility2);
    }

    public static DescriptorVisibility2 toDescriptorVisibility(Visibility2 visibility2) {
        if (visibility2 == null) {
            a(4);
            throw null;
        }
        DescriptorVisibility2 descriptorVisibility2 = d.get(visibility2);
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        DescriptorVisibility2 descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(visibility2);
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        a(5);
        throw null;
    }
}
