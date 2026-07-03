package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.k */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3716k extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ String f10046n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ String f10047o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ BinderC3618cc f10048p;

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ C3661g f10049q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3716k(C3661g c3661g, String str, String str2, BinderC3618cc binderC3618cc) {
        super(true);
        this.f10049q = c3661g;
        this.f10046n = str;
        this.f10047o = str2;
        this.f10048p = binderC3618cc;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f10049q.f9955j.getConditionalUserProperties(this.f10046n, this.f10047o, this.f10048p);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: b */
    public final void mo4887b() {
        this.f10048p.mo4619f(null);
    }
}
