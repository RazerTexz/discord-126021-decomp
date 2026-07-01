package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.c.Visibilities;
import d0.e0.p.d.m0.c.i1.TypeAliasConstructorDescriptor;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.a0.p.ImplicitClassReceiver2;
import d0.e0.p.d.m0.k.a0.p.ReceiverValue;
import d0.e0.p.d.m0.k.a0.p.SuperCallReceiverValue;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.dynamicTypes2;
import d0.e0.p.d.m0.o.ModuleVisibilityHelper;
import d0.e0.p.d.m0.p.collections;
import d0.t.Sets5;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.t, reason: use source file name */
/* JADX INFO: compiled from: DescriptorVisibilities.java */
/* JADX INFO: loaded from: classes3.dex */
public class DescriptorVisibilities {
    public static final DescriptorVisibility2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DescriptorVisibility2 f3300b;
    public static final DescriptorVisibility2 c;
    public static final DescriptorVisibility2 d;
    public static final DescriptorVisibility2 e;
    public static final DescriptorVisibility2 f;
    public static final DescriptorVisibility2 g;
    public static final DescriptorVisibility2 h;
    public static final DescriptorVisibility2 i;
    public static final Map<DescriptorVisibility2, Integer> j;
    public static final DescriptorVisibility2 k;
    public static final ReceiverValue l;
    public static final ReceiverValue m;

    @Deprecated
    public static final ReceiverValue n;
    public static final ModuleVisibilityHelper o;
    public static final Map<Visibility2, DescriptorVisibility2> p;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$a */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class a implements ReceiverValue {
        @Override // d0.e0.p.d.m0.k.a0.p.ReceiverValue
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$b */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class b implements ReceiverValue {
        @Override // d0.e0.p.d.m0.k.a0.p.ReceiverValue
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$c */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class c implements ReceiverValue {
        @Override // d0.e0.p.d.m0.k.a0.p.ReceiverValue
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$d */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class d extends DescriptorVisibility {
        public d(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "what";
            } else if (i != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i == 1 || i == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d0.e0.p.d.m0.c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == 0) {
                a(1);
                throw null;
            }
            if (declarationDescriptor == null) {
                a(2);
                throw null;
            }
            if (DescriptorUtils.isTopLevelDeclaration(declarationDescriptorWithVisibility)) {
                if (declarationDescriptor == null) {
                    a(0);
                    throw null;
                }
                if (DescriptorUtils.getContainingSourceFile(declarationDescriptor) != v0.a) {
                    return DescriptorVisibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor);
                }
            }
            if (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) {
                ClassifierDescriptorWithTypeParameters containingDeclaration = ((ConstructorDescriptor) declarationDescriptorWithVisibility).getContainingDeclaration();
                if (DescriptorUtils.isSealedClass(containingDeclaration) && DescriptorUtils.isTopLevelDeclaration(containingDeclaration) && (declarationDescriptor instanceof ConstructorDescriptor) && DescriptorUtils.isTopLevelDeclaration(declarationDescriptor.getContainingDeclaration()) && DescriptorVisibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor)) {
                    return true;
                }
            }
            while (declarationDescriptorWithVisibility != 0) {
                declarationDescriptorWithVisibility = declarationDescriptorWithVisibility.getContainingDeclaration();
                if (((declarationDescriptorWithVisibility instanceof ClassDescriptor) && !DescriptorUtils.isCompanionObject(declarationDescriptorWithVisibility)) || (declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor)) {
                    break;
                }
            }
            if (declarationDescriptorWithVisibility == 0) {
                return false;
            }
            while (declarationDescriptor != null) {
                if (declarationDescriptorWithVisibility == declarationDescriptor) {
                    return true;
                }
                if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                    return (declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) && ((PackageFragmentDescriptor) declarationDescriptorWithVisibility).getFqName().equals(((PackageFragmentDescriptor) declarationDescriptor).getFqName()) && DescriptorUtils.areInSameModule(declarationDescriptor, declarationDescriptorWithVisibility);
                }
                declarationDescriptor = declarationDescriptor.getContainingDeclaration();
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$e */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class e extends DescriptorVisibility {
        public e(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            DeclarationDescriptor parentOfType;
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            }
            if (declarationDescriptor == null) {
                a(1);
                throw null;
            }
            if (DescriptorVisibilities.a.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor)) {
                if (receiverValue == DescriptorVisibilities.m) {
                    return true;
                }
                if (receiverValue != DescriptorVisibilities.l && (parentOfType = DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class)) != null && (receiverValue instanceof ImplicitClassReceiver2)) {
                    return ((ImplicitClassReceiver2) receiverValue).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$f */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class f extends DescriptorVisibility {
        public f(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i == 2 || i == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Code duplicated, block: B:47:0x007b  */
        @Override // d0.e0.p.d.m0.c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            ClassDescriptor classDescriptor;
            boolean z2 = false;
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            }
            if (declarationDescriptor == null) {
                a(1);
                throw null;
            }
            ClassDescriptor classDescriptor2 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class);
            ClassDescriptor classDescriptor3 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, ClassDescriptor.class, false);
            if (classDescriptor3 == null) {
                return false;
            }
            if (classDescriptor2 != null && DescriptorUtils.isCompanionObject(classDescriptor2) && (classDescriptor = (ClassDescriptor) DescriptorUtils.getParentOfType(classDescriptor2, ClassDescriptor.class)) != null && DescriptorUtils.isSubclass(classDescriptor3, classDescriptor)) {
                return true;
            }
            DeclarationDescriptorWithVisibility declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration = DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility);
            ClassDescriptor classDescriptor4 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration, ClassDescriptor.class);
            if (classDescriptor4 == null) {
                return false;
            }
            if (DescriptorUtils.isSubclass(classDescriptor3, classDescriptor4)) {
                if (declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration == null) {
                    a(2);
                    throw null;
                }
                if (receiverValue != DescriptorVisibilities.n) {
                    if (!(declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration instanceof CallableMemberDescriptor) || (declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration instanceof ConstructorDescriptor) || receiverValue == DescriptorVisibilities.m) {
                        z2 = true;
                    } else if (receiverValue != DescriptorVisibilities.l && receiverValue != null) {
                        KotlinType thisType = receiverValue instanceof SuperCallReceiverValue ? ((SuperCallReceiverValue) receiverValue).getThisType() : receiverValue.getType();
                        if (DescriptorUtils.isSubtypeOfClass(thisType, classDescriptor3) || dynamicTypes2.isDynamic(thisType)) {
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    return true;
                }
            }
            return isVisible(receiverValue, declarationDescriptorWithVisibility, classDescriptor3.getContainingDeclaration());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$g */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class g extends DescriptorVisibility {
        public g(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.DescriptorVisibility2
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            }
            if (declarationDescriptor == null) {
                a(1);
                throw null;
            }
            if (DescriptorUtils.getContainingModule(declarationDescriptor).shouldSeeInternalsOf(DescriptorUtils.getContainingModule(declarationDescriptorWithVisibility))) {
                return DescriptorVisibilities.o.isInFriendModule(declarationDescriptorWithVisibility, declarationDescriptor);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$h */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class h extends DescriptorVisibility {
        public h(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
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
                return true;
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$i */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class i extends DescriptorVisibility {
        public i(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
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
                throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$j */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class j extends DescriptorVisibility {
        public j(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
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
                throw new IllegalStateException("Visibility is unknown yet");
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$k */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class k extends DescriptorVisibility {
        public k(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
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
                return false;
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$l */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class l extends DescriptorVisibility {
        public l(Visibility2 visibility2) {
            super(visibility2);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
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
                return false;
            }
            a(1);
            throw null;
        }
    }

    static {
        d dVar = new d(Visibilities.e.c);
        a = dVar;
        e eVar = new e(Visibilities.f.c);
        f3300b = eVar;
        f fVar = new f(Visibilities.g.c);
        c = fVar;
        g gVar = new g(Visibilities.b.c);
        d = gVar;
        h hVar = new h(Visibilities.h.c);
        e = hVar;
        i iVar = new i(Visibilities.d.c);
        f = iVar;
        j jVar = new j(Visibilities.a.c);
        g = jVar;
        k kVar = new k(Visibilities.c.c);
        h = kVar;
        l lVar = new l(Visibilities.i.c);
        i = lVar;
        Collections.unmodifiableSet(Sets5.setOf((Object[]) new DescriptorVisibility2[]{dVar, eVar, gVar, iVar}));
        HashMap mapNewHashMapWithExpectedSize = collections.newHashMapWithExpectedSize(4);
        mapNewHashMapWithExpectedSize.put(eVar, 0);
        mapNewHashMapWithExpectedSize.put(dVar, 0);
        mapNewHashMapWithExpectedSize.put(gVar, 1);
        mapNewHashMapWithExpectedSize.put(fVar, 1);
        mapNewHashMapWithExpectedSize.put(hVar, 2);
        j = Collections.unmodifiableMap(mapNewHashMapWithExpectedSize);
        k = hVar;
        l = new a();
        m = new b();
        n = new c();
        Iterator it = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        o = it.hasNext() ? (ModuleVisibilityHelper) it.next() : ModuleVisibilityHelper.a.a;
        p = new HashMap();
        b(dVar);
        b(eVar);
        b(fVar);
        b(gVar);
        b(hVar);
        b(iVar);
        b(jVar);
        b(kVar);
        b(lVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003a  */
    public static /* synthetic */ void a(int i2) {
        String str = i2 != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 16 ? 3 : 2];
        if (i2 != 1 && i2 != 3 && i2 != 5 && i2 != 7) {
            switch (i2) {
                case 9:
                    objArr[0] = "from";
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
        } else {
            objArr[0] = "from";
        }
        if (i2 != 16) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        } else {
            objArr[1] = "toDescriptorVisibility";
        }
        switch (i2) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 == 16) {
            throw new IllegalStateException(str2);
        }
    }

    public static void b(DescriptorVisibility2 descriptorVisibility2) {
        p.put(descriptorVisibility2.getDelegate(), descriptorVisibility2);
    }

    public static Integer compare(DescriptorVisibility2 descriptorVisibility2, DescriptorVisibility2 descriptorVisibility3) {
        if (descriptorVisibility2 == null) {
            a(12);
            throw null;
        }
        if (descriptorVisibility3 == null) {
            a(13);
            throw null;
        }
        Integer numCompareTo = descriptorVisibility2.compareTo(descriptorVisibility3);
        if (numCompareTo != null) {
            return numCompareTo;
        }
        Integer numCompareTo2 = descriptorVisibility3.compareTo(descriptorVisibility2);
        if (numCompareTo2 != null) {
            return Integer.valueOf(-numCompareTo2.intValue());
        }
        return null;
    }

    public static DeclarationDescriptorWithVisibility findInvisibleMember(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptorWithVisibility declarationDescriptorWithVisibilityFindInvisibleMember;
        if (declarationDescriptorWithVisibility == null) {
            a(8);
            throw null;
        }
        if (declarationDescriptor == null) {
            a(9);
            throw null;
        }
        for (DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.getOriginal(); declarationDescriptorWithVisibility2 != null && declarationDescriptorWithVisibility2.getVisibility() != f; declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility2, DeclarationDescriptorWithVisibility.class)) {
            if (!declarationDescriptorWithVisibility2.getVisibility().isVisible(receiverValue, declarationDescriptorWithVisibility2, declarationDescriptor)) {
                return declarationDescriptorWithVisibility2;
            }
        }
        if (!(declarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor) || (declarationDescriptorWithVisibilityFindInvisibleMember = findInvisibleMember(receiverValue, ((TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), declarationDescriptor)) == null) {
            return null;
        }
        return declarationDescriptorWithVisibilityFindInvisibleMember;
    }

    public static boolean inSameFile(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            a(6);
            throw null;
        }
        if (declarationDescriptor2 == null) {
            a(7);
            throw null;
        }
        v0 containingSourceFile = DescriptorUtils.getContainingSourceFile(declarationDescriptor2);
        if (containingSourceFile != v0.a) {
            return containingSourceFile.equals(DescriptorUtils.getContainingSourceFile(declarationDescriptor));
        }
        return false;
    }

    public static boolean isPrivate(DescriptorVisibility2 descriptorVisibility2) {
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2 == a || descriptorVisibility2 == f3300b;
        }
        a(14);
        throw null;
    }

    public static boolean isVisibleIgnoringReceiver(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            a(2);
            throw null;
        }
        if (declarationDescriptor != null) {
            return findInvisibleMember(m, declarationDescriptorWithVisibility, declarationDescriptor) == null;
        }
        a(3);
        throw null;
    }

    public static DescriptorVisibility2 toDescriptorVisibility(Visibility2 visibility2) {
        if (visibility2 == null) {
            a(15);
            throw null;
        }
        DescriptorVisibility2 descriptorVisibility2 = p.get(visibility2);
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + visibility2);
    }
}
