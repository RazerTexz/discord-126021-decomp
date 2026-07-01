package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.k.p;
import d0.e0.p.d.m0.n.c0;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypeIntersectionScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o$a f3464b = new o$a(null);
    public final i c;

    public o(String str, i iVar, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = iVar;
    }

    public static final i create(String str, Collection<? extends c0> collection) {
        return f3464b.create(str, collection);
    }

    @Override // d0.e0.p.d.m0.k.a0.a
    public i a() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.k.a0.a, d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        Collection<d0.e0.p.d.m0.c.m> contributedDescriptors = super.getContributedDescriptors(dVar, function1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (((d0.e0.p.d.m0.c.m) obj) instanceof d0.e0.p.d.m0.c.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.component1();
        return u.plus(p.selectMostSpecificInEachOverridableGroup(list, o$b.j), (Iterable) pair.component2());
    }

    @Override // d0.e0.p.d.m0.k.a0.a, d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return p.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(eVar, bVar), o$c.j);
    }

    @Override // d0.e0.p.d.m0.k.a0.a, d0.e0.p.d.m0.k.a0.i
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return p.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(eVar, bVar), o$d.j);
    }
}
