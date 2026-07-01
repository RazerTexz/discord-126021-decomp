package b.i.a.f.h.l;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j7$a extends j7$c {
    public j7$a(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // b.i.a.f.h.l.j7$c
    public final byte a(Object obj, long j) {
        return j7.i ? j7.t(obj, j) : j7.u(obj, j);
    }

    @Override // b.i.a.f.h.l.j7$c
    public final void b(Object obj, long j, byte b2) {
        if (j7.i) {
            j7.l(obj, j, b2);
        } else {
            j7.o(obj, j, b2);
        }
    }

    @Override // b.i.a.f.h.l.j7$c
    public final void c(Object obj, long j, double d) {
        f(obj, j, Double.doubleToLongBits(d));
    }

    @Override // b.i.a.f.h.l.j7$c
    public final void d(Object obj, long j, float f) {
        e(obj, j, Float.floatToIntBits(f));
    }

    @Override // b.i.a.f.h.l.j7$c
    public final void g(Object obj, long j, boolean z2) {
        if (j7.i) {
            j7.l(obj, j, z2 ? (byte) 1 : (byte) 0);
        } else {
            j7.o(obj, j, z2 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // b.i.a.f.h.l.j7$c
    public final boolean h(Object obj, long j) {
        if (j7.i) {
            return j7.t(obj, j) != 0;
        }
        return j7.u(obj, j) != 0;
    }

    @Override // b.i.a.f.h.l.j7$c
    public final float i(Object obj, long j) {
        return Float.intBitsToFloat(k(obj, j));
    }

    @Override // b.i.a.f.h.l.j7$c
    public final double j(Object obj, long j) {
        return Double.longBitsToDouble(l(obj, j));
    }
}
