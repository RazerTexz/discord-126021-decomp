package p007b.p225i.p361c.p368l;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.i.c.l.d */
/* JADX INFO: compiled from: Component.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4572d<T> {

    /* JADX INFO: renamed from: a */
    public final Set<Class<? super T>> f12175a;

    /* JADX INFO: renamed from: b */
    public final Set<C4583o> f12176b;

    /* JADX INFO: renamed from: c */
    public final int f12177c;

    /* JADX INFO: renamed from: d */
    public final int f12178d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC4574f<T> f12179e;

    /* JADX INFO: renamed from: f */
    public final Set<Class<?>> f12180f;

    /* JADX INFO: renamed from: b.i.c.l.d$b */
    /* JADX INFO: compiled from: Component.java */
    public static class b<T> {

        /* JADX INFO: renamed from: a */
        public final Set<Class<? super T>> f12181a;

        /* JADX INFO: renamed from: b */
        public final Set<C4583o> f12182b;

        /* JADX INFO: renamed from: c */
        public int f12183c;

        /* JADX INFO: renamed from: d */
        public int f12184d;

        /* JADX INFO: renamed from: e */
        public InterfaceC4574f<T> f12185e;

        /* JADX INFO: renamed from: f */
        public Set<Class<?>> f12186f;

        public b(Class cls, Class[] clsArr, a aVar) {
            HashSet hashSet = new HashSet();
            this.f12181a = hashSet;
            this.f12182b = new HashSet();
            this.f12183c = 0;
            this.f12184d = 0;
            this.f12186f = new HashSet();
            Objects.requireNonNull(cls, "Null interface");
            hashSet.add(cls);
            for (Class cls2 : clsArr) {
                Objects.requireNonNull(cls2, "Null interface");
            }
            Collections.addAll(this.f12181a, clsArr);
        }

        /* JADX INFO: renamed from: a */
        public b<T> m6351a(C4583o c4583o) {
            if (!(!this.f12181a.contains(c4583o.f12201a))) {
                throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
            }
            this.f12182b.add(c4583o);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C4572d<T> m6352b() {
            if (this.f12185e != null) {
                return new C4572d<>(new HashSet(this.f12181a), new HashSet(this.f12182b), this.f12183c, this.f12184d, this.f12185e, this.f12186f, null);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        /* JADX INFO: renamed from: c */
        public b<T> m6353c(InterfaceC4574f<T> interfaceC4574f) {
            this.f12185e = interfaceC4574f;
            return this;
        }

        /* JADX INFO: renamed from: d */
        public final b<T> m6354d(int i) {
            if (!(this.f12183c == 0)) {
                throw new IllegalStateException("Instantiation type has already been set.");
            }
            this.f12183c = i;
            return this;
        }
    }

    public C4572d(Set set, Set set2, int i, int i2, InterfaceC4574f interfaceC4574f, Set set3, a aVar) {
        this.f12175a = Collections.unmodifiableSet(set);
        this.f12176b = Collections.unmodifiableSet(set2);
        this.f12177c = i;
        this.f12178d = i2;
        this.f12179e = interfaceC4574f;
        this.f12180f = Collections.unmodifiableSet(set3);
    }

    /* JADX INFO: renamed from: a */
    public static <T> b<T> m6348a(Class<T> cls) {
        return new b<>(cls, new Class[0], null);
    }

    @SafeVarargs
    /* JADX INFO: renamed from: c */
    public static <T> C4572d<T> m6349c(final T t, Class<T> cls, Class<? super T>... clsArr) {
        b bVar = new b(cls, clsArr, null);
        bVar.m6353c(new InterfaceC4574f(t) { // from class: b.i.c.l.b

            /* JADX INFO: renamed from: a */
            public final Object f12173a;

            {
                this.f12173a = t;
            }

            @Override // p007b.p225i.p361c.p368l.InterfaceC4574f
            /* JADX INFO: renamed from: a */
            public Object mo6341a(InterfaceC4573e interfaceC4573e) {
                return this.f12173a;
            }
        });
        return bVar.m6352b();
    }

    /* JADX INFO: renamed from: b */
    public boolean m6350b() {
        return this.f12178d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f12175a.toArray()) + ">{" + this.f12177c + ", type=" + this.f12178d + ", deps=" + Arrays.toString(this.f12176b.toArray()) + "}";
    }
}
