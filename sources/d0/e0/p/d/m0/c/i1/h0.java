package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.k.a0.c$b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SubpackagesScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public class h0 extends d0.e0.p.d.m0.k.a0.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.c.c0 f3266b;
    public final d0.e0.p.d.m0.g.b c;

    public h0(d0.e0.p.d.m0.c.c0 c0Var, d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        this.f3266b = c0Var;
        this.c = bVar;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        return d0.t.n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        if (!dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getPACKAGES_MASK())) {
            return d0.t.n.emptyList();
        }
        if (this.c.isRoot() && dVar.getExcludes().contains(c$b.a)) {
            return d0.t.n.emptyList();
        }
        Collection<d0.e0.p.d.m0.g.b> subPackagesOf = this.f3266b.getSubPackagesOf(this.c, function1);
        ArrayList arrayList = new ArrayList(subPackagesOf.size());
        Iterator<d0.e0.p.d.m0.g.b> it = subPackagesOf.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.g.e eVarShortName = it.next().shortName();
            d0.z.d.m.checkNotNullExpressionValue(eVarShortName, "subFqName.shortName()");
            if (function1.invoke(eVarShortName).booleanValue()) {
                d0.z.d.m.checkNotNullParameter(eVarShortName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                d0.e0.p.d.m0.c.j0 j0Var = null;
                if (!eVarShortName.isSpecial()) {
                    d0.e0.p.d.m0.c.c0 c0Var = this.f3266b;
                    d0.e0.p.d.m0.g.b bVarChild = this.c.child(eVarShortName);
                    d0.z.d.m.checkNotNullExpressionValue(bVarChild, "fqName.child(name)");
                    d0.e0.p.d.m0.c.j0 j0Var2 = c0Var.getPackage(bVarChild);
                    if (!j0Var2.isEmpty()) {
                        j0Var = j0Var2;
                    }
                }
                d0.e0.p.d.m0.p.a.addIfNotNull(arrayList, j0Var);
            }
        }
        return arrayList;
    }
}
