package p637j0.p642l.p647e.p649o;

import p637j0.p642l.p647e.p648n.C12725b;

/* JADX INFO: renamed from: j0.l.e.o.a */
/* JADX INFO: compiled from: BaseLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12731a<E> extends AbstractC12733c<E> {

    /* JADX INFO: renamed from: k */
    public static final long f27332k = C12755y.m10857a(AbstractC12731a.class, "consumerNode");
    public C12725b<E> consumerNode;

    /* JADX INFO: renamed from: d */
    public final C12725b<E> m10833d() {
        return (C12725b) C12755y.f27357a.getObjectVolatile(this, f27332k);
    }
}
