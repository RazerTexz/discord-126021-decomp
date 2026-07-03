package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Process;
import androidx.annotation.GuardedBy;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: renamed from: b.i.a.f.i.b.v4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4213v4 extends Thread {

    /* JADX INFO: renamed from: j */
    public final Object f11300j;

    /* JADX INFO: renamed from: k */
    public final BlockingQueue<C4180s4<?>> f11301k;

    /* JADX INFO: renamed from: l */
    @GuardedBy("threadLifeCycleLock")
    public boolean f11302l = false;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C4169r4 f11303m;

    public C4213v4(C4169r4 c4169r4, String str, BlockingQueue<C4180s4<?>> blockingQueue) {
        this.f11303m = c4169r4;
        Objects.requireNonNull(blockingQueue, "null reference");
        this.f11300j = new Object();
        this.f11301k = blockingQueue;
        setName(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m5956a(InterruptedException interruptedException) {
        this.f11303m.mo5726g().f11144i.m5861b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    /* JADX INFO: renamed from: b */
    public final void m5957b() {
        synchronized (this.f11303m.f11174j) {
            if (!this.f11302l) {
                this.f11303m.f11175k.release();
                this.f11303m.f11174j.notifyAll();
                C4169r4 c4169r4 = this.f11303m;
                if (this == c4169r4.f11168d) {
                    c4169r4.f11168d = null;
                } else if (this == c4169r4.f11169e) {
                    c4169r4.f11169e = null;
                } else {
                    c4169r4.mo5726g().f11141f.m5860a("Current scheduler thread is neither worker nor network");
                }
                this.f11302l = true;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z2 = false;
        while (!z2) {
            try {
                this.f11303m.f11175k.acquire();
                z2 = true;
            } catch (InterruptedException e) {
                m5956a(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                C4180s4<?> c4180s4Poll = this.f11301k.poll();
                if (c4180s4Poll == null) {
                    synchronized (this.f11300j) {
                        if (this.f11301k.peek() == null) {
                            Objects.requireNonNull(this.f11303m);
                            try {
                                this.f11300j.wait(30000L);
                            } catch (InterruptedException e2) {
                                m5956a(e2);
                            }
                        }
                    }
                    synchronized (this.f11303m.f11174j) {
                        if (this.f11301k.peek() == null) {
                            break;
                        }
                    }
                } else {
                    Process.setThreadPriority(c4180s4Poll.f11199k ? threadPriority : 10);
                    c4180s4Poll.run();
                }
            }
            if (this.f11303m.f11202a.f11260h.m5526o(C4142p.f11096r0)) {
                m5957b();
            }
            m5957b();
        } catch (Throwable th) {
            m5957b();
            throw th;
        }
    }
}
