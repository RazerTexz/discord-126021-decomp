package p007b.p225i.p226a.p288f.p313h.p325l;

import android.app.Activity;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.i0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3690i0 extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Activity f10004n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C3661g.b f10005o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3690i0(C3661g.b bVar, Activity activity) {
        super(true);
        this.f10005o = bVar;
        this.f10004n = activity;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        C3661g.this.f9955j.onActivityStopped(new BinderC3423b(this.f10004n), this.f9957k);
    }
}
