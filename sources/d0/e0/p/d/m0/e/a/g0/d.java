package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.b.k$a;
import d0.e0.p.d.m0.c.g1.m;
import d0.e0.p.d.m0.c.g1.n;
import d0.o;
import d0.t.h0;
import d0.t.n0;
import d0.t.r;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final d a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, EnumSet<n>> f3316b = h0.mapOf(o.to("PACKAGE", EnumSet.noneOf(n.class)), o.to("TYPE", EnumSet.of(n.CLASS, n.FILE)), o.to("ANNOTATION_TYPE", EnumSet.of(n.ANNOTATION_CLASS)), o.to("TYPE_PARAMETER", EnumSet.of(n.TYPE_PARAMETER)), o.to("FIELD", EnumSet.of(n.FIELD)), o.to("LOCAL_VARIABLE", EnumSet.of(n.LOCAL_VARIABLE)), o.to("PARAMETER", EnumSet.of(n.VALUE_PARAMETER)), o.to("CONSTRUCTOR", EnumSet.of(n.CONSTRUCTOR)), o.to("METHOD", EnumSet.of(n.FUNCTION, n.PROPERTY_GETTER, n.PROPERTY_SETTER)), o.to("TYPE_USE", EnumSet.of(n.TYPE)));
    public static final Map<String, m> c = h0.mapOf(o.to("RUNTIME", m.RUNTIME), o.to("CLASS", m.BINARY), o.to("SOURCE", m.SOURCE));

    public final d0.e0.p.d.m0.k.v.g<?> mapJavaRetentionArgument$descriptors_jvm(d0.e0.p.d.m0.e.a.k0.b bVar) {
        d0.e0.p.d.m0.e.a.k0.m mVar = bVar instanceof d0.e0.p.d.m0.e.a.k0.m ? (d0.e0.p.d.m0.e.a.k0.m) bVar : null;
        if (mVar == null) {
            return null;
        }
        Map<String, m> map = c;
        d0.e0.p.d.m0.g.e entryName = mVar.getEntryName();
        m mVar2 = map.get(entryName == null ? null : entryName.asString());
        if (mVar2 == null) {
            return null;
        }
        d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(k$a.C);
        d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(StandardNames.FqNames.annotationRetention)");
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(mVar2.name());
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(retention.name)");
        return new d0.e0.p.d.m0.k.v.j(aVar, eVarIdentifier);
    }

    public final Set<n> mapJavaTargetArgumentByName(String str) {
        EnumSet<n> enumSet = f3316b.get(str);
        return enumSet == null ? n0.emptySet() : enumSet;
    }

    public final d0.e0.p.d.m0.k.v.g<?> mapJavaTargetArguments$descriptors_jvm(List<? extends d0.e0.p.d.m0.e.a.k0.b> list) {
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof d0.e0.p.d.m0.e.a.k0.m) {
                arrayList.add(obj);
            }
        }
        ArrayList<n> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.g.e entryName = ((d0.e0.p.d.m0.e.a.k0.m) it.next()).getEntryName();
            r.addAll(arrayList2, mapJavaTargetArgumentByName(entryName == null ? null : entryName.asString()));
        }
        ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList2, 10));
        for (n nVar : arrayList2) {
            d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(k$a.B);
            d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(StandardNames.FqNames.annotationTarget)");
            d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(nVar.name());
            d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(kotlinTarget.name)");
            arrayList3.add(new d0.e0.p.d.m0.k.v.j(aVar, eVarIdentifier));
        }
        return new d0.e0.p.d.m0.k.v.b(arrayList3, d$a.j);
    }
}
