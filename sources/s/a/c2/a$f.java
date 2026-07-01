package s.a.c2;

import s.a.a.k$a;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$f extends k$a {
    public final /* synthetic */ a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$f(s.a.a.k kVar, s.a.a.k kVar2, a aVar) {
        super(kVar2);
        this.d = aVar;
    }

    @Override // s.a.a.d
    public Object c(s.a.a.k kVar) {
        if (this.d.t()) {
            return null;
        }
        return s.a.a.j.a;
    }
}
