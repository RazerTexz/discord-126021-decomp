package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.i */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3689i extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Bundle f10002n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C3661g f10003o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3689i(C3661g c3661g, Bundle bundle) {
        super(true);
        this.f10003o = c3661g;
        this.f10002n = bundle;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f10003o.f9955j.setConditionalUserProperty(this.f10002n, this.f9956j);
    }
}
