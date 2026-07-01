package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.i.p;
import d0.e0.p.d.m0.l.b.u;
import d0.e0.p.d.m0.l.b.w;
import d0.e0.p.d.m0.m.f$m;
import d0.f0.q;
import d0.t.g0;
import d0.t.h0;
import d0.t.o;
import d0.z.d.a0;
import d0.z.d.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$c implements h$a {
    public static final /* synthetic */ KProperty<Object>[] a = {a0.property1(new y(a0.getOrCreateKotlinClass(h$c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), a0.property1(new y(a0.getOrCreateKotlinClass(h$c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<d0.e0.p.d.m0.g.e, byte[]> f3494b;
    public final Map<d0.e0.p.d.m0.g.e, byte[]> c;
    public final Map<d0.e0.p.d.m0.g.e, byte[]> d;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<t0>> e;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<n0>> f;
    public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.g.e, y0> g;
    public final d0.e0.p.d.m0.m.j h;
    public final d0.e0.p.d.m0.m.j i;
    public final /* synthetic */ h j;

    public h$c(h hVar, List<d0.e0.p.d.m0.f.i> list, List<d0.e0.p.d.m0.f.n> list2, List<r> list3) throws IOException {
        Map<d0.e0.p.d.m0.g.e, byte[]> mapEmptyMap;
        d0.z.d.m.checkNotNullParameter(hVar, "this$0");
        d0.z.d.m.checkNotNullParameter(list, "functionList");
        d0.z.d.m.checkNotNullParameter(list2, "propertyList");
        d0.z.d.m.checkNotNullParameter(list3, "typeAliasList");
        this.j = hVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            d0.e0.p.d.m0.g.e name = w.getName(h.access$getC(hVar).getNameResolver(), ((d0.e0.p.d.m0.f.i) ((d0.e0.p.d.m0.i.n) obj)).getName());
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f3494b = a(linkedHashMap);
        h hVar2 = this.j;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : list2) {
            d0.e0.p.d.m0.g.e name2 = w.getName(h.access$getC(hVar2).getNameResolver(), ((d0.e0.p.d.m0.f.n) ((d0.e0.p.d.m0.i.n) obj2)).getName());
            Object arrayList2 = linkedHashMap2.get(name2);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap2.put(name2, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        this.c = a(linkedHashMap2);
        if (this.j.c.getComponents().getConfiguration().getTypeAliasesAllowed()) {
            h hVar3 = this.j;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Object obj3 : list3) {
                d0.e0.p.d.m0.g.e name3 = w.getName(h.access$getC(hVar3).getNameResolver(), ((r) ((d0.e0.p.d.m0.i.n) obj3)).getName());
                Object arrayList3 = linkedHashMap3.get(name3);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                    linkedHashMap3.put(name3, arrayList3);
                }
                ((List) arrayList3).add(obj3);
            }
            mapEmptyMap = a(linkedHashMap3);
        } else {
            mapEmptyMap = h0.emptyMap();
        }
        this.d = mapEmptyMap;
        this.e = this.j.c.getStorageManager().createMemoizedFunction(new h$c$c(this));
        this.f = this.j.c.getStorageManager().createMemoizedFunction(new h$c$d(this));
        this.g = this.j.c.getStorageManager().createMemoizedFunctionWithNullableValues(new h$c$e(this));
        this.h = this.j.c.getStorageManager().createLazyValue(new h$c$b(this, this.j));
        this.i = this.j.c.getStorageManager().createLazyValue(new h$c$f(this, this.j));
    }

    public static final Collection access$computeFunctions(h$c h_c, d0.e0.p.d.m0.g.e eVar) {
        Map<d0.e0.p.d.m0.g.e, byte[]> map = h_c.f3494b;
        p<d0.e0.p.d.m0.f.i> pVar = d0.e0.p.d.m0.f.i.k;
        d0.z.d.m.checkNotNullExpressionValue(pVar, "PARSER");
        h hVar = h_c.j;
        byte[] bArr = map.get(eVar);
        List<d0.e0.p.d.m0.f.i> list = bArr == null ? null : q.toList(d0.f0.n.generateSequence(new h$c$a(pVar, new ByteArrayInputStream(bArr), h_c.j)));
        if (list == null) {
            list = d0.t.n.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (d0.e0.p.d.m0.f.i iVar : list) {
            u memberDeserializer = hVar.c.getMemberDeserializer();
            d0.z.d.m.checkNotNullExpressionValue(iVar, "it");
            t0 t0VarLoadFunction = memberDeserializer.loadFunction(iVar);
            if (!hVar.j(t0VarLoadFunction)) {
                t0VarLoadFunction = null;
            }
            if (t0VarLoadFunction != null) {
                arrayList.add(t0VarLoadFunction);
            }
        }
        hVar.c(eVar, arrayList);
        return d0.e0.p.d.m0.p.a.compact(arrayList);
    }

    public static final Collection access$computeProperties(h$c h_c, d0.e0.p.d.m0.g.e eVar) {
        Map<d0.e0.p.d.m0.g.e, byte[]> map = h_c.c;
        p<d0.e0.p.d.m0.f.n> pVar = d0.e0.p.d.m0.f.n.k;
        d0.z.d.m.checkNotNullExpressionValue(pVar, "PARSER");
        h hVar = h_c.j;
        byte[] bArr = map.get(eVar);
        List<d0.e0.p.d.m0.f.n> list = bArr == null ? null : q.toList(d0.f0.n.generateSequence(new h$c$a(pVar, new ByteArrayInputStream(bArr), h_c.j)));
        if (list == null) {
            list = d0.t.n.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (d0.e0.p.d.m0.f.n nVar : list) {
            u memberDeserializer = hVar.c.getMemberDeserializer();
            d0.z.d.m.checkNotNullExpressionValue(nVar, "it");
            n0 n0VarLoadProperty = memberDeserializer.loadProperty(nVar);
            if (n0VarLoadProperty != null) {
                arrayList.add(n0VarLoadProperty);
            }
        }
        hVar.d(eVar, arrayList);
        return d0.e0.p.d.m0.p.a.compact(arrayList);
    }

    public static final y0 access$createTypeAlias(h$c h_c, d0.e0.p.d.m0.g.e eVar) {
        r delimitedFrom;
        byte[] bArr = h_c.d.get(eVar);
        if (bArr == null || (delimitedFrom = r.parseDelimitedFrom(new ByteArrayInputStream(bArr), h_c.j.c.getComponents().getExtensionRegistryLite())) == null) {
            return null;
        }
        return h_c.j.c.getMemberDeserializer().loadTypeAlias(delimitedFrom);
    }

    public static final /* synthetic */ Map access$getFunctionProtosBytes$p(h$c h_c) {
        return h_c.f3494b;
    }

    public static final /* synthetic */ Map access$getPropertyProtosBytes$p(h$c h_c) {
        return h_c.c;
    }

    public final Map<d0.e0.p.d.m0.g.e, byte[]> a(Map<d0.e0.p.d.m0.g.e, ? extends Collection<? extends d0.e0.p.d.m0.i.a>> map) throws IOException {
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            Object key = map$Entry.getKey();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterable iterable = (Iterable) map$Entry.getValue();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                ((d0.e0.p.d.m0.i.a) it2.next()).writeDelimitedTo(byteArrayOutputStream);
                arrayList.add(Unit.a);
            }
            linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
        }
        return linkedHashMap;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public void addFunctionsAndPropertiesTo(Collection<d0.e0.p.d.m0.c.m> collection, d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getVARIABLES_MASK())) {
            Set<d0.e0.p.d.m0.g.e> variableNames = getVariableNames();
            ArrayList arrayList = new ArrayList();
            for (d0.e0.p.d.m0.g.e eVar : variableNames) {
                if (function1.invoke(eVar).booleanValue()) {
                    arrayList.addAll(getContributedVariables(eVar, bVar));
                }
            }
            d0.e0.p.d.m0.k.h hVar = d0.e0.p.d.m0.k.h.j;
            d0.z.d.m.checkNotNullExpressionValue(hVar, "INSTANCE");
            d0.t.q.sortWith(arrayList, hVar);
            collection.addAll(arrayList);
        }
        if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getFUNCTIONS_MASK())) {
            Set<d0.e0.p.d.m0.g.e> functionNames = getFunctionNames();
            ArrayList arrayList2 = new ArrayList();
            for (d0.e0.p.d.m0.g.e eVar2 : functionNames) {
                if (function1.invoke(eVar2).booleanValue()) {
                    arrayList2.addAll(getContributedFunctions(eVar2, bVar));
                }
            }
            d0.e0.p.d.m0.k.h hVar2 = d0.e0.p.d.m0.k.h.j;
            d0.z.d.m.checkNotNullExpressionValue(hVar2, "INSTANCE");
            d0.t.q.sortWith(arrayList2, hVar2);
            collection.addAll(arrayList2);
        }
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return !getFunctionNames().contains(eVar) ? d0.t.n.emptyList() : (Collection) ((f$m) this.e).invoke(eVar);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return !getVariableNames().contains(eVar) ? d0.t.n.emptyList() : (Collection) ((f$m) this.f).invoke(eVar);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.h, this, (KProperty<?>) a[0]);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public y0 getTypeAliasByName(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.g.invoke(eVar);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public Set<d0.e0.p.d.m0.g.e> getTypeAliasNames() {
        return this.d.keySet();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.i, this, (KProperty<?>) a[1]);
    }
}
