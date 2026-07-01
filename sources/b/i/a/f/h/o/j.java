package b.i.a.f.h.o;

import android.os.RemoteException;
import b.i.a.f.e.h.a$b;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends i$a {
    public final /* synthetic */ String m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(b.i.a.f.e.h.c cVar, String str) {
        super(cVar);
        this.m = str;
    }

    @Override // b.i.a.f.e.h.j.d
    public final /* synthetic */ void k(a$b a_b) throws RemoteException {
        ((g) ((l) a_b).w()).n0(this.l, this.m);
    }
}
