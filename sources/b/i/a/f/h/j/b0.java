package b.i.a.f.h.j;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ a0 j;

    public b0(a0 a0Var) {
        this.j = a0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.j.f1409b.d().a(this);
            return;
        }
        boolean zD = this.j.d();
        this.j.d = 0L;
        if (zD) {
            this.j.c();
        }
    }
}
