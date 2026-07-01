package androidx.loader.content;

import b.d.b.a.a;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ModernAsyncTask$1 implements ThreadFactory {
    private final AtomicInteger mCount = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        StringBuilder sbU = a.U("ModernAsyncTask #");
        sbU.append(this.mCount.getAndIncrement());
        return new Thread(runnable, sbU.toString());
    }
}
