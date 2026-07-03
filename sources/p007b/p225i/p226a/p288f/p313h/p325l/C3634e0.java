package p007b.p225i.p226a.p288f.p313h.p325l;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.e0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3634e0 extends C3661g.a {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Bundle f9897n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ Activity f9898o;

    /* JADX INFO: renamed from: p */
    public final /* synthetic */ C3661g.b f9899p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3634e0(C3661g.b bVar, Bundle bundle, Activity activity) {
        super(true);
        this.f9899p = bVar;
        this.f9897n = bundle;
        this.f9898o = activity;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3661g.a
    /* JADX INFO: renamed from: a */
    public final void mo4521a() throws RemoteException {
        Bundle bundle;
        if (this.f9897n != null) {
            bundle = new Bundle();
            if (this.f9897n.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.f9897n.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        C3661g.this.f9955j.onActivityCreated(new BinderC3423b(this.f9898o), bundle, this.f9957k);
    }
}
