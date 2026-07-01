package j0.l.c;

import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: NewThreadWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$a implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = g.l.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (next.isShutdown()) {
                    it.remove();
                } else {
                    next.purge();
                }
            }
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            j0.o.l.b(th);
        }
    }
}
