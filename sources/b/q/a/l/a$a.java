package b.q.a.l;

import b.i.a.f.e.o.f;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: CropImageView.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a implements Runnable {
    public final WeakReference<a> j;
    public final long k;
    public final long l = System.currentTimeMillis();
    public final float m;
    public final float n;
    public final float o;
    public final float p;
    public final float q;
    public final float r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f1989s;

    public a$a(a aVar, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z2) {
        this.j = new WeakReference<>(aVar);
        this.k = j;
        this.m = f;
        this.n = f2;
        this.o = f3;
        this.p = f4;
        this.q = f5;
        this.r = f6;
        this.f1989s = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.j.get();
        if (aVar == null) {
            return;
        }
        float fMin = Math.min(this.k, System.currentTimeMillis() - this.l);
        float f = this.o;
        float f2 = this.k;
        float f3 = (fMin / f2) - 1.0f;
        float f4 = (f3 * f3 * f3) + 1.0f;
        float f5 = (f * f4) + 0.0f;
        float f6 = (f4 * this.p) + 0.0f;
        float fT = f.T(fMin, 0.0f, this.r, f2);
        if (fMin < this.k) {
            float[] fArr = aVar.k;
            aVar.g(f5 - (fArr[0] - this.m), f6 - (fArr[1] - this.n));
            if (!this.f1989s) {
                aVar.l(this.q + fT, aVar.f1987y.centerX(), aVar.f1987y.centerY());
            }
            if (aVar.j(aVar.j)) {
                return;
            }
            aVar.post(this);
        }
    }
}
