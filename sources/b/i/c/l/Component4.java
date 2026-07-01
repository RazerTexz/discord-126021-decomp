package b.i.c.l;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.i.c.l.d, reason: use source file name */
/* JADX INFO: compiled from: Component.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Component4<T> {
    public final Set<Class<? super T>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Dependency2> f1662b;
    public final int c;
    public final int d;
    public final ComponentFactory<T> e;
    public final Set<Class<?>> f;

    /* JADX INFO: renamed from: b.i.c.l.d$b */
    /* JADX INFO: compiled from: Component.java */
    public static class b<T> {
        public final Set<Class<? super T>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<Dependency2> f1663b;
        public int c;
        public int d;
        public ComponentFactory<T> e;
        public Set<Class<?>> f;

        public b(Class cls, Class[] clsArr, a aVar) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            this.f1663b = new HashSet();
            this.c = 0;
            this.d = 0;
            this.f = new HashSet();
            Objects.requireNonNull(cls, "Null interface");
            hashSet.add(cls);
            for (Class cls2 : clsArr) {
                Objects.requireNonNull(cls2, "Null interface");
            }
            Collections.addAll(this.a, clsArr);
        }

        public b<T> a(Dependency2 dependency2) {
            if (!(!this.a.contains(dependency2.a))) {
                throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
            }
            this.f1663b.add(dependency2);
            return this;
        }

        public Component4<T> b() {
            if (this.e != null) {
                return new Component4<>(new HashSet(this.a), new HashSet(this.f1663b), this.c, this.d, this.e, this.f, null);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        public b<T> c(ComponentFactory<T> componentFactory) {
            this.e = componentFactory;
            return this;
        }

        public final b<T> d(int i) {
            if (!(this.c == 0)) {
                throw new IllegalStateException("Instantiation type has already been set.");
            }
            this.c = i;
            return this;
        }
    }

    public Component4(Set set, Set set2, int i, int i2, ComponentFactory componentFactory, Set set3, a aVar) {
        this.a = Collections.unmodifiableSet(set);
        this.f1662b = Collections.unmodifiableSet(set2);
        this.c = i;
        this.d = i2;
        this.e = componentFactory;
        this.f = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0], null);
    }

    @SafeVarargs
    public static <T> Component4<T> c(final T t, Class<T> cls, Class<? super T>... clsArr) {
        b bVar = new b(cls, clsArr, null);
        bVar.c(new ComponentFactory(t) { // from class: b.i.c.l.b
            public final Object a;

            {
                this.a = t;
            }

            @Override // b.i.c.l.ComponentFactory
            public Object a(ComponentContainer componentContainer) {
                return this.a;
            }
        });
        return bVar.b();
    }

    public boolean b() {
        return this.d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", type=" + this.d + ", deps=" + Arrays.toString(this.f1662b.toArray()) + "}";
    }
}
