package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.y */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3898y extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ String f10414n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ Object f10415o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ C3661g f10416p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3898y(C3661g c3661g, String str, Object obj) {
        super(false);
        this.f10416p = c3661g;
        this.f10414n = str;
        this.f10415o = obj;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f10416p.f9955j.logHealthData(5, this.f10414n, new BinderC3423b(this.f10415o), new BinderC3423b(null), new BinderC3423b(null));
    }
}
