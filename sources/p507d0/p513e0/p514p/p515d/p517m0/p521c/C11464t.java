package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11332e1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.InterfaceC11378i0;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11780d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11781e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11782f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12001r;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12025g;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12033a;
import p507d0.p580t.C12148n0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.t */
/* JADX INFO: compiled from: DescriptorVisibilities.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11464t {

    /* JADX INFO: renamed from: a */
    public static final AbstractC11466u f23083a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC11466u f23084b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC11466u f23085c;

    /* JADX INFO: renamed from: d */
    public static final AbstractC11466u f23086d;

    /* JADX INFO: renamed from: e */
    public static final AbstractC11466u f23087e;

    /* JADX INFO: renamed from: f */
    public static final AbstractC11466u f23088f;

    /* JADX INFO: renamed from: g */
    public static final AbstractC11466u f23089g;

    /* JADX INFO: renamed from: h */
    public static final AbstractC11466u f23090h;

    /* JADX INFO: renamed from: i */
    public static final AbstractC11466u f23091i;

    /* JADX INFO: renamed from: j */
    public static final Map<AbstractC11466u, Integer> f23092j;

    /* JADX INFO: renamed from: k */
    public static final AbstractC11466u f23093k;

    /* JADX INFO: renamed from: l */
    public static final InterfaceC11780d f23094l;

    /* JADX INFO: renamed from: m */
    public static final InterfaceC11780d f23095m;

    /* JADX INFO: renamed from: n */
    @Deprecated
    public static final InterfaceC11780d f23096n;

    /* JADX INFO: renamed from: o */
    public static final InterfaceC12025g f23097o;

    /* JADX INFO: renamed from: p */
    public static final Map<AbstractC11335f1, AbstractC11466u> f23098p;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$a */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class a implements InterfaceC11780d {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11780d
        public AbstractC11913c0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$b */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class b implements InterfaceC11780d {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11780d
        public AbstractC11913c0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$c */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class c implements InterfaceC11780d {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11780d
        public AbstractC11913c0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$d */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class d extends AbstractC11460r {
        public d(AbstractC11335f1 abstractC11335f1) {
            super(abstractC11335f1);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9439a(int i) {
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
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
        public boolean isVisible(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
            if (interfaceC11458q == 0) {
                m9439a(1);
                throw null;
            }
            if (interfaceC11450m == null) {
                m9439a(2);
                throw null;
            }
            if (C11787e.isTopLevelDeclaration(interfaceC11458q)) {
                if (interfaceC11450m == null) {
                    m9439a(0);
                    throw null;
                }
                if (C11787e.getContainingSourceFile(interfaceC11450m) != InterfaceC11469v0.f23100a) {
                    return C11464t.inSameFile(interfaceC11458q, interfaceC11450m);
                }
            }
            if (interfaceC11458q instanceof InterfaceC11448l) {
                InterfaceC11359i containingDeclaration = ((InterfaceC11448l) interfaceC11458q).getContainingDeclaration();
                if (C11787e.isSealedClass(containingDeclaration) && C11787e.isTopLevelDeclaration(containingDeclaration) && (interfaceC11450m instanceof InterfaceC11448l) && C11787e.isTopLevelDeclaration(interfaceC11450m.getContainingDeclaration()) && C11464t.inSameFile(interfaceC11458q, interfaceC11450m)) {
                    return true;
                }
            }
            while (interfaceC11458q != 0) {
                interfaceC11458q = interfaceC11458q.getContainingDeclaration();
                if (((interfaceC11458q instanceof InterfaceC11330e) && !C11787e.isCompanionObject(interfaceC11458q)) || (interfaceC11458q instanceof InterfaceC11331e0)) {
                    break;
                }
            }
            if (interfaceC11458q == 0) {
                return false;
            }
            while (interfaceC11450m != null) {
                if (interfaceC11458q == interfaceC11450m) {
                    return true;
                }
                if (interfaceC11450m instanceof InterfaceC11331e0) {
                    return (interfaceC11458q instanceof InterfaceC11331e0) && ((InterfaceC11331e0) interfaceC11458q).getFqName().equals(((InterfaceC11331e0) interfaceC11450m).getFqName()) && C11787e.areInSameModule(interfaceC11450m, interfaceC11458q);
                }
                interfaceC11450m = interfaceC11450m.getContainingDeclaration();
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$e */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class e extends AbstractC11460r {
        public e(AbstractC11335f1 abstractC11335f1) {
            super(abstractC11335f1);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9440a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
        public boolean isVisible(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
            InterfaceC11450m parentOfType;
            if (interfaceC11458q == null) {
                m9440a(0);
                throw null;
            }
            if (interfaceC11450m == null) {
                m9440a(1);
                throw null;
            }
            if (C11464t.f23083a.isVisible(interfaceC11780d, interfaceC11458q, interfaceC11450m)) {
                if (interfaceC11780d == C11464t.f23095m) {
                    return true;
                }
                if (interfaceC11780d != C11464t.f23094l && (parentOfType = C11787e.getParentOfType(interfaceC11458q, InterfaceC11330e.class)) != null && (interfaceC11780d instanceof InterfaceC11782f)) {
                    return ((InterfaceC11782f) interfaceC11780d).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$f */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class f extends AbstractC11460r {
        public f(AbstractC11335f1 abstractC11335f1) {
            super(abstractC11335f1);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9441a(int i) {
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
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
        public boolean isVisible(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
            InterfaceC11330e interfaceC11330e;
            boolean z2 = false;
            if (interfaceC11458q == null) {
                m9441a(0);
                throw null;
            }
            if (interfaceC11450m == null) {
                m9441a(1);
                throw null;
            }
            InterfaceC11330e interfaceC11330e2 = (InterfaceC11330e) C11787e.getParentOfType(interfaceC11458q, InterfaceC11330e.class);
            InterfaceC11330e interfaceC11330e3 = (InterfaceC11330e) C11787e.getParentOfType(interfaceC11450m, InterfaceC11330e.class, false);
            if (interfaceC11330e3 == null) {
                return false;
            }
            if (interfaceC11330e2 != null && C11787e.isCompanionObject(interfaceC11330e2) && (interfaceC11330e = (InterfaceC11330e) C11787e.getParentOfType(interfaceC11330e2, InterfaceC11330e.class)) != null && C11787e.isSubclass(interfaceC11330e3, interfaceC11330e)) {
                return true;
            }
            InterfaceC11458q interfaceC11458qUnwrapFakeOverrideToAnyDeclaration = C11787e.unwrapFakeOverrideToAnyDeclaration(interfaceC11458q);
            InterfaceC11330e interfaceC11330e4 = (InterfaceC11330e) C11787e.getParentOfType(interfaceC11458qUnwrapFakeOverrideToAnyDeclaration, InterfaceC11330e.class);
            if (interfaceC11330e4 == null) {
                return false;
            }
            if (C11787e.isSubclass(interfaceC11330e3, interfaceC11330e4)) {
                if (interfaceC11458qUnwrapFakeOverrideToAnyDeclaration == null) {
                    m9441a(2);
                    throw null;
                }
                if (interfaceC11780d != C11464t.f23096n) {
                    if (!(interfaceC11458qUnwrapFakeOverrideToAnyDeclaration instanceof InterfaceC11321b) || (interfaceC11458qUnwrapFakeOverrideToAnyDeclaration instanceof InterfaceC11448l) || interfaceC11780d == C11464t.f23095m) {
                        z2 = true;
                    } else if (interfaceC11780d != C11464t.f23094l && interfaceC11780d != null) {
                        AbstractC11913c0 thisType = interfaceC11780d instanceof InterfaceC11781e ? ((InterfaceC11781e) interfaceC11780d).getThisType() : interfaceC11780d.getType();
                        if (C11787e.isSubtypeOfClass(thisType, interfaceC11330e3) || C12001r.isDynamic(thisType)) {
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    return true;
                }
            }
            return isVisible(interfaceC11780d, interfaceC11458q, interfaceC11330e3.getContainingDeclaration());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$g */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class g extends AbstractC11460r {
        public g(AbstractC11335f1 abstractC11335f1) {
            super(abstractC11335f1);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9442a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
        public boolean isVisible(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
            if (interfaceC11458q == null) {
                m9442a(0);
                throw null;
            }
            if (interfaceC11450m == null) {
                m9442a(1);
                throw null;
            }
            if (C11787e.getContainingModule(interfaceC11450m).shouldSeeInternalsOf(C11787e.getContainingModule(interfaceC11458q))) {
                return C11464t.f23097o.isInFriendModule(interfaceC11458q, interfaceC11450m);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$h */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class h extends AbstractC11460r {
        public h(AbstractC11335f1 abstractC11335f1) {
            super(abstractC11335f1);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9443a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
        public boolean isVisible(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
            if (interfaceC11458q == null) {
                m9443a(0);
                throw null;
            }
            if (interfaceC11450m != null) {
                return true;
            }
            m9443a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$i */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class i extends AbstractC11460r {
        public i(AbstractC11335f1 abstractC11335f1) {
            super(abstractC11335f1);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9444a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
        public boolean isVisible(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
            if (interfaceC11458q == null) {
                m9444a(0);
                throw null;
            }
            if (interfaceC11450m != null) {
                throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            }
            m9444a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$j */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class j extends AbstractC11460r {
        public j(AbstractC11335f1 abstractC11335f1) {
            super(abstractC11335f1);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9445a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
        public boolean isVisible(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
            if (interfaceC11458q == null) {
                m9445a(0);
                throw null;
            }
            if (interfaceC11450m != null) {
                throw new IllegalStateException("Visibility is unknown yet");
            }
            m9445a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$k */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class k extends AbstractC11460r {
        public k(AbstractC11335f1 abstractC11335f1) {
            super(abstractC11335f1);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9446a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
        public boolean isVisible(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
            if (interfaceC11458q == null) {
                m9446a(0);
                throw null;
            }
            if (interfaceC11450m != null) {
                return false;
            }
            m9446a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.t$l */
    /* JADX INFO: compiled from: DescriptorVisibilities.java */
    public static class l extends AbstractC11460r {
        public l(AbstractC11335f1 abstractC11335f1) {
            super(abstractC11335f1);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9447a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u
        public boolean isVisible(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
            if (interfaceC11458q == null) {
                m9447a(0);
                throw null;
            }
            if (interfaceC11450m != null) {
                return false;
            }
            m9447a(1);
            throw null;
        }
    }

    static {
        d dVar = new d(C11332e1.e.f22700c);
        f23083a = dVar;
        e eVar = new e(C11332e1.f.f22701c);
        f23084b = eVar;
        f fVar = new f(C11332e1.g.f22702c);
        f23085c = fVar;
        g gVar = new g(C11332e1.b.f22697c);
        f23086d = gVar;
        h hVar = new h(C11332e1.h.f22703c);
        f23087e = hVar;
        i iVar = new i(C11332e1.d.f22699c);
        f23088f = iVar;
        j jVar = new j(C11332e1.a.f22696c);
        f23089g = jVar;
        k kVar = new k(C11332e1.c.f22698c);
        f23090h = kVar;
        l lVar = new l(C11332e1.i.f22704c);
        f23091i = lVar;
        Collections.unmodifiableSet(C12148n0.setOf((Object[]) new AbstractC11466u[]{dVar, eVar, gVar, iVar}));
        HashMap mapNewHashMapWithExpectedSize = C12033a.newHashMapWithExpectedSize(4);
        mapNewHashMapWithExpectedSize.put(eVar, 0);
        mapNewHashMapWithExpectedSize.put(dVar, 0);
        mapNewHashMapWithExpectedSize.put(gVar, 1);
        mapNewHashMapWithExpectedSize.put(fVar, 1);
        mapNewHashMapWithExpectedSize.put(hVar, 2);
        f23092j = Collections.unmodifiableMap(mapNewHashMapWithExpectedSize);
        f23093k = hVar;
        f23094l = new a();
        f23095m = new b();
        f23096n = new c();
        Iterator it = ServiceLoader.load(InterfaceC12025g.class, InterfaceC12025g.class.getClassLoader()).iterator();
        f23097o = it.hasNext() ? (InterfaceC12025g) it.next() : InterfaceC12025g.a.f24915a;
        f23098p = new HashMap();
        m9438b(dVar);
        m9438b(eVar);
        m9438b(fVar);
        m9438b(gVar);
        m9438b(hVar);
        m9438b(iVar);
        m9438b(jVar);
        m9438b(kVar);
        m9438b(lVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003a  */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9437a(int i2) {
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

    /* JADX INFO: renamed from: b */
    public static void m9438b(AbstractC11466u abstractC11466u) {
        f23098p.put(abstractC11466u.getDelegate(), abstractC11466u);
    }

    public static Integer compare(AbstractC11466u abstractC11466u, AbstractC11466u abstractC11466u2) {
        if (abstractC11466u == null) {
            m9437a(12);
            throw null;
        }
        if (abstractC11466u2 == null) {
            m9437a(13);
            throw null;
        }
        Integer numCompareTo = abstractC11466u.compareTo(abstractC11466u2);
        if (numCompareTo != null) {
            return numCompareTo;
        }
        Integer numCompareTo2 = abstractC11466u2.compareTo(abstractC11466u);
        if (numCompareTo2 != null) {
            return Integer.valueOf(-numCompareTo2.intValue());
        }
        return null;
    }

    public static InterfaceC11458q findInvisibleMember(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
        InterfaceC11458q interfaceC11458qFindInvisibleMember;
        if (interfaceC11458q == null) {
            m9437a(8);
            throw null;
        }
        if (interfaceC11450m == null) {
            m9437a(9);
            throw null;
        }
        for (InterfaceC11458q interfaceC11458q2 = (InterfaceC11458q) interfaceC11458q.getOriginal(); interfaceC11458q2 != null && interfaceC11458q2.getVisibility() != f23088f; interfaceC11458q2 = (InterfaceC11458q) C11787e.getParentOfType(interfaceC11458q2, InterfaceC11458q.class)) {
            if (!interfaceC11458q2.getVisibility().isVisible(interfaceC11780d, interfaceC11458q2, interfaceC11450m)) {
                return interfaceC11458q2;
            }
        }
        if (!(interfaceC11458q instanceof InterfaceC11378i0) || (interfaceC11458qFindInvisibleMember = findInvisibleMember(interfaceC11780d, ((InterfaceC11378i0) interfaceC11458q).getUnderlyingConstructorDescriptor(), interfaceC11450m)) == null) {
            return null;
        }
        return interfaceC11458qFindInvisibleMember;
    }

    public static boolean inSameFile(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2) {
        if (interfaceC11450m == null) {
            m9437a(6);
            throw null;
        }
        if (interfaceC11450m2 == null) {
            m9437a(7);
            throw null;
        }
        InterfaceC11469v0 containingSourceFile = C11787e.getContainingSourceFile(interfaceC11450m2);
        if (containingSourceFile != InterfaceC11469v0.f23100a) {
            return containingSourceFile.equals(C11787e.getContainingSourceFile(interfaceC11450m));
        }
        return false;
    }

    public static boolean isPrivate(AbstractC11466u abstractC11466u) {
        if (abstractC11466u != null) {
            return abstractC11466u == f23083a || abstractC11466u == f23084b;
        }
        m9437a(14);
        throw null;
    }

    public static boolean isVisibleIgnoringReceiver(InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m) {
        if (interfaceC11458q == null) {
            m9437a(2);
            throw null;
        }
        if (interfaceC11450m != null) {
            return findInvisibleMember(f23095m, interfaceC11458q, interfaceC11450m) == null;
        }
        m9437a(3);
        throw null;
    }

    public static AbstractC11466u toDescriptorVisibility(AbstractC11335f1 abstractC11335f1) {
        if (abstractC11335f1 == null) {
            m9437a(15);
            throw null;
        }
        AbstractC11466u abstractC11466u = f23098p.get(abstractC11335f1);
        if (abstractC11466u != null) {
            return abstractC11466u;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + abstractC11335f1);
    }
}
