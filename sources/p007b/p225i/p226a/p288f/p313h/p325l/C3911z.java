package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.z */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3911z extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ String f10438n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ BinderC3618cc f10439o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ C3661g f10440p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3911z(C3661g c3661g, String str, BinderC3618cc binderC3618cc) {
        super(true);
        this.f10440p = c3661g;
        this.f10438n = str;
        this.f10439o = binderC3618cc;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f10440p.f9955j.getMaxUserProperties(this.f10438n, this.f10439o);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: b */
    public final void mo4887b() {
        this.f10439o.mo4619f(null);
    }
}
