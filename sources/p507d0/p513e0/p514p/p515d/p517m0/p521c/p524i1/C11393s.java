package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11353h0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11763b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11769h;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.s */
/* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11393s extends AbstractC11381k implements InterfaceC11402j0 {

    /* JADX INFO: renamed from: l */
    public static final /* synthetic */ KProperty<Object>[] f22975l = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11393s.class), "fragments", "getFragments()Ljava/util/List;"))};

    /* JADX INFO: renamed from: m */
    public final C11399y f22976m;

    /* JADX INFO: renamed from: n */
    public final C11713b f22977n;

    /* JADX INFO: renamed from: o */
    public final InterfaceC11900j f22978o;

    /* JADX INFO: renamed from: p */
    public final InterfaceC11770i f22979p;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.s$a */
    /* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
    public static final class a extends AbstractC12240o implements Function0<List<? extends InterfaceC11331e0>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends InterfaceC11331e0> invoke() {
            return C11353h0.packageFragments(C11393s.this.getModule().getPackageFragmentProvider(), C11393s.this.getFqName());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.s$b */
    /* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
    public static final class b extends AbstractC12240o implements Function0<InterfaceC11770i> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC11770i invoke() {
            if (C11393s.this.getFragments().isEmpty()) {
                return InterfaceC11770i.b.f24373b;
            }
            List<InterfaceC11331e0> fragments = C11393s.this.getFragments();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(fragments, 10));
            Iterator<T> it = fragments.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC11331e0) it.next()).getMemberScope());
            }
            List listPlus = C12163u.plus((Collection<? extends C11376h0>) arrayList, new C11376h0(C11393s.this.getModule(), C11393s.this.getFqName()));
            C11763b.a aVar = C11763b.f24333b;
            StringBuilder sbM833U = C1643a.m833U("package view scope for ");
            sbM833U.append(C11393s.this.getFqName());
            sbM833U.append(" in ");
            sbM833U.append(C11393s.this.getModule().getName());
            return aVar.create(sbM833U.toString(), listPlus);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11393s(C11399y c11399y, C11713b c11713b, InterfaceC11905o interfaceC11905o) {
        super(InterfaceC11344g.f22735f.getEMPTY(), c11713b.shortNameOrSpecial());
        C12238m.checkNotNullParameter(c11399y, "module");
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        this.f22976m = c11399y;
        this.f22977n = c11713b;
        this.f22978o = interfaceC11905o.createLazyValue(new a());
        this.f22979p = new C11769h(interfaceC11905o, new b());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        C12238m.checkNotNullParameter(interfaceC11454o, "visitor");
        return interfaceC11454o.visitPackageViewDescriptor(this, d);
    }

    public boolean equals(Object obj) {
        InterfaceC11402j0 interfaceC11402j0 = obj instanceof InterfaceC11402j0 ? (InterfaceC11402j0) obj : null;
        return interfaceC11402j0 != null && C12238m.areEqual(getFqName(), interfaceC11402j0.getFqName()) && C12238m.areEqual(getModule(), interfaceC11402j0.getModule());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0
    public C11713b getFqName() {
        return this.f22977n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0
    public List<InterfaceC11331e0> getFragments() {
        return (List) C11904n.getValue(this.f22978o, this, (KProperty<?>) f22975l[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0
    public InterfaceC11770i getMemberScope() {
        return this.f22979p;
    }

    public int hashCode() {
        return getFqName().hashCode() + (getModule().hashCode() * 31);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0
    public boolean isEmpty() {
        return InterfaceC11402j0.a.isEmpty(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11402j0 getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        C11399y module = getModule();
        C11713b c11713bParent = getFqName().parent();
        C12238m.checkNotNullExpressionValue(c11713bParent, "fqName.parent()");
        return module.getPackage(c11713bParent);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0
    public C11399y getModule() {
        return this.f22976m;
    }
}
