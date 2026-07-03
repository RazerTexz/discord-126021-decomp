package p007b.p085c.p086a;

import java.util.ArrayList;
import java.util.Iterator;
import p007b.p085c.p086a.p089b0.C1495c;

/* JADX INFO: renamed from: b.c.a.q */
/* JADX INFO: compiled from: LottieTask.java */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC1518q implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1519r f2451j;

    public RunnableC1518q(C1519r c1519r) {
        this.f2451j = c1519r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        if (this.f2451j.f2456e == null) {
            return;
        }
        C1517p<T> c1517p = this.f2451j.f2456e;
        V v = c1517p.f2449a;
        if (v != 0) {
            C1519r c1519r = this.f2451j;
            synchronized (c1519r) {
                Iterator it = new ArrayList(c1519r.f2453b).iterator();
                while (it.hasNext()) {
                    ((InterfaceC1513l) it.next()).mo680a(v);
                }
            }
            return;
        }
        C1519r c1519r2 = this.f2451j;
        Throwable th = c1517p.f2450b;
        synchronized (c1519r2) {
            ArrayList arrayList = new ArrayList(c1519r2.f2454c);
            if (arrayList.isEmpty()) {
                C1495c.m641c("Lottie encountered an error but no failure listener was added:", th);
                return;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((InterfaceC1513l) it2.next()).mo680a(th);
            }
        }
    }
}
