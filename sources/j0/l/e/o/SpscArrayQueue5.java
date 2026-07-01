package j0.l.e.o;

/* JADX INFO: renamed from: j0.l.e.o.r, reason: use source file name */
/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SpscArrayQueue5<E> extends SpscArrayQueue3<E> {
    public static final long p = UnsafeAccess.a(SpscArrayQueue5.class, "producerIndex");
    public long producerIndex;

    public SpscArrayQueue5(int i) {
        super(i);
    }
}
