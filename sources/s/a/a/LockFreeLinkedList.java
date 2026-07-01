package s.a.a;

/* JADX INFO: renamed from: s.a.a.i, reason: use source file name */
/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public class LockFreeLinkedList extends LockFreeLinkedList3 {
    @Override // s.a.a.LockFreeLinkedList3
    public boolean m() {
        return false;
    }

    @Override // s.a.a.LockFreeLinkedList3
    public final boolean n() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}
