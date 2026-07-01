package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.u0;
import d0.t.g0;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ProtoBasedClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements g {
    public final d0.e0.p.d.m0.f.z.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.f.z.a f3509b;
    public final Function1<d0.e0.p.d.m0.g.a, u0> c;
    public final Map<d0.e0.p.d.m0.g.a, d0.e0.p.d.m0.f.c> d;

    /* JADX WARN: Multi-variable type inference failed */
    public x(d0.e0.p.d.m0.f.m mVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.a aVar, Function1<? super d0.e0.p.d.m0.g.a, ? extends u0> function1) {
        d0.z.d.m.checkNotNullParameter(mVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(aVar, "metadataVersion");
        d0.z.d.m.checkNotNullParameter(function1, "classSource");
        this.a = cVar;
        this.f3509b = aVar;
        this.c = function1;
        List<d0.e0.p.d.m0.f.c> class_List = mVar.getClass_List();
        d0.z.d.m.checkNotNullExpressionValue(class_List, "proto.class_List");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(class_List, 10)), 16));
        for (Object obj : class_List) {
            linkedHashMap.put(w.getClassId(this.a, ((d0.e0.p.d.m0.f.c) obj).getFqName()), obj);
        }
        this.d = linkedHashMap;
    }

    @Override // d0.e0.p.d.m0.l.b.g
    public f findClassData(d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        d0.e0.p.d.m0.f.c cVar = this.d.get(aVar);
        if (cVar == null) {
            return null;
        }
        return new f(this.a, cVar, this.f3509b, this.c.invoke(aVar));
    }

    public final Collection<d0.e0.p.d.m0.g.a> getAllClassIds() {
        return this.d.keySet();
    }
}
