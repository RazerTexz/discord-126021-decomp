package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.f.t;
import d0.e0.p.d.m0.f.w;
import d0.e0.p.d.m0.f.z.i$a;
import d0.t.n0;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DeserializedPackageMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public class i extends h {
    public final e0 g;
    public final d0.e0.p.d.m0.g.b h;

    public i(e0 e0Var, d0.e0.p.d.m0.f.l lVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.a aVar, f fVar, d0.e0.p.d.m0.l.b.j jVar, Function0<? extends Collection<d0.e0.p.d.m0.g.e>> function0) {
        d0.z.d.m.checkNotNullParameter(e0Var, "packageDescriptor");
        d0.z.d.m.checkNotNullParameter(lVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(aVar, "metadataVersion");
        d0.z.d.m.checkNotNullParameter(jVar, "components");
        d0.z.d.m.checkNotNullParameter(function0, "classNames");
        t typeTable = lVar.getTypeTable();
        d0.z.d.m.checkNotNullExpressionValue(typeTable, "proto.typeTable");
        d0.e0.p.d.m0.f.z.g gVar = new d0.e0.p.d.m0.f.z.g(typeTable);
        i$a i_a = d0.e0.p.d.m0.f.z.i.a;
        w versionRequirementTable = lVar.getVersionRequirementTable();
        d0.z.d.m.checkNotNullExpressionValue(versionRequirementTable, "proto.versionRequirementTable");
        d0.e0.p.d.m0.l.b.l lVarCreateContext = jVar.createContext(e0Var, cVar, gVar, i_a.create(versionRequirementTable), aVar, fVar);
        List<d0.e0.p.d.m0.f.i> functionList = lVar.getFunctionList();
        d0.z.d.m.checkNotNullExpressionValue(functionList, "proto.functionList");
        List<d0.e0.p.d.m0.f.n> propertyList = lVar.getPropertyList();
        d0.z.d.m.checkNotNullExpressionValue(propertyList, "proto.propertyList");
        List<r> typeAliasList = lVar.getTypeAliasList();
        d0.z.d.m.checkNotNullExpressionValue(typeAliasList, "proto.typeAliasList");
        super(lVarCreateContext, functionList, propertyList, typeAliasList, function0);
        this.g = e0Var;
        this.h = e0Var.getFqName();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public void a(Collection<d0.e0.p.d.m0.c.m> collection, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public d0.e0.p.d.m0.g.a e(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new d0.e0.p.d.m0.g.a(this.h, eVar);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public Set<d0.e0.p.d.m0.g.e> f() {
        return n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public Set<d0.e0.p.d.m0.g.e> g() {
        return n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h, d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(eVar, bVar);
        return super.getContributedClassifier(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1 function1) {
        return getContributedDescriptors(dVar, (Function1<? super d0.e0.p.d.m0.g.e, Boolean>) function1);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public Set<d0.e0.p.d.m0.g.e> h() {
        return n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public boolean i(d0.e0.p.d.m0.g.e eVar) {
        boolean z2;
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (getClassNames$deserialization().contains(eVar)) {
            return true;
        }
        Iterable<d0.e0.p.d.m0.c.h1.b> fictitiousClassDescriptorFactories = this.c.getComponents().getFictitiousClassDescriptorFactories();
        if ((fictitiousClassDescriptorFactories instanceof Collection) && ((Collection) fictitiousClassDescriptorFactories).isEmpty()) {
            z2 = false;
        } else {
            Iterator<d0.e0.p.d.m0.c.h1.b> it = fictitiousClassDescriptorFactories.iterator();
            while (it.hasNext()) {
                if (it.next().shouldCreateClass(this.h, eVar)) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        return z2;
    }

    public void recordLookup(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        d0.e0.p.d.m0.d.a.record(this.c.getComponents().getLookupTracker(), bVar, this.g, eVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public List<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        Collection<d0.e0.p.d.m0.c.m> collectionB = b(dVar, function1, d0.e0.p.d.m0.d.b.d.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<d0.e0.p.d.m0.c.h1.b> fictitiousClassDescriptorFactories = this.c.getComponents().getFictitiousClassDescriptorFactories();
        ArrayList arrayList = new ArrayList();
        Iterator<d0.e0.p.d.m0.c.h1.b> it = fictitiousClassDescriptorFactories.iterator();
        while (it.hasNext()) {
            d0.t.r.addAll(arrayList, it.next().getAllContributedClassesIfPossible(this.h));
        }
        return u.plus((Collection) collectionB, (Iterable) arrayList);
    }
}
