package b.m.a.g.d;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: SntpService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$b implements ThreadFactory {
    public static final i$b j = new i$b();

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "kronos-android");
    }
}
