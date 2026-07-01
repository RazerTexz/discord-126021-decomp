package b.i.a.f.h.l;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j7$c {
    public Unsafe a;

    public j7$c(Unsafe unsafe) {
        this.a = unsafe;
    }

    public abstract byte a(Object obj, long j);

    public abstract void b(Object obj, long j, byte b2);

    public abstract void c(Object obj, long j, double d);

    public abstract void d(Object obj, long j, float f);

    public final void e(Object obj, long j, int i) {
        this.a.putInt(obj, j, i);
    }

    public final void f(Object obj, long j, long j2) {
        this.a.putLong(obj, j, j2);
    }

    public abstract void g(Object obj, long j, boolean z2);

    public abstract boolean h(Object obj, long j);

    public abstract float i(Object obj, long j);

    public abstract double j(Object obj, long j);

    public final int k(Object obj, long j) {
        return this.a.getInt(obj, j);
    }

    public final long l(Object obj, long j) {
        return this.a.getLong(obj, j);
    }
}
