package p007b.p225i.p361c.p368l;

import com.google.firebase.components.DependencyCycleException;
import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import p007b.p225i.p361c.p396q.InterfaceC4798c;
import p007b.p225i.p361c.p396q.InterfaceC4799d;
import p007b.p225i.p361c.p400t.InterfaceC4836a;

/* JADX INFO: renamed from: b.i.c.l.k */
/* JADX INFO: compiled from: ComponentRuntime.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4579k extends AbstractC4569a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f12191a = 0;

    /* JADX INFO: renamed from: b */
    public final Map<C4572d<?>, C4586r<?>> f12192b = new HashMap();

    /* JADX INFO: renamed from: c */
    public final Map<Class<?>, C4586r<?>> f12193c = new HashMap();

    /* JADX INFO: renamed from: d */
    public final Map<Class<?>, C4586r<Set<?>>> f12194d = new HashMap();

    /* JADX INFO: renamed from: e */
    public final C4585q f12195e;

    public C4579k(Executor executor, Iterable<InterfaceC4575g> iterable, C4572d<?>... c4572dArr) {
        Set<C4581m> set;
        C4585q c4585q = new C4585q(executor);
        this.f12195e = c4585q;
        ArrayList<C4572d> arrayList = new ArrayList();
        arrayList.add(C4572d.m6349c(c4585q, C4585q.class, InterfaceC4799d.class, InterfaceC4798c.class));
        Iterator<InterfaceC4575g> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        for (C4572d<?> c4572d : c4572dArr) {
            if (c4572d != null) {
                arrayList.add(c4572d);
            }
        }
        HashMap map = new HashMap(arrayList.size());
        for (C4572d c4572d2 : arrayList) {
            C4581m c4581m = new C4581m(c4572d2);
            Iterator it2 = c4572d2.f12175a.iterator();
            while (it2.hasNext()) {
                Class cls = (Class) it2.next();
                boolean z2 = !c4572d2.m6350b();
                C4582n c4582n = new C4582n(cls, z2, null);
                if (!map.containsKey(c4582n)) {
                    map.put(c4582n, new HashSet());
                }
                Set set2 = (Set) map.get(c4582n);
                if (!set2.isEmpty() && !z2) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(c4581m);
            }
        }
        Iterator it3 = map.values().iterator();
        while (it3.hasNext()) {
            for (C4581m c4581m2 : (Set) it3.next()) {
                for (C4583o c4583o : c4581m2.f12196a.f12176b) {
                    if ((c4583o.f12203c == 0) && (set = (Set) map.get(new C4582n(c4583o.f12201a, c4583o.m6358a(), null))) != null) {
                        for (C4581m c4581m3 : set) {
                            c4581m2.f12197b.add(c4581m3);
                            c4581m3.f12198c.add(c4581m2);
                        }
                    }
                }
            }
        }
        HashSet<C4581m> hashSet = new HashSet();
        Iterator it4 = map.values().iterator();
        while (it4.hasNext()) {
            hashSet.addAll((Set) it4.next());
        }
        HashSet hashSet2 = new HashSet();
        for (C4581m c4581m4 : hashSet) {
            if (c4581m4.m6357a()) {
                hashSet2.add(c4581m4);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            C4581m c4581m5 = (C4581m) hashSet2.iterator().next();
            hashSet2.remove(c4581m5);
            i++;
            for (C4581m c4581m6 : c4581m5.f12197b) {
                c4581m6.f12198c.remove(c4581m5);
                if (c4581m6.m6357a()) {
                    hashSet2.add(c4581m6);
                }
            }
        }
        if (i != arrayList.size()) {
            ArrayList arrayList2 = new ArrayList();
            for (C4581m c4581m7 : hashSet) {
                if (!c4581m7.m6357a() && !c4581m7.f12197b.isEmpty()) {
                    arrayList2.add(c4581m7.f12196a);
                }
            }
            throw new DependencyCycleException(arrayList2);
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            final C4572d<?> c4572d3 = (C4572d) it5.next();
            this.f12192b.put(c4572d3, new C4586r<>(new InterfaceC4836a(this, c4572d3) { // from class: b.i.c.l.h

                /* JADX INFO: renamed from: a */
                public final C4579k f12187a;

                /* JADX INFO: renamed from: b */
                public final C4572d f12188b;

                {
                    this.f12187a = this;
                    this.f12188b = c4572d3;
                }

                @Override // p007b.p225i.p361c.p400t.InterfaceC4836a
                public Object get() {
                    C4579k c4579k = this.f12187a;
                    C4572d c4572d4 = this.f12188b;
                    int i2 = C4579k.f12191a;
                    return c4572d4.f12179e.mo6341a(new C4587s(c4572d4, c4579k));
                }
            }));
        }
        for (Map.Entry<C4572d<?>, C4586r<?>> entry : this.f12192b.entrySet()) {
            C4572d<?> key = entry.getKey();
            if (key.m6350b()) {
                C4586r<?> value = entry.getValue();
                Iterator<Class<? super Object>> it6 = key.f12175a.iterator();
                while (it6.hasNext()) {
                    this.f12193c.put(it6.next(), value);
                }
            }
        }
        for (C4572d<?> c4572d4 : this.f12192b.keySet()) {
            for (C4583o c4583o2 : c4572d4.f12176b) {
                if ((c4583o2.f12202b == 1) && !this.f12193c.containsKey(c4583o2.f12201a)) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", c4572d4, c4583o2.f12201a));
                }
            }
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<C4572d<?>, C4586r<?>> entry2 : this.f12192b.entrySet()) {
            C4572d<?> key2 = entry2.getKey();
            if (!key2.m6350b()) {
                C4586r<?> value2 = entry2.getValue();
                for (Class<? super Object> cls2 : key2.f12175a) {
                    if (!map2.containsKey(cls2)) {
                        map2.put(cls2, new HashSet());
                    }
                    ((Set) map2.get(cls2)).add(value2);
                }
            }
        }
        for (Map.Entry entry3 : map2.entrySet()) {
            final Set set3 = (Set) entry3.getValue();
            this.f12194d.put((Class) entry3.getKey(), new C4586r<>(new InterfaceC4836a(set3) { // from class: b.i.c.l.i

                /* JADX INFO: renamed from: a */
                public final Set f12189a;

                {
                    this.f12189a = set3;
                }

                @Override // p007b.p225i.p361c.p400t.InterfaceC4836a
                public Object get() {
                    Set set4 = this.f12189a;
                    int i2 = C4579k.f12191a;
                    HashSet hashSet3 = new HashSet();
                    Iterator it7 = set4.iterator();
                    while (it7.hasNext()) {
                        hashSet3.add(((C4586r) it7.next()).get());
                    }
                    return Collections.unmodifiableSet(hashSet3);
                }
            }));
        }
    }

    @Override // p007b.p225i.p361c.p368l.InterfaceC4573e
    /* JADX INFO: renamed from: b */
    public <T> InterfaceC4836a<T> mo6355b(Class<T> cls) {
        Objects.requireNonNull(cls, "Null interface requested.");
        return this.f12193c.get(cls);
    }

    @Override // p007b.p225i.p361c.p368l.InterfaceC4573e
    /* JADX INFO: renamed from: c */
    public <T> InterfaceC4836a<Set<T>> mo6356c(Class<T> cls) {
        C4586r<Set<?>> c4586r = this.f12194d.get(cls);
        return c4586r != null ? c4586r : new InterfaceC4836a() { // from class: b.i.c.l.j
            @Override // p007b.p225i.p361c.p400t.InterfaceC4836a
            public Object get() {
                return Collections.emptySet();
            }
        };
    }
}
