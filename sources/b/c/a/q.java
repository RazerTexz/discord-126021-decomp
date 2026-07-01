package b.c.a;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: LottieTask.java */
/* JADX INFO: loaded from: classes.dex */
public class q implements Runnable {
    public final /* synthetic */ r j;

    public q(r rVar) {
        this.j = rVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        if (this.j.e == null) {
            return;
        }
        p<T> pVar = this.j.e;
        V v = pVar.a;
        if (v != 0) {
            r rVar = this.j;
            synchronized (rVar) {
                Iterator it = new ArrayList(rVar.f374b).iterator();
                while (it.hasNext()) {
                    ((l) it.next()).a(v);
                }
            }
            return;
        }
        r rVar2 = this.j;
        Throwable th = pVar.f373b;
        synchronized (rVar2) {
            ArrayList arrayList = new ArrayList(rVar2.c);
            if (arrayList.isEmpty()) {
                b.c.a.b0.c.c("Lottie encountered an error but no failure listener was added:", th);
                return;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((l) it2.next()).a(th);
            }
        }
    }
}
