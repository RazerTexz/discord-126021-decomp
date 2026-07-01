package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.RemoteException;
import b.i.a.f.h.l.g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends g.a {
    public final /* synthetic */ Bundle n;
    public final /* synthetic */ g o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, Bundle bundle) {
        super(true);
        this.o = gVar;
        this.n = bundle;
    }

    @Override // b.i.a.f.h.l.g.a
    public final void a() throws RemoteException {
        this.o.j.setConditionalUserProperty(this.n, this.j);
    }
}
