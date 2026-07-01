package b.i.a.c;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.f3.b0$b;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PlayerMessage.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b2 {
    public final b2$b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b2$a f837b;
    public final b.i.a.c.f3.g c;
    public final o2 d;
    public int e;

    @Nullable
    public Object f;
    public Looper g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;

    public b2(b2$a b2_a, b2$b b2_b, o2 o2Var, int i, b.i.a.c.f3.g gVar, Looper looper) {
        this.f837b = b2_a;
        this.a = b2_b;
        this.d = o2Var;
        this.g = looper;
        this.c = gVar;
        this.h = i;
    }

    public synchronized boolean a(long j) throws InterruptedException, TimeoutException {
        boolean z2;
        b.c.a.a0.d.D(this.i);
        b.c.a.a0.d.D(this.g.getThread() != Thread.currentThread());
        long jD = this.c.d() + j;
        while (true) {
            z2 = this.k;
            if (z2 || j <= 0) {
                break;
            }
            this.c.c();
            wait(j);
            j = jD - this.c.d();
        }
        if (!z2) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.j;
    }

    public synchronized boolean b() {
        return false;
    }

    public synchronized void c(boolean z2) {
        this.j = z2 | this.j;
        this.k = true;
        notifyAll();
    }

    public b2 d() {
        b.c.a.a0.d.D(!this.i);
        b.c.a.a0.d.j(true);
        this.i = true;
        h1 h1Var = (h1) this.f837b;
        synchronized (h1Var) {
            if (h1Var.I || !h1Var.r.isAlive()) {
                Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
                c(false);
            } else {
                ((b0$b) h1Var.q.i(14, this)).b();
            }
        }
        return this;
    }

    public b2 e(@Nullable Object obj) {
        b.c.a.a0.d.D(!this.i);
        this.f = obj;
        return this;
    }

    public b2 f(int i) {
        b.c.a.a0.d.D(!this.i);
        this.e = i;
        return this;
    }
}
