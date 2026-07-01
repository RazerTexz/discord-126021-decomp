package s.a;

import s.a.a.k$a;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h1$c extends k$a {
    public final /* synthetic */ h1 d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1$c(s.a.a.k kVar, s.a.a.k kVar2, h1 h1Var, Object obj) {
        super(kVar2);
        this.d = h1Var;
        this.e = obj;
    }

    @Override // s.a.a.d
    public Object c(s.a.a.k kVar) {
        if (this.d.M() == this.e) {
            return null;
        }
        return s.a.a.j.a;
    }
}
