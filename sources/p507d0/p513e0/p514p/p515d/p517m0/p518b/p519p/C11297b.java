package p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11470w;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11473x0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11361a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11382k0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11909b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12016y0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.b */
/* JADX INFO: compiled from: FunctionClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11297b extends AbstractC11361a {

    /* JADX INFO: renamed from: o */
    public static final C11712a f22591o;

    /* JADX INFO: renamed from: p */
    public static final C11712a f22592p;

    /* JADX INFO: renamed from: q */
    public final InterfaceC11905o f22593q;

    /* JADX INFO: renamed from: r */
    public final InterfaceC11331e0 f22594r;

    /* JADX INFO: renamed from: s */
    public final EnumC11298c f22595s;

    /* JADX INFO: renamed from: t */
    public final int f22596t;

    /* JADX INFO: renamed from: u */
    public final b f22597u;

    /* JADX INFO: renamed from: v */
    public final C11299d f22598v;

    /* JADX INFO: renamed from: w */
    public final List<InterfaceC11477z0> f22599w;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.b$a */
    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f22591o = new C11712a(C11291k.f22499l, C11716e.identifier("Function"));
        f22592p = new C11712a(C11291k.f22496i, C11716e.identifier("KFunction"));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11297b(InterfaceC11905o interfaceC11905o, InterfaceC11331e0 interfaceC11331e0, EnumC11298c enumC11298c, int i) {
        super(interfaceC11905o, enumC11298c.numberedClassName(i));
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11331e0, "containingDeclaration");
        C12238m.checkNotNullParameter(enumC11298c, "functionKind");
        this.f22593q = interfaceC11905o;
        this.f22594r = interfaceC11331e0;
        this.f22595s = enumC11298c;
        this.f22596t = i;
        this.f22597u = new b(this);
        this.f22598v = new C11299d(interfaceC11905o, this);
        ArrayList arrayList = new ArrayList();
        IntRange intRange = new IntRange(1, i);
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            m9369b(arrayList, this, EnumC11935j1.IN_VARIANCE, C12238m.stringPlus("P", Integer.valueOf(((AbstractC12126c0) it).nextInt())));
            arrayList2.add(Unit.f27425a);
        }
        m9369b(arrayList, this, EnumC11935j1.OUT_VARIANCE, "R");
        this.f22599w = C12163u.toList(arrayList);
    }

    /* JADX INFO: renamed from: b */
    public static final void m9369b(ArrayList<InterfaceC11477z0> arrayList, C11297b c11297b, EnumC11935j1 enumC11935j1, String str) {
        arrayList.add(C11382k0.createWithDefaultBound(c11297b, InterfaceC11344g.f22735f.getEMPTY(), false, enumC11935j1, C11716e.identifier(str), arrayList.size(), c11297b.f22593q));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return InterfaceC11344g.f22735f.getEMPTY();
    }

    public final int getArity() {
        return this.f22596t;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public /* bridge */ /* synthetic */ InterfaceC11330e getCompanionObjectDescriptor() {
        return (InterfaceC11330e) m11459getCompanionObjectDescriptor();
    }

    /* JADX INFO: renamed from: getCompanionObjectDescriptor, reason: collision with other method in class */
    public Void m11459getCompanionObjectDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
    public List<InterfaceC11477z0> getDeclaredTypeParameters() {
        return this.f22599w;
    }

    public final EnumC11298c getFunctionKind() {
        return this.f22595s;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public EnumC11333f getKind() {
        return EnumC11333f.INTERFACE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public EnumC11476z getModality() {
        return EnumC11476z.ABSTRACT;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11456p
    public InterfaceC11467u0 getSource() {
        InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
        C12238m.checkNotNullExpressionValue(interfaceC11467u0, "NO_SOURCE");
        return interfaceC11467u0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public InterfaceC12008u0 getTypeConstructor() {
        return this.f22597u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11395u
    public InterfaceC11770i getUnsubstitutedMemberScope(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return this.f22598v;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public /* bridge */ /* synthetic */ InterfaceC11327d getUnsubstitutedPrimaryConstructor() {
        return (InterfaceC11327d) m11460getUnsubstitutedPrimaryConstructor();
    }

    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor, reason: collision with other method in class */
    public Void m11460getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public AbstractC11466u getVisibility() {
        AbstractC11466u abstractC11466u = C11464t.f23087e;
        C12238m.checkNotNullExpressionValue(abstractC11466u, "PUBLIC");
        return abstractC11466u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isActual() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isCompanionObject() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isData() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExpect() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExternal() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isFun() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isInline() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
    public boolean isInner() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public boolean isValue() {
        return false;
    }

    public String toString() {
        String strAsString = getName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "name.asString()");
        return strAsString;
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.b$b */
    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    public final class b extends AbstractC11909b {

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ C11297b f22600c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11297b c11297b) {
            super(c11297b.f22593q);
            C12238m.checkNotNullParameter(c11297b, "this$0");
            this.f22600c = c11297b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
        /* JADX INFO: renamed from: a */
        public Collection<AbstractC11913c0> mo9370a() {
            List<C11712a> listListOf;
            int iOrdinal = this.f22600c.getFunctionKind().ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                listListOf = C12145m.listOf(C11297b.f22591o);
            } else if (iOrdinal == 2) {
                listListOf = C12147n.listOf((Object[]) new C11712a[]{C11297b.f22592p, new C11712a(C11291k.f22499l, EnumC11298c.f22602k.numberedClassName(this.f22600c.getArity()))});
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                listListOf = C12147n.listOf((Object[]) new C11712a[]{C11297b.f22592p, new C11712a(C11291k.f22491d, EnumC11298c.f22603l.numberedClassName(this.f22600c.getArity()))});
            }
            InterfaceC11325c0 containingDeclaration = this.f22600c.f22594r.getContainingDeclaration();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listListOf, 10));
            for (C11712a c11712a : listListOf) {
                InterfaceC11330e interfaceC11330eFindClassAcrossModuleDependencies = C11470w.findClassAcrossModuleDependencies(containingDeclaration, c11712a);
                if (interfaceC11330eFindClassAcrossModuleDependencies == null) {
                    throw new IllegalStateException(("Built-in class " + c11712a + " not found").toString());
                }
                List listTakeLast = C12163u.takeLast(getParameters(), interfaceC11330eFindClassAcrossModuleDependencies.getTypeConstructor().getParameters().size());
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(listTakeLast, 10));
                Iterator it = listTakeLast.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new C12016y0(((InterfaceC11477z0) it.next()).getDefaultType()));
                }
                C11916d0 c11916d0 = C11916d0.f24748a;
                arrayList.add(C11916d0.simpleNotNullType(InterfaceC11344g.f22735f.getEMPTY(), interfaceC11330eFindClassAcrossModuleDependencies, arrayList2));
            }
            return C12163u.toList(arrayList);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
        /* JADX INFO: renamed from: d */
        public InterfaceC11473x0 mo9371d() {
            return InterfaceC11473x0.a.f23103a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public List<InterfaceC11477z0> getParameters() {
            return this.f22600c.f22599w;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            return getDeclarationDescriptor().toString();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g, p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public C11297b getDeclarationDescriptor() {
            return this.f22600c;
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public List<InterfaceC11327d> getConstructors() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11452n, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11331e0 getContainingDeclaration() {
        return this.f22594r;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public List<InterfaceC11330e> getSealedSubclasses() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
    public InterfaceC11770i.b getStaticScope() {
        return InterfaceC11770i.b.f24373b;
    }
}
