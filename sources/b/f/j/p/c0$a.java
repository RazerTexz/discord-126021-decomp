package b.f.j.p;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: compiled from: JobScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0$a implements Runnable {
    public final /* synthetic */ c0 j;

    public c0$a(c0 c0Var) {
        this.j = c0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.f.j.j.e eVar;
        int i;
        c0 c0Var = this.j;
        Objects.requireNonNull(c0Var);
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (c0Var) {
            eVar = c0Var.f;
            i = c0Var.g;
            c0Var.f = null;
            c0Var.g = 0;
            c0Var.h = 3;
            c0Var.j = jUptimeMillis;
        }
        try {
            if (c0.e(eVar, i)) {
                c0Var.f606b.a(eVar, i);
            }
        } finally {
            if (eVar != null) {
                eVar.close();
            }
            c0Var.c();
        }
    }
}
