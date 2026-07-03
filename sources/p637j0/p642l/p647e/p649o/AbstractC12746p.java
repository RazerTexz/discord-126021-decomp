package p637j0.p642l.p647e.p649o;

/* JADX INFO: renamed from: j0.l.e.o.p */
/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12746p<E> {

    /* JADX INFO: renamed from: o */
    public static final Integer f27343o = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    public AbstractC12746p(int i) {
        super(i);
        Math.min(i / 4, f27343o.intValue());
    }
}
