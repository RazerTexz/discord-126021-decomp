package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11322b0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p549h.C11720a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11898h;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11948h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11955o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.y */
/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11399y extends AbstractC11381k implements InterfaceC11325c0 {

    /* JADX INFO: renamed from: l */
    public final InterfaceC11905o f22990l;

    /* JADX INFO: renamed from: m */
    public final AbstractC11288h f22991m;

    /* JADX INFO: renamed from: n */
    public final Map<C11322b0<?>, Object> f22992n;

    /* JADX INFO: renamed from: o */
    public InterfaceC11397w f22993o;

    /* JADX INFO: renamed from: p */
    public InterfaceC11334f0 f22994p;

    /* JADX INFO: renamed from: q */
    public boolean f22995q;

    /* JADX INFO: renamed from: r */
    public final InterfaceC11898h<C11713b, InterfaceC11402j0> f22996r;

    /* JADX INFO: renamed from: s */
    public final Lazy f22997s;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.y$a */
    /* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
    public static final class a extends AbstractC12240o implements Function0<C11379j> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C11379j invoke() {
            InterfaceC11397w interfaceC11397w = C11399y.this.f22993o;
            C11399y c11399y = C11399y.this;
            if (interfaceC11397w == null) {
                StringBuilder sbM833U = C1643a.m833U("Dependencies of module ");
                sbM833U.append(c11399y.m9430b());
                sbM833U.append(" were not set before querying module content");
                throw new AssertionError(sbM833U.toString());
            }
            List<C11399y> allDependencies = interfaceC11397w.getAllDependencies();
            allDependencies.contains(C11399y.this);
            Iterator<T> it = allDependencies.iterator();
            while (it.hasNext()) {
                C11399y.access$isInitialized((C11399y) it.next());
            }
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(allDependencies, 10));
            Iterator<T> it2 = allDependencies.iterator();
            while (it2.hasNext()) {
                InterfaceC11334f0 interfaceC11334f0 = ((C11399y) it2.next()).f22994p;
                C12238m.checkNotNull(interfaceC11334f0);
                arrayList.add(interfaceC11334f0);
            }
            return new C11379j(arrayList);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.y$b */
    /* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
    public static final class b extends AbstractC12240o implements Function1<C11713b, InterfaceC11402j0> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11402j0 invoke(C11713b c11713b) {
            C12238m.checkNotNullParameter(c11713b, "fqName");
            C11399y c11399y = C11399y.this;
            return new C11393s(c11399y, c11713b, c11399y.f22990l);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11399y(C11716e c11716e, InterfaceC11905o interfaceC11905o, AbstractC11288h abstractC11288h, C11720a c11720a) {
        this(c11716e, interfaceC11905o, abstractC11288h, c11720a, null, null, 48, null);
        C12238m.checkNotNullParameter(c11716e, "moduleName");
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
    }

    public /* synthetic */ C11399y(C11716e c11716e, InterfaceC11905o interfaceC11905o, AbstractC11288h abstractC11288h, C11720a c11720a, Map map, C11716e c11716e2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c11716e, interfaceC11905o, abstractC11288h, (i & 8) != 0 ? null : c11720a, (i & 16) != 0 ? C12136h0.emptyMap() : map, (i & 32) != 0 ? null : c11716e2);
    }

    public static final boolean access$isInitialized(C11399y c11399y) {
        return c11399y.f22994p != null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        return (R) InterfaceC11325c0.a.accept(this, interfaceC11454o, d);
    }

    public void assertValid() {
        if (!isValid()) {
            throw new InvalidModuleException(C12238m.stringPlus("Accessing invalid module descriptor ", this));
        }
    }

    /* JADX INFO: renamed from: b */
    public final String m9430b() {
        String string = getName().toString();
        C12238m.checkNotNullExpressionValue(string, "name.toString()");
        return string;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
    public AbstractC11288h getBuiltIns() {
        return this.f22991m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
    public <T> T getCapability(C11322b0<T> c11322b0) {
        C12238m.checkNotNullParameter(c11322b0, "capability");
        return (T) this.f22992n.get(c11322b0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11450m getContainingDeclaration() {
        return InterfaceC11325c0.a.getContainingDeclaration(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
    public List<InterfaceC11325c0> getExpectedByModules() {
        InterfaceC11397w interfaceC11397w = this.f22993o;
        if (interfaceC11397w != null) {
            return interfaceC11397w.getDirectExpectedByDependencies();
        }
        StringBuilder sbM833U = C1643a.m833U("Dependencies of module ");
        sbM833U.append(m9430b());
        sbM833U.append(" were not set");
        throw new AssertionError(sbM833U.toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
    public InterfaceC11402j0 getPackage(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        assertValid();
        return (InterfaceC11402j0) ((C11896f.m) this.f22996r).invoke(c11713b);
    }

    public final InterfaceC11334f0 getPackageFragmentProvider() {
        assertValid();
        return (C11379j) this.f22997s.getValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
    public Collection<C11713b> getSubPackagesOf(C11713b c11713b, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(c11713b, function1);
    }

    public final void initialize(InterfaceC11334f0 interfaceC11334f0) {
        C12238m.checkNotNullParameter(interfaceC11334f0, "providerForModuleContent");
        this.f22994p = interfaceC11334f0;
    }

    public boolean isValid() {
        return this.f22995q;
    }

    public final void setDependencies(InterfaceC11397w interfaceC11397w) {
        C12238m.checkNotNullParameter(interfaceC11397w, "dependencies");
        InterfaceC11397w interfaceC11397w2 = this.f22993o;
        this.f22993o = interfaceC11397w;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
    public boolean shouldSeeInternalsOf(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "targetModule");
        if (C12238m.areEqual(this, interfaceC11325c0)) {
            return true;
        }
        InterfaceC11397w interfaceC11397w = this.f22993o;
        C12238m.checkNotNull(interfaceC11397w);
        return C12163u.contains(interfaceC11397w.getModulesWhoseInternalsAreVisible(), interfaceC11325c0) || getExpectedByModules().contains(interfaceC11325c0) || interfaceC11325c0.getExpectedByModules().contains(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11399y(C11716e c11716e, InterfaceC11905o interfaceC11905o, AbstractC11288h abstractC11288h, C11720a c11720a, Map<C11322b0<?>, ? extends Object> map, C11716e c11716e2) {
        super(InterfaceC11344g.f22735f.getEMPTY(), c11716e);
        C12238m.checkNotNullParameter(c11716e, "moduleName");
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
        C12238m.checkNotNullParameter(map, "capabilities");
        this.f22990l = interfaceC11905o;
        this.f22991m = abstractC11288h;
        if (c11716e.isSpecial()) {
            Map<C11322b0<?>, Object> mutableMap = C12136h0.toMutableMap(map);
            this.f22992n = mutableMap;
            mutableMap.put(C11948h.getREFINER_CAPABILITY(), new C11955o(null));
            this.f22995q = true;
            this.f22996r = interfaceC11905o.createMemoizedFunction(new b());
            this.f22997s = C12083g.lazy(new a());
            return;
        }
        throw new IllegalArgumentException(C12238m.stringPlus("Module name must be special: ", c11716e));
    }

    public final void setDependencies(C11399y... c11399yArr) {
        C12238m.checkNotNullParameter(c11399yArr, "descriptors");
        setDependencies(C12141k.toList(c11399yArr));
    }

    public final void setDependencies(List<C11399y> list) {
        C12238m.checkNotNullParameter(list, "descriptors");
        setDependencies(list, C12148n0.emptySet());
    }

    public final void setDependencies(List<C11399y> list, Set<C11399y> set) {
        C12238m.checkNotNullParameter(list, "descriptors");
        C12238m.checkNotNullParameter(set, "friends");
        setDependencies(new C11398x(list, set, C12147n.emptyList(), C12148n0.emptySet()));
    }
}
