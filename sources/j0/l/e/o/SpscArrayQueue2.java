package j0.l.e.o;

/* JADX INFO: renamed from: j0.l.e.o.o, reason: use source file name */
/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SpscArrayQueue2<E> extends SpscArrayQueue4<E> {
    public static final long q = UnsafeAccess.a(SpscArrayQueue2.class, "consumerIndex");
    public long consumerIndex;

    public SpscArrayQueue2(int i) {
        super(i);
    }
}
