package b.i.c.l;

import com.google.firebase.components.DependencyCycleException;
import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ComponentRuntime.java */
/* JADX INFO: loaded from: classes3.dex */
public class k extends a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<d<?>, r<?>> f1665b = new HashMap();
    public final Map<Class<?>, r<?>> c = new HashMap();
    public final Map<Class<?>, r<Set<?>>> d = new HashMap();
    public final q e;

    public k(Executor executor, Iterable<g> iterable, d<?>... dVarArr) {
        Set<m> set;
        q qVar = new q(executor);
        this.e = qVar;
        ArrayList<d> arrayList = new ArrayList();
        arrayList.add(d.c(qVar, q.class, b.i.c.q.d.class, b.i.c.q.c.class));
        Iterator<g> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        for (d<?> dVar : dVarArr) {
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        HashMap map = new HashMap(arrayList.size());
        for (d dVar2 : arrayList) {
            m mVar = new m(dVar2);
            Iterator it2 = dVar2.a.iterator();
            while (it2.hasNext()) {
                Class cls = (Class) it2.next();
                boolean z2 = !dVar2.b();
                n nVar = new n(cls, z2, null);
                if (!map.containsKey(nVar)) {
                    map.put(nVar, new HashSet());
                }
                Set set2 = (Set) map.get(nVar);
                if (!set2.isEmpty() && !z2) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(mVar);
            }
        }
        Iterator it3 = map.values().iterator();
        while (it3.hasNext()) {
            for (m mVar2 : (Set) it3.next()) {
                for (o oVar : mVar2.a.f1662b) {
                    if ((oVar.c == 0) && (set = (Set) map.get(new n(oVar.a, oVar.a(), null))) != null) {
                        for (m mVar3 : set) {
                            mVar2.f1666b.add(mVar3);
                            mVar3.c.add(mVar2);
                        }
                    }
                }
            }
        }
        HashSet<m> hashSet = new HashSet();
        Iterator it4 = map.values().iterator();
        while (it4.hasNext()) {
            hashSet.addAll((Set) it4.next());
        }
        HashSet hashSet2 = new HashSet();
        for (m mVar4 : hashSet) {
            if (mVar4.a()) {
                hashSet2.add(mVar4);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            m mVar5 = (m) hashSet2.iterator().next();
            hashSet2.remove(mVar5);
            i++;
            for (m mVar6 : mVar5.f1666b) {
                mVar6.c.remove(mVar5);
                if (mVar6.a()) {
                    hashSet2.add(mVar6);
                }
            }
        }
        if (i != arrayList.size()) {
            ArrayList arrayList2 = new ArrayList();
            for (m mVar7 : hashSet) {
                if (!mVar7.a() && !mVar7.f1666b.isEmpty()) {
                    arrayList2.add(mVar7.a);
                }
            }
            throw new DependencyCycleException(arrayList2);
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            d<?> dVar3 = (d) it5.next();
            this.f1665b.put(dVar3, new r<>(new h(this, dVar3)));
        }
        for (Map$Entry<d<?>, r<?>> map$Entry : this.f1665b.entrySet()) {
            d<?> key = map$Entry.getKey();
            if (key.b()) {
                r<?> value = map$Entry.getValue();
                Iterator<Class<? super Object>> it6 = key.a.iterator();
                while (it6.hasNext()) {
                    this.c.put(it6.next(), value);
                }
            }
        }
        for (d<?> dVar4 : this.f1665b.keySet()) {
            for (o oVar2 : dVar4.f1662b) {
                if ((oVar2.f1668b == 1) && !this.c.containsKey(oVar2.a)) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", dVar4, oVar2.a));
                }
            }
        }
        HashMap map2 = new HashMap();
        for (Map$Entry<d<?>, r<?>> map$Entry2 : this.f1665b.entrySet()) {
            d<?> key2 = map$Entry2.getKey();
            if (!key2.b()) {
                r<?> value2 = map$Entry2.getValue();
                for (Class<? super Object> cls2 : key2.a) {
                    if (!map2.containsKey(cls2)) {
                        map2.put(cls2, new HashSet());
                    }
                    ((Set) map2.get(cls2)).add(value2);
                }
            }
        }
        for (Map$Entry map$Entry3 : map2.entrySet()) {
            this.d.put((Class) map$Entry3.getKey(), new r<>(new i((Set) map$Entry3.getValue())));
        }
    }

    @Override // b.i.c.l.e
    public <T> b.i.c.t.a<T> b(Class<T> cls) {
        Objects.requireNonNull(cls, "Null interface requested.");
        return this.c.get(cls);
    }

    @Override // b.i.c.l.e
    public <T> b.i.c.t.a<Set<T>> c(Class<T> cls) {
        r<Set<?>> rVar = this.d.get(cls);
        return rVar != null ? rVar : j.a;
    }
}
