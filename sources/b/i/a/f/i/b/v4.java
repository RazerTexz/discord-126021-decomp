package b.i.a.f.i.b;

import android.os.Process;
import androidx.annotation.GuardedBy;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v4 extends Thread {
    public final Object j;
    public final BlockingQueue<s4<?>> k;

    @GuardedBy("threadLifeCycleLock")
    public boolean l = false;
    public final /* synthetic */ r4 m;

    public v4(r4 r4Var, String str, BlockingQueue<s4<?>> blockingQueue) {
        this.m = r4Var;
        Objects.requireNonNull(blockingQueue, "null reference");
        this.j = new Object();
        this.k = blockingQueue;
        setName(str);
    }

    public final void a(InterruptedException interruptedException) {
        this.m.g().i.b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void b() {
        synchronized (this.m.j) {
            if (!this.l) {
                this.m.k.release();
                this.m.j.notifyAll();
                r4 r4Var = this.m;
                if (this == r4Var.d) {
                    r4Var.d = null;
                } else if (this == r4Var.e) {
                    r4Var.e = null;
                } else {
                    r4Var.g().f.a("Current scheduler thread is neither worker nor network");
                }
                this.l = true;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z2 = false;
        while (!z2) {
            try {
                this.m.k.acquire();
                z2 = true;
            } catch (InterruptedException e) {
                a(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                s4<?> s4VarPoll = this.k.poll();
                if (s4VarPoll == null) {
                    synchronized (this.j) {
                        if (this.k.peek() == null) {
                            Objects.requireNonNull(this.m);
                            try {
                                this.j.wait(30000L);
                            } catch (InterruptedException e2) {
                                a(e2);
                            }
                        }
                    }
                    synchronized (this.m.j) {
                        if (this.k.peek() == null) {
                            break;
                        }
                    }
                } else {
                    Process.setThreadPriority(s4VarPoll.k ? threadPriority : 10);
                    s4VarPoll.run();
                }
            }
            if (this.m.a.h.o(p.r0)) {
                b();
            }
            b();
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
