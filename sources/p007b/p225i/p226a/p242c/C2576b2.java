package p007b.p225i.p226a.p242c;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.concurrent.TimeoutException;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2732b0;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g;

/* JADX INFO: renamed from: b.i.a.c.b2 */
/* JADX INFO: compiled from: PlayerMessage.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2576b2 {

    /* JADX INFO: renamed from: a */
    public final b f5742a;

    /* JADX INFO: renamed from: b */
    public final a f5743b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2740g f5744c;

    /* JADX INFO: renamed from: d */
    public final AbstractC2832o2 f5745d;

    /* JADX INFO: renamed from: e */
    public int f5746e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public Object f5747f;

    /* JADX INFO: renamed from: g */
    public Looper f5748g;

    /* JADX INFO: renamed from: h */
    public int f5749h;

    /* JADX INFO: renamed from: i */
    public boolean f5750i;

    /* JADX INFO: renamed from: j */
    public boolean f5751j;

    /* JADX INFO: renamed from: k */
    public boolean f5752k;

    /* JADX INFO: renamed from: b.i.a.c.b2$a */
    /* JADX INFO: compiled from: PlayerMessage.java */
    public interface a {
    }

    /* JADX INFO: renamed from: b.i.a.c.b2$b */
    /* JADX INFO: compiled from: PlayerMessage.java */
    public interface b {
        /* JADX INFO: renamed from: r */
        void mo2603r(int i, @Nullable Object obj) throws ExoPlaybackException;
    }

    public C2576b2(a aVar, b bVar, AbstractC2832o2 abstractC2832o2, int i, InterfaceC2740g interfaceC2740g, Looper looper) {
        this.f5743b = aVar;
        this.f5742a = bVar;
        this.f5745d = abstractC2832o2;
        this.f5748g = looper;
        this.f5744c = interfaceC2740g;
        this.f5749h = i;
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean m2597a(long j) throws InterruptedException, TimeoutException {
        boolean z2;
        C1460d.m426D(this.f5750i);
        C1460d.m426D(this.f5748g.getThread() != Thread.currentThread());
        long jMo2952d = this.f5744c.mo2952d() + j;
        while (true) {
            z2 = this.f5752k;
            if (z2 || j <= 0) {
                break;
            }
            this.f5744c.mo2951c();
            wait(j);
            j = jMo2952d - this.f5744c.mo2952d();
        }
        if (!z2) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.f5751j;
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m2598b() {
        return false;
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m2599c(boolean z2) {
        this.f5751j = z2 | this.f5751j;
        this.f5752k = true;
        notifyAll();
    }

    /* JADX INFO: renamed from: d */
    public C2576b2 m2600d() {
        C1460d.m426D(!this.f5750i);
        C1460d.m531j(true);
        this.f5750i = true;
        C2803h1 c2803h1 = (C2803h1) this.f5743b;
        synchronized (c2803h1) {
            if (c2803h1.f7060I || !c2803h1.f7084r.isAlive()) {
                Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
                m2599c(false);
            } else {
                ((C2732b0.b) c2803h1.f7083q.mo2962i(14, this)).m2965b();
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: e */
    public C2576b2 m2601e(@Nullable Object obj) {
        C1460d.m426D(!this.f5750i);
        this.f5747f = obj;
        return this;
    }

    /* JADX INFO: renamed from: f */
    public C2576b2 m2602f(int i) {
        C1460d.m426D(!this.f5750i);
        this.f5746e = i;
        return this;
    }
}
