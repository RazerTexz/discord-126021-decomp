package d0.e0.p.d.m0.f.z;

/* JADX INFO: compiled from: Flags.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b$d<E> {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3417b;

    public b$d(int i, int i2, b$a b_a) {
        this.a = i;
        this.f3417b = i2;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ld0/e0/p/d/m0/i/h$a;>(Ld0/e0/p/d/m0/f/z/b$d<*>;[TE;)Ld0/e0/p/d/m0/f/z/b$d<TE;>; */
    public static b$d after(b$d b_d, d0.e0.p.d.m0.i.h$a[] h_aArr) {
        return new b$c(b_d.a + b_d.f3417b, h_aArr);
    }

    public static b$b booleanAfter(b$d<?> b_d) {
        return new b$b(b_d.a + b_d.f3417b);
    }

    public static b$b booleanFirst() {
        return new b$b(0);
    }

    public abstract E get(int i);

    public abstract int toFlags(E e);
}
