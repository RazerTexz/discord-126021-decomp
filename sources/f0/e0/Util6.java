package f0.e0;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: f0.e0.b, reason: use source file name */
/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Util6 implements ThreadFactory {
    public final /* synthetic */ String j;
    public final /* synthetic */ boolean k;

    public Util6(String str, boolean z2) {
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
