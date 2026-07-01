package b.f.l.a;

import b.f.l.b.c;

/* JADX INFO: compiled from: MultiPointerGestureDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f647b;
    public final int[] c = new int[2];
    public final float[] d = new float[2];
    public final float[] e = new float[2];
    public final float[] f = new float[2];
    public final float[] g = new float[2];
    public a$a h = null;

    public a() {
        a();
    }

    public void a() {
        this.a = false;
        this.f647b = 0;
        for (int i = 0; i < 2; i++) {
            this.c[i] = -1;
        }
    }

    public final void b() {
        b bVar;
        b$a b_a;
        if (this.a) {
            return;
        }
        a$a a_a = this.h;
        if (a_a != null && (b_a = (bVar = (b) a_a).f648b) != null) {
            b_a.c(bVar);
        }
        this.a = true;
    }

    public final void c() {
        b$a b_a;
        if (this.a) {
            this.a = false;
            a$a a_a = this.h;
            if (a_a == null || (b_a = ((b) a_a).f648b) == null) {
                return;
            }
            b.f.d.e.a.i(c.class, "onGestureEnd");
        }
    }
}
