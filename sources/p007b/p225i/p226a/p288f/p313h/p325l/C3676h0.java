package p007b.p225i.p226a.p288f.p313h.p325l;

import android.app.Activity;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.h0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3676h0 extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Activity f9979n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ BinderC3618cc f9980o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ C3661g.b f9981p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3676h0(C3661g.b bVar, Activity activity, BinderC3618cc binderC3618cc) {
        super(true);
        this.f9981p = bVar;
        this.f9979n = activity;
        this.f9980o = binderC3618cc;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        C3661g.this.f9955j.onActivitySaveInstanceState(new BinderC3423b(this.f9979n), this.f9980o, this.f9957k);
    }
}
