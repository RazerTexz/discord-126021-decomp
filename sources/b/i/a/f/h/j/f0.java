package b.i.a.f.h.j;

/* JADX INFO: loaded from: classes3.dex */
public final class f0<V> {
    public final V a;

    public f0(b.i.a.f.e.i.a<V> aVar, V v) {
        this.a = v;
    }

    public static f0<Integer> a(String str, int i, int i2) {
        return new f0<>(new b.i.a.f.e.i.d(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    public static f0<Long> b(String str, long j, long j2) {
        return new f0<>(new b.i.a.f.e.i.c(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    public static f0<String> c(String str, String str2, String str3) {
        return new f0<>(new b.i.a.f.e.i.f(str, str3), str2);
    }

    public static f0<Boolean> d(String str, boolean z2, boolean z3) {
        return new f0<>(new b.i.a.f.e.i.b(str, Boolean.valueOf(z3)), Boolean.valueOf(z2));
    }
}
