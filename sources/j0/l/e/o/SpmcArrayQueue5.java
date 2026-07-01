package j0.l.e.o;

/* JADX INFO: renamed from: j0.l.e.o.l, reason: use source file name */
/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SpmcArrayQueue5<E> extends SpmcArrayQueue3<E> {
    public static final long o = UnsafeAccess.a(SpmcArrayQueue5.class, "producerIndex");
    private volatile long producerIndex;

    public SpmcArrayQueue5(int i) {
        super(i);
    }

    public final long i() {
        return this.producerIndex;
    }

    public final void j(long j) {
        UnsafeAccess.a.putOrderedLong(this, o, j);
    }
}
