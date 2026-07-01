package b.i.a.f.h.l;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends g$a {
    public final /* synthetic */ String n;
    public final /* synthetic */ g o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(g gVar, String str) {
        super(gVar, true);
        this.o = gVar;
        this.n = str;
    }

    @Override // b.i.a.f.h.l.g$a
    public final void a() throws RemoteException {
        this.o.j.endAdUnitExposure(this.n, this.k);
    }
}
