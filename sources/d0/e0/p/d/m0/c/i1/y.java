package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.m.f$m;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;

/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends k implements d0.e0.p.d.m0.c.c0 {
    public final d0.e0.p.d.m0.m.o l;
    public final d0.e0.p.d.m0.b.h m;
    public final Map<d0.e0.p.d.m0.c.b0<?>, Object> n;
    public w o;
    public d0.e0.p.d.m0.c.f0 p;
    public boolean q;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.c.j0> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f3278s;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.b.h hVar, d0.e0.p.d.m0.h.a aVar) {
        this(eVar, oVar, hVar, aVar, null, null, 48, null);
        d0.z.d.m.checkNotNullParameter(eVar, "moduleName");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
    }

    public /* synthetic */ y(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.b.h hVar, d0.e0.p.d.m0.h.a aVar, Map map, d0.e0.p.d.m0.g.e eVar2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, oVar, hVar, (i & 8) != 0 ? null : aVar, (i & 16) != 0 ? d0.t.h0.emptyMap() : map, (i & 32) != 0 ? null : eVar2);
    }

    public static final /* synthetic */ w access$getDependencies$p(y yVar) {
        return yVar.o;
    }

    public static final /* synthetic */ String access$getId(y yVar) {
        return yVar.b();
    }

    public static final /* synthetic */ d0.e0.p.d.m0.c.f0 access$getPackageFragmentProviderForModuleContent$p(y yVar) {
        return yVar.p;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.o access$getStorageManager$p(y yVar) {
        return yVar.l;
    }

    public static final boolean access$isInitialized(y yVar) {
        return yVar.p != null;
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        return (R) d0.e0.p.d.m0.c.c0$a.accept(this, oVar, d);
    }

    public void assertValid() {
        if (!isValid()) {
            throw new InvalidModuleException(d0.z.d.m.stringPlus("Accessing invalid module descriptor ", this));
        }
    }

    public final String b() {
        String string = getName().toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "name.toString()");
        return string;
    }

    @Override // d0.e0.p.d.m0.c.c0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.c.c0
    public <T> T getCapability(d0.e0.p.d.m0.c.b0<T> b0Var) {
        d0.z.d.m.checkNotNullParameter(b0Var, "capability");
        return (T) this.n.get(b0Var);
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return d0.e0.p.d.m0.c.c0$a.getContainingDeclaration(this);
    }

    @Override // d0.e0.p.d.m0.c.c0
    public List<d0.e0.p.d.m0.c.c0> getExpectedByModules() {
        w wVar = this.o;
        if (wVar != null) {
            return wVar.getDirectExpectedByDependencies();
        }
        StringBuilder sbU = b.d.b.a.a.U("Dependencies of module ");
        sbU.append(b());
        sbU.append(" were not set");
        throw new AssertionError(sbU.toString());
    }

    @Override // d0.e0.p.d.m0.c.c0
    public d0.e0.p.d.m0.c.j0 getPackage(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        assertValid();
        return (d0.e0.p.d.m0.c.j0) ((f$m) this.r).invoke(bVar);
    }

    public final d0.e0.p.d.m0.c.f0 getPackageFragmentProvider() {
        assertValid();
        return (j) this.f3278s.getValue();
    }

    @Override // d0.e0.p.d.m0.c.c0
    public Collection<d0.e0.p.d.m0.g.b> getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(bVar, function1);
    }

    public final void initialize(d0.e0.p.d.m0.c.f0 f0Var) {
        d0.z.d.m.checkNotNullParameter(f0Var, "providerForModuleContent");
        this.p = f0Var;
    }

    public boolean isValid() {
        return this.q;
    }

    public final void setDependencies(w wVar) {
        d0.z.d.m.checkNotNullParameter(wVar, "dependencies");
        w wVar2 = this.o;
        this.o = wVar;
    }

    @Override // d0.e0.p.d.m0.c.c0
    public boolean shouldSeeInternalsOf(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "targetModule");
        if (d0.z.d.m.areEqual(this, c0Var)) {
            return true;
        }
        w wVar = this.o;
        d0.z.d.m.checkNotNull(wVar);
        return d0.t.u.contains(wVar.getModulesWhoseInternalsAreVisible(), c0Var) || getExpectedByModules().contains(c0Var) || c0Var.getExpectedByModules().contains(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.b.h hVar, d0.e0.p.d.m0.h.a aVar, Map<d0.e0.p.d.m0.c.b0<?>, ? extends Object> map, d0.e0.p.d.m0.g.e eVar2) {
        super(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), eVar);
        d0.z.d.m.checkNotNullParameter(eVar, "moduleName");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
        d0.z.d.m.checkNotNullParameter(map, "capabilities");
        this.l = oVar;
        this.m = hVar;
        if (eVar.isSpecial()) {
            Map<d0.e0.p.d.m0.c.b0<?>, Object> mutableMap = d0.t.h0.toMutableMap(map);
            this.n = mutableMap;
            mutableMap.put(d0.e0.p.d.m0.n.l1.h.getREFINER_CAPABILITY(), new d0.e0.p.d.m0.n.l1.o(null));
            this.q = true;
            this.r = oVar.createMemoizedFunction(new y$b(this));
            this.f3278s = d0.g.lazy(new y$a(this));
            return;
        }
        throw new IllegalArgumentException(d0.z.d.m.stringPlus("Module name must be special: ", eVar));
    }

    public final void setDependencies(y... yVarArr) {
        d0.z.d.m.checkNotNullParameter(yVarArr, "descriptors");
        setDependencies(d0.t.k.toList(yVarArr));
    }

    public final void setDependencies(List<y> list) {
        d0.z.d.m.checkNotNullParameter(list, "descriptors");
        setDependencies(list, d0.t.n0.emptySet());
    }

    public final void setDependencies(List<y> list, Set<y> set) {
        d0.z.d.m.checkNotNullParameter(list, "descriptors");
        d0.z.d.m.checkNotNullParameter(set, "friends");
        setDependencies(new x(list, set, d0.t.n.emptyList(), d0.t.n0.emptySet()));
    }
}
