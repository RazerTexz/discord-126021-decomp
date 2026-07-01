package b.i.c.l;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: Component.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d<T> {
    public final Set<Class<? super T>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<o> f1662b;
    public final int c;
    public final int d;
    public final f<T> e;
    public final Set<Class<?>> f;

    public d(Set set, Set set2, int i, int i2, f fVar, Set set3, d$a d_a) {
        this.a = Collections.unmodifiableSet(set);
        this.f1662b = Collections.unmodifiableSet(set2);
        this.c = i;
        this.d = i2;
        this.e = fVar;
        this.f = Collections.unmodifiableSet(set3);
    }

    public static <T> d$b<T> a(Class<T> cls) {
        return new d$b<>(cls, new Class[0], null);
    }

    @SafeVarargs
    public static <T> d<T> c(T t, Class<T> cls, Class<? super T>... clsArr) {
        d$b d_b = new d$b(cls, clsArr, null);
        d_b.c(new b(t));
        return d_b.b();
    }

    public boolean b() {
        return this.d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", type=" + this.d + ", deps=" + Arrays.toString(this.f1662b.toArray()) + "}";
    }
}
