package b.i.a.f.h.l;

import android.os.RemoteException;
import b.i.a.f.h.l.g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends g.a {
    public final /* synthetic */ String n;
    public final /* synthetic */ cc o;
    public final /* synthetic */ g p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(g gVar, String str, cc ccVar) {
        super(true);
        this.p = gVar;
        this.n = str;
        this.o = ccVar;
    }

    @Override // b.i.a.f.h.l.g.a
    public final void a() throws RemoteException {
        this.p.j.getMaxUserProperties(this.n, this.o);
    }

    @Override // b.i.a.f.h.l.g.a
    public final void b() {
        this.o.f(null);
    }
}
