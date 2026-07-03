package p007b.p100d.p101a.p102a;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b.d.a.a.k */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class ThreadFactoryC1626k implements ThreadFactory {

    /* JADX INFO: renamed from: j */
    public final ThreadFactory f2964j = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: k */
    public final AtomicInteger f2965k = new AtomicInteger(1);

    public ThreadFactoryC1626k(C1614a c1614a) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f2964j.newThread(runnable);
        int andIncrement = this.f2965k.getAndIncrement();
        StringBuilder sb = new StringBuilder(30);
        sb.append("PlayBillingLibrary-");
        sb.append(andIncrement);
        threadNewThread.setName(sb.toString());
        return threadNewThread;
    }
}
