package p007b.p225i.p226a.p288f.p313h.p325l;

import android.app.Activity;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.f0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3648f0 extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Activity f9935n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C3661g.b f9936o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3648f0(C3661g.b bVar, Activity activity) {
        super(true);
        this.f9936o = bVar;
        this.f9935n = activity;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        C3661g.this.f9955j.onActivityPaused(new BinderC3423b(this.f9935n), this.f9957k);
    }
}
