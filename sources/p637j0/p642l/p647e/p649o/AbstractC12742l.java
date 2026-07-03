package p637j0.p642l.p647e.p649o;

/* JADX INFO: renamed from: j0.l.e.o.l */
/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12742l<E> extends AbstractC12740j<E> {

    /* JADX INFO: renamed from: o */
    public static final long f27340o = C12755y.m10857a(AbstractC12742l.class, "producerIndex");
    private volatile long producerIndex;

    public AbstractC12742l(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: i */
    public final long m10842i() {
        return this.producerIndex;
    }

    /* JADX INFO: renamed from: j */
    public final void m10843j(long j) {
        C12755y.f27357a.putOrderedLong(this, f27340o, j);
    }
}
