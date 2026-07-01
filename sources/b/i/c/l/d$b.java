package b.i.c.l;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: Component.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$b<T> {
    public final Set<Class<? super T>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<o> f1663b;
    public int c;
    public int d;
    public f<T> e;
    public Set<Class<?>> f;

    public d$b(Class cls, Class[] clsArr, d$a d_a) {
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

    public d$b<T> a(o oVar) {
        if (!(!this.a.contains(oVar.a))) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        this.f1663b.add(oVar);
        return this;
    }

    public d<T> b() {
        if (this.e != null) {
            return new d<>(new HashSet(this.a), new HashSet(this.f1663b), this.c, this.d, this.e, this.f, null);
        }
        throw new IllegalStateException("Missing required property: factory.");
    }

    public d$b<T> c(f<T> fVar) {
        this.e = fVar;
        return this;
    }

    public final d$b<T> d(int i) {
        if (!(this.c == 0)) {
            throw new IllegalStateException("Instantiation type has already been set.");
        }
        this.c = i;
        return this;
    }
}
