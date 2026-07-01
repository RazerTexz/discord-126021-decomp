package b.i.b.d.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: renamed from: b.i.b.d.a.a, reason: use source file name */
/* JADX INFO: compiled from: ListenableFuture.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ListenableFuture8<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
