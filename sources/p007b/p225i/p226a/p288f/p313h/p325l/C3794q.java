package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.q */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3794q extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ String f10254n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C3661g f10255o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3794q(C3661g c3661g, String str) {
        super(true);
        this.f10255o = c3661g;
        this.f10254n = str;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        this.f10255o.f9955j.beginAdUnitExposure(this.f10254n, this.f9957k);
    }
}
