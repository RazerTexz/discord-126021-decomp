package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.s */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3820s extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ BinderC3618cc f10299n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C3661g f10300o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3820s(C3661g c3661g, BinderC3618cc binderC3618cc) {
        super(true);
        this.f10300o = c3661g;
        this.f10299n = binderC3618cc;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f10300o.f9955j.getGmpAppId(this.f10299n);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: b */
    public final void mo4887b() {
        this.f10299n.mo4619f(null);
    }
}
