package b.c.a;

import b.c.a.b0.Logger2;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: b.c.a.q, reason: use source file name */
/* JADX INFO: compiled from: LottieTask.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieTask implements Runnable {
    public final /* synthetic */ LottieTask2 j;

    public LottieTask(LottieTask2 lottieTask2) {
        this.j = lottieTask2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        if (this.j.e == null) {
            return;
        }
        LottieResult<T> lottieResult = this.j.e;
        V v = lottieResult.a;
        if (v != 0) {
            LottieTask2 lottieTask2 = this.j;
            synchronized (lottieTask2) {
                Iterator it = new ArrayList(lottieTask2.f374b).iterator();
                while (it.hasNext()) {
                    ((LottieListener) it.next()).a(v);
                }
            }
            return;
        }
        LottieTask2 lottieTask3 = this.j;
        Throwable th = lottieResult.f373b;
        synchronized (lottieTask3) {
            ArrayList arrayList = new ArrayList(lottieTask3.c);
            if (arrayList.isEmpty()) {
                Logger2.c("Lottie encountered an error but no failure listener was added:", th);
                return;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((LottieListener) it2.next()).a(th);
            }
        }
    }
}
