package p007b.p225i.p226a.p288f.p313h.p325l;

import android.app.Activity;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.m */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3742m extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Activity f10085n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ String f10086o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ String f10087p;

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ C3661g f10088q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3742m(C3661g c3661g, Activity activity, String str, String str2) {
        super(true);
        this.f10088q = c3661g;
        this.f10085n = activity;
        this.f10086o = str;
        this.f10087p = str2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f10088q.f9955j.setCurrentScreen(new BinderC3423b(this.f10085n), this.f10086o, this.f10087p, this.f9956j);
    }
}
