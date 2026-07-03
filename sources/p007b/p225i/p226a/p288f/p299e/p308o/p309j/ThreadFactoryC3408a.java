package p007b.p225i.p226a.p288f.p299e.p308o.p309j;

import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.o.j.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ThreadFactoryC3408a implements ThreadFactory {

    /* JADX INFO: renamed from: j */
    public final String f9602j;

    /* JADX INFO: renamed from: k */
    public final ThreadFactory f9603k = Executors.defaultThreadFactory();

    public ThreadFactoryC3408a(@RecentlyNonNull String str) {
        C1460d.m595z(str, "Name must not be null");
        this.f9602j = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @RecentlyNonNull
    public final Thread newThread(@RecentlyNonNull Runnable runnable) {
        Thread threadNewThread = this.f9603k.newThread(new RunnableC3409b(runnable));
        threadNewThread.setName(this.f9602j);
        return threadNewThread;
    }
}
