package b.i.a.f.h.l;

import android.app.Activity;
import android.os.RemoteException;
import b.i.a.f.h.l.g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends g.a {
    public final /* synthetic */ Activity n;
    public final /* synthetic */ String o;
    public final /* synthetic */ String p;
    public final /* synthetic */ g q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(g gVar, Activity activity, String str, String str2) {
        super(true);
        this.q = gVar;
        this.n = activity;
        this.o = str;
        this.p = str2;
    }

    @Override // b.i.a.f.h.l.g.a
    public final void a() throws RemoteException {
        this.q.j.setCurrentScreen(new b.i.a.f.f.b(this.n), this.o, this.p, this.j);
    }
}
