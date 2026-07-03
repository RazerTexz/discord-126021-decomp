package p007b.p109f.p161j.p181p;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.h1 */
/* JADX INFO: compiled from: ThreadHandoffProducerQueueImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1985h1 implements InterfaceC1982g1 {

    /* JADX INFO: renamed from: a */
    public final Deque<Runnable> f4073a;

    /* JADX INFO: renamed from: b */
    public final Executor f4074b;

    public C1985h1(Executor executor) {
        Objects.requireNonNull(executor);
        this.f4074b = executor;
        this.f4073a = new ArrayDeque();
    }
}
