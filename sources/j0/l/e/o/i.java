package j0.l.e.o;

/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i<E> extends k<E> {
    public static final long p = y.a(i.class, "consumerIndex");
    private volatile long consumerIndex;

    public i(int i) {
        super(i);
    }

    public final boolean k(long j, long j2) {
        return y.a.compareAndSwapLong(this, p, j, j2);
    }

    public final long l() {
        return this.consumerIndex;
    }
}
