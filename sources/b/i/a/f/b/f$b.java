package b.i.a.f.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class f$b implements ThreadFactory {
    public static final AtomicInteger j = new AtomicInteger();

    public f$b(g gVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new f$c(runnable, b.d.b.a.a.g(23, "measurement-", j.incrementAndGet()));
    }
}
