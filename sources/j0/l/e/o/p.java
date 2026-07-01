package j0.l.e.o;

/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p<E> {
    public static final Integer o = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    public p(int i) {
        super(i);
        Math.min(i / 4, o.intValue());
    }
}
