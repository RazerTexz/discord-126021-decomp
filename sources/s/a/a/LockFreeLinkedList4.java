package s.a.a;

import b.d.b.a.outline;

/* JADX INFO: renamed from: s.a.a.q, reason: use source file name */
/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LockFreeLinkedList4 {
    public final LockFreeLinkedList3 a;

    public LockFreeLinkedList4(LockFreeLinkedList3 lockFreeLinkedList3) {
        this.a = lockFreeLinkedList3;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Removed[");
        sbU.append(this.a);
        sbU.append(']');
        return sbU.toString();
    }
}
