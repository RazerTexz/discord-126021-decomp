package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.a0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3578a0 extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C3661g.c f9841n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C3661g f9842o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3578a0(C3661g c3661g, C3661g.c cVar) {
        super(true);
        this.f9842o = c3661g;
        this.f9841n = cVar;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f9842o.f9955j.registerOnMeasurementEventListener(this.f9841n);
    }
}
