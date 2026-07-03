package p637j0.p642l.p647e.p649o;

import p637j0.p642l.p647e.p648n.C12725b;

/* JADX INFO: renamed from: j0.l.e.o.d */
/* JADX INFO: compiled from: BaseLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12734d<E> extends AbstractC12732b<E> {

    /* JADX INFO: renamed from: j */
    public static final long f27333j = C12755y.m10857a(AbstractC12734d.class, "producerNode");
    public C12725b<E> producerNode;

    /* JADX INFO: renamed from: c */
    public final C12725b<E> m10834c() {
        return (C12725b) C12755y.f27357a.getObjectVolatile(this, f27333j);
    }
}
