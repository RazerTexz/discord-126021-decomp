package b.i.c.l;

import b.i.c.q.Publisher;
import b.i.c.q.Subscriber2;
import b.i.c.t.Provider2;
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

/* JADX INFO: renamed from: b.i.c.l.k, reason: use source file name */
/* JADX INFO: compiled from: ComponentRuntime.java */
/* JADX INFO: loaded from: classes3.dex */
public class ComponentRuntime4 extends AbstractComponentContainer {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Component4<?>, Lazy2<?>> f1665b = new HashMap();
    public final Map<Class<?>, Lazy2<?>> c = new HashMap();
    public final Map<Class<?>, Lazy2<Set<?>>> d = new HashMap();
    public final EventBus2 e;

    public ComponentRuntime4(Executor executor, Iterable<ComponentRegistrar> iterable, Component4<?>... component4Arr) {
        Set<CycleDetector2> set;
        EventBus2 eventBus2 = new EventBus2(executor);
        this.e = eventBus2;
        ArrayList<Component4> arrayList = new ArrayList();
        arrayList.add(Component4.c(eventBus2, EventBus2.class, Subscriber2.class, Publisher.class));
        Iterator<ComponentRegistrar> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        for (Component4<?> component4 : component4Arr) {
            if (component4 != null) {
                arrayList.add(component4);
            }
        }
        HashMap map = new HashMap(arrayList.size());
        for (Component4 component5 : arrayList) {
            CycleDetector2 cycleDetector2 = new CycleDetector2(component5);
            Iterator it2 = component5.a.iterator();
            while (it2.hasNext()) {
                Class cls = (Class) it2.next();
                boolean z2 = !component5.b();
                CycleDetector3 cycleDetector3 = new CycleDetector3(cls, z2, null);
                if (!map.containsKey(cycleDetector3)) {
                    map.put(cycleDetector3, new HashSet());
                }
                Set set2 = (Set) map.get(cycleDetector3);
                if (!set2.isEmpty() && !z2) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(cycleDetector2);
            }
        }
        Iterator it3 = map.values().iterator();
        while (it3.hasNext()) {
            for (CycleDetector2 cycleDetector4 : (Set) it3.next()) {
                for (Dependency2 dependency2 : cycleDetector4.a.f1662b) {
                    if ((dependency2.c == 0) && (set = (Set) map.get(new CycleDetector3(dependency2.a, dependency2.a(), null))) != null) {
                        for (CycleDetector2 cycleDetector5 : set) {
                            cycleDetector4.f1666b.add(cycleDetector5);
                            cycleDetector5.c.add(cycleDetector4);
                        }
                    }
                }
            }
        }
        HashSet<CycleDetector2> hashSet = new HashSet();
        Iterator it4 = map.values().iterator();
        while (it4.hasNext()) {
            hashSet.addAll((Set) it4.next());
        }
        HashSet hashSet2 = new HashSet();
        for (CycleDetector2 cycleDetector6 : hashSet) {
            if (cycleDetector6.a()) {
                hashSet2.add(cycleDetector6);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            CycleDetector2 cycleDetector7 = (CycleDetector2) hashSet2.iterator().next();
            hashSet2.remove(cycleDetector7);
            i++;
            for (CycleDetector2 cycleDetector8 : cycleDetector7.f1666b) {
                cycleDetector8.c.remove(cycleDetector7);
                if (cycleDetector8.a()) {
                    hashSet2.add(cycleDetector8);
                }
            }
        }
        if (i != arrayList.size()) {
            ArrayList arrayList2 = new ArrayList();
            for (CycleDetector2 cycleDetector9 : hashSet) {
                if (!cycleDetector9.a() && !cycleDetector9.f1666b.isEmpty()) {
                    arrayList2.add(cycleDetector9.a);
                }
            }
            throw new DependencyCycleException(arrayList2);
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            final Component4<?> component6 = (Component4) it5.next();
            this.f1665b.put(component6, new Lazy2<>(new Provider2(this, component6) { // from class: b.i.c.l.h
                public final ComponentRuntime4 a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final Component4 f1664b;

                {
                    this.a = this;
                    this.f1664b = component6;
                }

                @Override // b.i.c.t.Provider2
                public Object get() {
                    ComponentRuntime4 componentRuntime4 = this.a;
                    Component4 component7 = this.f1664b;
                    int i2 = ComponentRuntime4.a;
                    return component7.e.a(new RestrictedComponentContainer(component7, componentRuntime4));
                }
            }));
        }
        for (Map.Entry<Component4<?>, Lazy2<?>> entry : this.f1665b.entrySet()) {
            Component4<?> key = entry.getKey();
            if (key.b()) {
                Lazy2<?> value = entry.getValue();
                Iterator<Class<? super Object>> it6 = key.a.iterator();
                while (it6.hasNext()) {
                    this.c.put(it6.next(), value);
                }
            }
        }
        for (Component4<?> component7 : this.f1665b.keySet()) {
            for (Dependency2 dependency3 : component7.f1662b) {
                if ((dependency3.f1668b == 1) && !this.c.containsKey(dependency3.a)) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component7, dependency3.a));
                }
            }
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<Component4<?>, Lazy2<?>> entry2 : this.f1665b.entrySet()) {
            Component4<?> key2 = entry2.getKey();
            if (!key2.b()) {
                Lazy2<?> value2 = entry2.getValue();
                for (Class<? super Object> cls2 : key2.a) {
                    if (!map2.containsKey(cls2)) {
                        map2.put(cls2, new HashSet());
                    }
                    ((Set) map2.get(cls2)).add(value2);
                }
            }
        }
        for (Map.Entry entry3 : map2.entrySet()) {
            final Set set3 = (Set) entry3.getValue();
            this.d.put((Class) entry3.getKey(), new Lazy2<>(new Provider2(set3) { // from class: b.i.c.l.i
                public final Set a;

                {
                    this.a = set3;
                }

                @Override // b.i.c.t.Provider2
                public Object get() {
                    Set set4 = this.a;
                    int i2 = ComponentRuntime4.a;
                    HashSet hashSet3 = new HashSet();
                    Iterator it7 = set4.iterator();
                    while (it7.hasNext()) {
                        hashSet3.add(((Lazy2) it7.next()).get());
                    }
                    return Collections.unmodifiableSet(hashSet3);
                }
            }));
        }
    }

    @Override // b.i.c.l.ComponentContainer
    public <T> Provider2<T> b(Class<T> cls) {
        Objects.requireNonNull(cls, "Null interface requested.");
        return this.c.get(cls);
    }

    @Override // b.i.c.l.ComponentContainer
    public <T> Provider2<Set<T>> c(Class<T> cls) {
        Lazy2<Set<?>> lazy2 = this.d.get(cls);
        return lazy2 != null ? lazy2 : new Provider2() { // from class: b.i.c.l.j
            @Override // b.i.c.t.Provider2
            public Object get() {
                return Collections.emptySet();
            }
        };
    }
}
