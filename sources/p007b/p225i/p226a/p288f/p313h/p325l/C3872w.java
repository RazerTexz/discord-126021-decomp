package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.w */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3872w extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ String f10371n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ String f10372o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ boolean f10373p;

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ BinderC3618cc f10374q;

    /* JADX INFO: renamed from: r */
    public final /* synthetic */ C3661g f10375r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3872w(C3661g c3661g, String str, String str2, boolean z2, BinderC3618cc binderC3618cc) {
        super(true);
        this.f10375r = c3661g;
        this.f10371n = str;
        this.f10372o = str2;
        this.f10373p = z2;
        this.f10374q = binderC3618cc;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f10375r.f9955j.getUserProperties(this.f10371n, this.f10372o, this.f10373p, this.f10374q);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: b */
    public final void mo4887b() {
        this.f10374q.mo4619f(null);
    }
}
