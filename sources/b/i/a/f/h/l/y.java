package b.i.a.f.h.l;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends g$a {
    public final /* synthetic */ String n;
    public final /* synthetic */ Object o;
    public final /* synthetic */ g p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(g gVar, String str, Object obj) {
        super(gVar, false);
        this.p = gVar;
        this.n = str;
        this.o = obj;
    }

    @Override // b.i.a.f.h.l.g$a
    public final void a() throws RemoteException {
        this.p.j.logHealthData(5, this.n, new b.i.a.f.f.b(this.o), new b.i.a.f.f.b(null), new b.i.a.f.f.b(null));
    }
}
