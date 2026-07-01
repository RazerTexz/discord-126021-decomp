package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.l.b.w;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b implements h$a {
    public static final /* synthetic */ KProperty<Object>[] a = {a0.property1(new y(a0.getOrCreateKotlinClass(h$b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), a0.property1(new y(a0.getOrCreateKotlinClass(h$b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), a0.property1(new y(a0.getOrCreateKotlinClass(h$b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), a0.property1(new y(a0.getOrCreateKotlinClass(h$b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), a0.property1(new y(a0.getOrCreateKotlinClass(h$b.class), "allProperties", "getAllProperties()Ljava/util/List;")), a0.property1(new y(a0.getOrCreateKotlinClass(h$b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), a0.property1(new y(a0.getOrCreateKotlinClass(h$b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), a0.property1(new y(a0.getOrCreateKotlinClass(h$b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), a0.property1(new y(a0.getOrCreateKotlinClass(h$b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), a0.property1(new y(a0.getOrCreateKotlinClass(h$b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d0.e0.p.d.m0.f.i> f3493b;
    public final List<d0.e0.p.d.m0.f.n> c;
    public final List<r> d;
    public final d0.e0.p.d.m0.m.j e;
    public final d0.e0.p.d.m0.m.j f;
    public final d0.e0.p.d.m0.m.j g;
    public final d0.e0.p.d.m0.m.j h;
    public final d0.e0.p.d.m0.m.j i;
    public final d0.e0.p.d.m0.m.j j;
    public final d0.e0.p.d.m0.m.j k;
    public final d0.e0.p.d.m0.m.j l;
    public final d0.e0.p.d.m0.m.j m;
    public final d0.e0.p.d.m0.m.j n;
    public final /* synthetic */ h o;

    public h$b(h hVar, List<d0.e0.p.d.m0.f.i> list, List<d0.e0.p.d.m0.f.n> list2, List<r> list3) {
        d0.z.d.m.checkNotNullParameter(hVar, "this$0");
        d0.z.d.m.checkNotNullParameter(list, "functionList");
        d0.z.d.m.checkNotNullParameter(list2, "propertyList");
        d0.z.d.m.checkNotNullParameter(list3, "typeAliasList");
        this.o = hVar;
        this.f3493b = list;
        this.c = list2;
        this.d = hVar.c.getComponents().getConfiguration().getTypeAliasesAllowed() ? list3 : d0.t.n.emptyList();
        this.e = hVar.c.getStorageManager().createLazyValue(new h$b$d(this));
        this.f = hVar.c.getStorageManager().createLazyValue(new h$b$e(this));
        this.g = hVar.c.getStorageManager().createLazyValue(new h$b$c(this));
        this.h = hVar.c.getStorageManager().createLazyValue(new h$b$a(this));
        this.i = hVar.c.getStorageManager().createLazyValue(new h$b$b(this));
        this.j = hVar.c.getStorageManager().createLazyValue(new h$b$i(this));
        this.k = hVar.c.getStorageManager().createLazyValue(new h$b$g(this));
        this.l = hVar.c.getStorageManager().createLazyValue(new h$b$h(this));
        this.m = hVar.c.getStorageManager().createLazyValue(new h$b$f(this, hVar));
        this.n = hVar.c.getStorageManager().createLazyValue(new h$b$j(this, hVar));
    }

    public static final List access$computeAllNonDeclaredFunctions(h$b h_b) {
        Set<d0.e0.p.d.m0.g.e> setG = h_b.o.g();
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.g.e eVar : setG) {
            List list = (List) d0.e0.p.d.m0.m.n.getValue(h_b.e, h_b, (KProperty<?>) a[0]);
            h hVar = h_b.o;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (d0.z.d.m.areEqual(((d0.e0.p.d.m0.c.m) obj).getName(), eVar)) {
                    arrayList2.add(obj);
                }
            }
            int size = arrayList2.size();
            hVar.c(eVar, arrayList2);
            d0.t.r.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
        }
        return arrayList;
    }

    public static final List access$computeAllNonDeclaredProperties(h$b h_b) {
        Set<d0.e0.p.d.m0.g.e> setH = h_b.o.h();
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.g.e eVar : setH) {
            List list = (List) d0.e0.p.d.m0.m.n.getValue(h_b.f, h_b, (KProperty<?>) a[1]);
            h hVar = h_b.o;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (d0.z.d.m.areEqual(((d0.e0.p.d.m0.c.m) obj).getName(), eVar)) {
                    arrayList2.add(obj);
                }
            }
            int size = arrayList2.size();
            hVar.d(eVar, arrayList2);
            d0.t.r.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
        }
        return arrayList;
    }

    public static final List access$computeFunctions(h$b h_b) {
        List<d0.e0.p.d.m0.f.i> list = h_b.f3493b;
        h hVar = h_b.o;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            t0 t0VarLoadFunction = h.access$getC(hVar).getMemberDeserializer().loadFunction((d0.e0.p.d.m0.f.i) ((d0.e0.p.d.m0.i.n) it.next()));
            if (!hVar.j(t0VarLoadFunction)) {
                t0VarLoadFunction = null;
            }
            if (t0VarLoadFunction != null) {
                arrayList.add(t0VarLoadFunction);
            }
        }
        return arrayList;
    }

    public static final List access$computeProperties(h$b h_b) {
        List<d0.e0.p.d.m0.f.n> list = h_b.c;
        h hVar = h_b.o;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            n0 n0VarLoadProperty = h.access$getC(hVar).getMemberDeserializer().loadProperty((d0.e0.p.d.m0.f.n) ((d0.e0.p.d.m0.i.n) it.next()));
            if (n0VarLoadProperty != null) {
                arrayList.add(n0VarLoadProperty);
            }
        }
        return arrayList;
    }

    public static final List access$computeTypeAliases(h$b h_b) {
        List<r> list = h_b.d;
        h hVar = h_b.o;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            y0 y0VarLoadTypeAlias = h.access$getC(hVar).getMemberDeserializer().loadTypeAlias((r) ((d0.e0.p.d.m0.i.n) it.next()));
            if (y0VarLoadTypeAlias != null) {
                arrayList.add(y0VarLoadTypeAlias);
            }
        }
        return arrayList;
    }

    public static final List access$getAllFunctions(h$b h_b) {
        return (List) d0.e0.p.d.m0.m.n.getValue(h_b.h, h_b, (KProperty<?>) a[3]);
    }

    public static final List access$getAllProperties(h$b h_b) {
        return (List) d0.e0.p.d.m0.m.n.getValue(h_b.i, h_b, (KProperty<?>) a[4]);
    }

    public static final List access$getAllTypeAliases(h$b h_b) {
        return (List) d0.e0.p.d.m0.m.n.getValue(h_b.g, h_b, (KProperty<?>) a[2]);
    }

    public static final List access$getDeclaredFunctions(h$b h_b) {
        return (List) d0.e0.p.d.m0.m.n.getValue(h_b.e, h_b, (KProperty<?>) a[0]);
    }

    public static final List access$getDeclaredProperties(h$b h_b) {
        return (List) d0.e0.p.d.m0.m.n.getValue(h_b.f, h_b, (KProperty<?>) a[1]);
    }

    public static final /* synthetic */ List access$getFunctionList$p(h$b h_b) {
        return h_b.f3493b;
    }

    public static final /* synthetic */ List access$getPropertyList$p(h$b h_b) {
        return h_b.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public void addFunctionsAndPropertiesTo(Collection<d0.e0.p.d.m0.c.m> collection, d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getVARIABLES_MASK())) {
            for (Object obj : (List) d0.e0.p.d.m0.m.n.getValue(this.i, this, (KProperty<?>) a[4])) {
                d0.e0.p.d.m0.g.e name = ((n0) obj).getName();
                d0.z.d.m.checkNotNullExpressionValue(name, "it.name");
                if (function1.invoke(name).booleanValue()) {
                    collection.add(obj);
                }
            }
        }
        if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getFUNCTIONS_MASK())) {
            for (Object obj2 : (List) d0.e0.p.d.m0.m.n.getValue(this.h, this, (KProperty<?>) a[3])) {
                d0.e0.p.d.m0.g.e name2 = ((t0) obj2).getName();
                d0.z.d.m.checkNotNullExpressionValue(name2, "it.name");
                if (function1.invoke(name2).booleanValue()) {
                    collection.add(obj2);
                }
            }
        }
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        Collection<t0> collection;
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return (getFunctionNames().contains(eVar) && (collection = (Collection) ((Map) d0.e0.p.d.m0.m.n.getValue(this.k, this, (KProperty<?>) a[6])).get(eVar)) != null) ? collection : d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        Collection<n0> collection;
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return (getVariableNames().contains(eVar) && (collection = (Collection) ((Map) d0.e0.p.d.m0.m.n.getValue(this.l, this, (KProperty<?>) a[7])).get(eVar)) != null) ? collection : d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.m, this, (KProperty<?>) a[8]);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public y0 getTypeAliasByName(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return (y0) ((Map) d0.e0.p.d.m0.m.n.getValue(this.j, this, (KProperty<?>) a[5])).get(eVar);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public Set<d0.e0.p.d.m0.g.e> getTypeAliasNames() {
        List<r> list = this.d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        h hVar = this.o;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(w.getName(h.access$getC(hVar).getNameResolver(), ((r) ((d0.e0.p.d.m0.i.n) it.next())).getName()));
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h$a
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.n, this, (KProperty<?>) a[9]);
    }
}
