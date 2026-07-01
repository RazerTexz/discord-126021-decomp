package b.i.c.q;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.c.q.d, reason: use source file name */
/* JADX INFO: compiled from: Subscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Subscriber2 {
    <T> void a(Class<T> cls, EventHandler2<? super T> eventHandler2);

    <T> void b(Class<T> cls, Executor executor, EventHandler2<? super T> eventHandler2);
}
