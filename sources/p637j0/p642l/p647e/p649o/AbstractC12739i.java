package p637j0.p642l.p647e.p649o;

/* JADX INFO: renamed from: j0.l.e.o.i */
/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12739i<E> extends AbstractC12741k<E> {

    /* JADX INFO: renamed from: p */
    public static final long f27339p = C12755y.m10857a(AbstractC12739i.class, "consumerIndex");
    private volatile long consumerIndex;

    public AbstractC12739i(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: k */
    public final boolean m10840k(long j, long j2) {
        return C12755y.f27357a.compareAndSwapLong(this, f27339p, j, j2);
    }

    /* JADX INFO: renamed from: l */
    public final long m10841l() {
        return this.consumerIndex;
    }
}
