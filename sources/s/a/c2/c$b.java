package s.a.c2;

import s.a.a.k$a;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b extends k$a {
    public final /* synthetic */ c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$b(s.a.a.k kVar, s.a.a.k kVar2, c cVar) {
        super(kVar2);
        this.d = cVar;
    }

    @Override // s.a.a.d
    public Object c(s.a.a.k kVar) {
        if (this.d.i()) {
            return null;
        }
        return s.a.a.j.a;
    }
}
