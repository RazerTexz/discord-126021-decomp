package b.i.a.f.h.l;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends g$a {
    public final /* synthetic */ String n;
    public final /* synthetic */ String o;
    public final /* synthetic */ boolean p;
    public final /* synthetic */ cc q;
    public final /* synthetic */ g r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(g gVar, String str, String str2, boolean z2, cc ccVar) {
        super(gVar, true);
        this.r = gVar;
        this.n = str;
        this.o = str2;
        this.p = z2;
        this.q = ccVar;
    }

    @Override // b.i.a.f.h.l.g$a
    public final void a() throws RemoteException {
        this.r.j.getUserProperties(this.n, this.o, this.p, this.q);
    }

    @Override // b.i.a.f.h.l.g$a
    public final void b() {
        this.q.f(null);
    }
}
