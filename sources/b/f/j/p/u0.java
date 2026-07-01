package b.f.j.p;

import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class u0 implements Runnable {
    public final /* synthetic */ t0$b j;

    public u0(t0$b t0_b) {
        this.j = t0_b;
    }

    @Override // java.lang.Runnable
    public void run() {
        CloseableReference<b.f.j.j.c> closeableReference;
        int i;
        boolean zS;
        synchronized (this.j) {
            t0$b t0_b = this.j;
            closeableReference = t0_b.g;
            i = t0_b.h;
            t0_b.g = null;
            t0_b.i = false;
        }
        if (CloseableReference.y(closeableReference)) {
            try {
                t0$b.n(this.j, closeableReference, i);
                closeableReference.close();
            } catch (Throwable th) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw th;
            }
        }
        t0$b t0_b2 = this.j;
        synchronized (t0_b2) {
            t0_b2.j = false;
            zS = t0_b2.s();
        }
        if (zS) {
            t0_b2.k.c.execute(new u0(t0_b2));
        }
    }
}
