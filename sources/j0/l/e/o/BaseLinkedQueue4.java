package j0.l.e.o;

import j0.l.e.n.LinkedQueueNode;

/* JADX INFO: renamed from: j0.l.e.o.d, reason: use source file name */
/* JADX INFO: compiled from: BaseLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLinkedQueue4<E> extends BaseLinkedQueue2<E> {
    public static final long j = UnsafeAccess.a(BaseLinkedQueue4.class, "producerNode");
    public LinkedQueueNode<E> producerNode;

    public final LinkedQueueNode<E> c() {
        return (LinkedQueueNode) UnsafeAccess.a.getObjectVolatile(this, j);
    }
}
