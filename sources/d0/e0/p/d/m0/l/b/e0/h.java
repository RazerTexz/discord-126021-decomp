package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.f.r;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends d0.e0.p.d.m0.k.a0.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3492b = {a0.property1(new y(a0.getOrCreateKotlinClass(h.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), a0.property1(new y(a0.getOrCreateKotlinClass(h.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    public final d0.e0.p.d.m0.l.b.l c;
    public final h$a d;
    public final d0.e0.p.d.m0.m.j e;
    public final d0.e0.p.d.m0.m.k f;

    public h(d0.e0.p.d.m0.l.b.l lVar, List<d0.e0.p.d.m0.f.i> list, List<d0.e0.p.d.m0.f.n> list2, List<r> list3, Function0<? extends Collection<d0.e0.p.d.m0.g.e>> function0) {
        d0.z.d.m.checkNotNullParameter(lVar, "c");
        d0.z.d.m.checkNotNullParameter(list, "functionList");
        d0.z.d.m.checkNotNullParameter(list2, "propertyList");
        d0.z.d.m.checkNotNullParameter(list3, "typeAliasList");
        d0.z.d.m.checkNotNullParameter(function0, "classNames");
        this.c = lVar;
        this.d = lVar.getComponents().getConfiguration().getPreserveDeclarationsOrdering() ? new h$b(this, list, list2, list3) : new h$c(this, list, list2, list3);
        this.e = lVar.getStorageManager().createLazyValue(new h$d(function0));
        this.f = lVar.getStorageManager().createNullableLazyValue(new h$e(this));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.l.b.l access$getC(h hVar) {
        return hVar.c;
    }

    public static final /* synthetic */ h$a access$getImpl$p(h hVar) {
        return hVar.d;
    }

    public abstract void a(Collection<d0.e0.p.d.m0.c.m> collection, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1);

    public final Collection<d0.e0.p.d.m0.c.m> b(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        ArrayList arrayList = new ArrayList(0);
        d0.e0.p.d.m0.k.a0.d$a d_a = d0.e0.p.d.m0.k.a0.d.a;
        if (dVar.acceptsKinds(d_a.getSINGLETON_CLASSIFIERS_MASK())) {
            a(arrayList, function1);
        }
        this.d.addFunctionsAndPropertiesTo(arrayList, dVar, function1, bVar);
        if (dVar.acceptsKinds(d_a.getCLASSIFIERS_MASK())) {
            for (d0.e0.p.d.m0.g.e eVar : getClassNames$deserialization()) {
                if (function1.invoke(eVar).booleanValue()) {
                    d0.e0.p.d.m0.p.a.addIfNotNull(arrayList, this.c.getComponents().deserializeClass(e(eVar)));
                }
            }
        }
        if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getTYPE_ALIASES_MASK())) {
            for (d0.e0.p.d.m0.g.e eVar2 : this.d.getTypeAliasNames()) {
                if (function1.invoke(eVar2).booleanValue()) {
                    d0.e0.p.d.m0.p.a.addIfNotNull(arrayList, this.d.getTypeAliasByName(eVar2));
                }
            }
        }
        return d0.e0.p.d.m0.p.a.compact(arrayList);
    }

    public void c(d0.e0.p.d.m0.g.e eVar, List<t0> list) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(list, "functions");
    }

    public void d(d0.e0.p.d.m0.g.e eVar, List<n0> list) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(list, "descriptors");
    }

    public abstract d0.e0.p.d.m0.g.a e(d0.e0.p.d.m0.g.e eVar);

    public abstract Set<d0.e0.p.d.m0.g.e> f();

    public abstract Set<d0.e0.p.d.m0.g.e> g();

    public final Set<d0.e0.p.d.m0.g.e> getClassNames$deserialization() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.e, this, (KProperty<?>) f3492b[0]);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.f, this, (KProperty<?>) f3492b[1]);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        if (i(eVar)) {
            return this.c.getComponents().deserializeClass(e(eVar));
        }
        if (this.d.getTypeAliasNames().contains(eVar)) {
            return this.d.getTypeAliasByName(eVar);
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return this.d.getContributedFunctions(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return this.d.getContributedVariables(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        return this.d.getFunctionNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        return this.d.getVariableNames();
    }

    public abstract Set<d0.e0.p.d.m0.g.e> h();

    public boolean i(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return getClassNames$deserialization().contains(eVar);
    }

    public boolean j(t0 t0Var) {
        d0.z.d.m.checkNotNullParameter(t0Var, "function");
        return true;
    }
}
