package j0.l.e;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: RxThreadFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class j$a implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        throw new AssertionError("No threads allowed.");
    }
}
