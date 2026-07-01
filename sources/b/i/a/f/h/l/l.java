package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends g$a {
    public final /* synthetic */ String n;
    public final /* synthetic */ String o;
    public final /* synthetic */ Bundle p;
    public final /* synthetic */ g q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(g gVar, String str, String str2, Bundle bundle) {
        super(gVar, true);
        this.q = gVar;
        this.n = str;
        this.o = str2;
        this.p = bundle;
    }

    @Override // b.i.a.f.h.l.g$a
    public final void a() throws RemoteException {
        this.q.j.clearConditionalUserProperty(this.n, this.o, this.p);
    }
}
