package s.a;

import b.d.b.a.a;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0$c implements Runnable, Comparable<r0$c>, m0, s.a.a.w {
    public Object j;
    public int k = -1;
    public long l;

    public r0$c(long j) {
        this.l = j;
    }

    @Override // java.lang.Comparable
    public int compareTo(r0$c r0_c) {
        long j = this.l - r0_c.l;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }

    @Override // s.a.m0
    public final synchronized void dispose() {
        Object obj = this.j;
        s.a.a.t tVar = t0.a;
        if (obj == tVar) {
            return;
        }
        if (!(obj instanceof r0$d)) {
            obj = null;
        }
        r0$d r0_d = (r0$d) obj;
        if (r0_d != null) {
            synchronized (r0_d) {
                if (i() != null) {
                    r0_d.c(getIndex());
                }
            }
        }
        this.j = tVar;
    }

    @Override // s.a.a.w
    public void f(int i) {
        this.k = i;
    }

    @Override // s.a.a.w
    public void g(s.a.a.v<?> vVar) {
        if (!(this.j != t0.a)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.j = vVar;
    }

    @Override // s.a.a.w
    public int getIndex() {
        return this.k;
    }

    @Override // s.a.a.w
    public s.a.a.v<?> i() {
        Object obj = this.j;
        if (!(obj instanceof s.a.a.v)) {
            obj = null;
        }
        return (s.a.a.v) obj;
    }

    public String toString() {
        StringBuilder sbU = a.U("Delayed[nanos=");
        sbU.append(this.l);
        sbU.append(']');
        return sbU.toString();
    }
}
