package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends g$a {
    public final /* synthetic */ Long n;
    public final /* synthetic */ String o;
    public final /* synthetic */ String p;
    public final /* synthetic */ Bundle q;
    public final /* synthetic */ boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ boolean f1436s;
    public final /* synthetic */ g t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(g gVar, Long l, String str, String str2, Bundle bundle, boolean z2, boolean z3) {
        super(gVar, true);
        this.t = gVar;
        this.n = l;
        this.o = str;
        this.p = str2;
        this.q = bundle;
        this.r = z2;
        this.f1436s = z3;
    }

    @Override // b.i.a.f.h.l.g$a
    public final void a() throws RemoteException {
        Long l = this.n;
        this.t.j.logEvent(this.o, this.p, this.q, this.r, this.f1436s, l == null ? this.j : l.longValue());
    }
}
