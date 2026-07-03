package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.t */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3833t extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ BinderC3618cc f10320n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C3661g f10321o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3833t(C3661g c3661g, BinderC3618cc binderC3618cc) {
        super(true);
        this.f10321o = c3661g;
        this.f10320n = binderC3618cc;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f10321o.f9955j.getCurrentScreenName(this.f10320n);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: b */
    public final void mo4887b() {
        this.f10320n.mo4619f(null);
    }
}
