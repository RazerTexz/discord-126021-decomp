package b.q.a.l;

import b.i.a.f.e.o.f;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: CropImageView.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$b implements Runnable {
    public final WeakReference<a> j;
    public final long k;
    public final long l = System.currentTimeMillis();
    public final float m;
    public final float n;
    public final float o;
    public final float p;

    public a$b(a aVar, long j, float f, float f2, float f3, float f4) {
        this.j = new WeakReference<>(aVar);
        this.k = j;
        this.m = f;
        this.n = f2;
        this.o = f3;
        this.p = f4;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.j.get();
        if (aVar == null) {
            return;
        }
        float fMin = Math.min(this.k, System.currentTimeMillis() - this.l);
        float fT = f.T(fMin, 0.0f, this.n, this.k);
        if (fMin >= this.k) {
            aVar.setImageToWrapCropBounds(true);
        } else {
            aVar.l(this.m + fT, this.o, this.p);
            aVar.post(this);
        }
    }
}
