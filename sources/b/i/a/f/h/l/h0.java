package b.i.a.f.h.l;

import android.app.Activity;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends g$a {
    public final /* synthetic */ Activity n;
    public final /* synthetic */ cc o;
    public final /* synthetic */ g$b p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(g$b g_b, Activity activity, cc ccVar) {
        super(g_b.j, true);
        this.p = g_b;
        this.n = activity;
        this.o = ccVar;
    }

    @Override // b.i.a.f.h.l.g$a
    public final void a() throws RemoteException {
        this.p.j.j.onActivitySaveInstanceState(new b.i.a.f.f.b(this.n), this.o, this.k);
    }
}
