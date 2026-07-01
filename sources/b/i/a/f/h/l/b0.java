package b.i.a.f.h.l;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends g$a {
    public final /* synthetic */ String n;
    public final /* synthetic */ String o;
    public final /* synthetic */ Object p;
    public final /* synthetic */ boolean q;
    public final /* synthetic */ g r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(g gVar, String str, String str2, Object obj, boolean z2) {
        super(gVar, true);
        this.r = gVar;
        this.n = str;
        this.o = str2;
        this.p = obj;
        this.q = z2;
    }

    @Override // b.i.a.f.h.l.g$a
    public final void a() throws RemoteException {
        this.r.j.setUserProperty(this.n, this.o, new b.i.a.f.f.b(this.p), this.q, this.j);
    }
}
