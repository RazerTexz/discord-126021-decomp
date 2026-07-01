package j0.l.e.o;

/* JADX INFO: compiled from: BaseLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<E> extends c<E> {
    public static final long k = y.a(a.class, "consumerNode");
    public j0.l.e.n.b<E> consumerNode;

    public final j0.l.e.n.b<E> d() {
        return (j0.l.e.n.b) y.a.getObjectVolatile(this, k);
    }
}
