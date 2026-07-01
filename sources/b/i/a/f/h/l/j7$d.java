package b.i.a.f.h.l;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j7$d extends j7$c {
    public j7$d(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // b.i.a.f.h.l.j7$c
    public final byte a(Object obj, long j) {
        return this.a.getByte(obj, j);
    }

    @Override // b.i.a.f.h.l.j7$c
    public final void b(Object obj, long j, byte b2) {
        this.a.putByte(obj, j, b2);
    }

    @Override // b.i.a.f.h.l.j7$c
    public final void c(Object obj, long j, double d) {
        this.a.putDouble(obj, j, d);
    }

    @Override // b.i.a.f.h.l.j7$c
    public final void d(Object obj, long j, float f) {
        this.a.putFloat(obj, j, f);
    }

    @Override // b.i.a.f.h.l.j7$c
    public final void g(Object obj, long j, boolean z2) {
        this.a.putBoolean(obj, j, z2);
    }

    @Override // b.i.a.f.h.l.j7$c
    public final boolean h(Object obj, long j) {
        return this.a.getBoolean(obj, j);
    }

    @Override // b.i.a.f.h.l.j7$c
    public final float i(Object obj, long j) {
        return this.a.getFloat(obj, j);
    }

    @Override // b.i.a.f.h.l.j7$c
    public final double j(Object obj, long j) {
        return this.a.getDouble(obj, j);
    }
}
