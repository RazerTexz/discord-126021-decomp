package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.b0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3592b0 extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ String f9853n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ String f9854o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ Object f9855p;

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ boolean f9856q;

    /* JADX INFO: renamed from: r */
    public final /* synthetic */ C3661g f9857r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3592b0(C3661g c3661g, String str, String str2, Object obj, boolean z2) {
        super(true);
        this.f9857r = c3661g;
        this.f9853n = str;
        this.f9854o = str2;
        this.f9855p = obj;
        this.f9856q = z2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f9857r.f9955j.setUserProperty(this.f9853n, this.f9854o, new BinderC3423b(this.f9855p), this.f9856q, this.f9956j);
    }
}
