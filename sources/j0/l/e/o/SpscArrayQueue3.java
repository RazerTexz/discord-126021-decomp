package j0.l.e.o;

/* JADX INFO: renamed from: j0.l.e.o.p, reason: use source file name */
/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SpscArrayQueue3<E> {
    public static final Integer o = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    public SpscArrayQueue3(int i) {
        super(i);
        Math.min(i / 4, o.intValue());
    }
}
