package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.l */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3729l extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ String f10064n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ String f10065o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ Bundle f10066p;

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ C3661g f10067q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3729l(C3661g c3661g, String str, String str2, Bundle bundle) {
        super(true);
        this.f10067q = c3661g;
        this.f10064n = str;
        this.f10065o = str2;
        this.f10066p = bundle;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f10067q.f9955j.clearConditionalUserProperty(this.f10064n, this.f10065o, this.f10066p);
    }
}
