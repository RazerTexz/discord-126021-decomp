package f0.e0;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements ThreadFactory {
    public final /* synthetic */ String j;
    public final /* synthetic */ boolean k;

    public b(String str, boolean z2) {
        this.j = str;
        this.k = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.j);
        thread.setDaemon(this.k);
        return thread;
    }
}
