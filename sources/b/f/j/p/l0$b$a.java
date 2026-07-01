package b.f.j.p;

import java.io.Closeable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: MultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class l0$b$a<T> extends b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l0$b f624b;

    public l0$b$a(l0$b l0_b, l0$a l0_a) {
        this.f624b = l0_b;
    }

    @Override // b.f.j.p.b
    public void g() {
        try {
            b.f.j.r.b.b();
            l0$b l0_b = this.f624b;
            synchronized (l0_b) {
                if (l0_b.g == this) {
                    l0_b.g = null;
                    l0_b.f = null;
                    l0_b.b(l0_b.c);
                    l0_b.c = null;
                    l0_b.i(b.f.d.l.a.UNSET);
                }
            }
            b.f.j.r.b.b();
        } catch (Throwable th) {
            b.f.j.r.b.b();
            throw th;
        }
    }

    @Override // b.f.j.p.b
    public void h(Throwable th) {
        try {
            b.f.j.r.b.b();
            this.f624b.f(this, th);
        } finally {
            b.f.j.r.b.b();
        }
    }

    @Override // b.f.j.p.b
    public void i(Object obj, int i) {
        Closeable closeable = (Closeable) obj;
        try {
            b.f.j.r.b.b();
            this.f624b.g(this, closeable, i);
        } finally {
            b.f.j.r.b.b();
        }
    }

    @Override // b.f.j.p.b
    public void j(float f) {
        try {
            b.f.j.r.b.b();
            this.f624b.h(this, f);
        } finally {
            b.f.j.r.b.b();
        }
    }
}
