package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.c0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3606c0 extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Long f9864n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ String f9865o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ String f9866p;

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ Bundle f9867q;

    /* JADX INFO: renamed from: r */
    public final /* synthetic */ boolean f9868r;

    /* JADX INFO: renamed from: s */
    public final /* synthetic */ boolean f9869s;

    /* JADX INFO: renamed from: t */
    public final /* synthetic */ C3661g f9870t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3606c0(C3661g c3661g, Long l, String str, String str2, Bundle bundle, boolean z2, boolean z3) {
        super(true);
        this.f9870t = c3661g;
        this.f9864n = l;
        this.f9865o = str;
        this.f9866p = str2;
        this.f9867q = bundle;
        this.f9868r = z2;
        this.f9869s = z3;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        Long l = this.f9864n;
        this.f9870t.f9955j.logEvent(this.f9865o, this.f9866p, this.f9867q, this.f9868r, this.f9869s, l == null ? this.f9956j : l.longValue());
    }
}
