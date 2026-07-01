package j0.l.e.o;

/* JADX INFO: renamed from: j0.l.e.o.i, reason: use source file name */
/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SpmcArrayQueue2<E> extends SpmcArrayQueue4<E> {
    public static final long p = UnsafeAccess.a(SpmcArrayQueue2.class, "consumerIndex");
    private volatile long consumerIndex;

    public SpmcArrayQueue2(int i) {
        super(i);
    }

    public final boolean k(long j, long j2) {
        return UnsafeAccess.a.compareAndSwapLong(this, p, j, j2);
    }

    public final long l() {
        return this.consumerIndex;
    }
}
