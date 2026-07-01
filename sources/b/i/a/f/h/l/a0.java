package b.i.a.f.h.l;

import android.os.RemoteException;
import b.i.a.f.h.l.g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends g.a {
    public final /* synthetic */ g.c n;
    public final /* synthetic */ g o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(g gVar, g.c cVar) {
        super(true);
        this.o = gVar;
        this.n = cVar;
    }

    @Override // b.i.a.f.h.l.g.a
    public final void a() throws RemoteException {
        this.o.j.registerOnMeasurementEventListener(this.n);
    }
}
