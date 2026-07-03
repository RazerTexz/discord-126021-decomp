package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;
import p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3355g;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.z */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3331z implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ConnectionResult f9469j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C3293g.b f9470k;

    public RunnableC3331z(C3293g.b bVar, ConnectionResult connectionResult) {
        this.f9470k = bVar;
        this.f9469j = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC3355g interfaceC3355g;
        C3293g.b bVar = this.f9470k;
        C3293g.a<?> aVar = C3293g.this.f9386t.get(bVar.f9406b);
        if (aVar == null) {
            return;
        }
        if (!this.f9469j.m9020x0()) {
            aVar.m4085e(this.f9469j, null);
            return;
        }
        C3293g.b bVar2 = this.f9470k;
        bVar2.f9409e = true;
        if (bVar2.f9405a.mo4042o()) {
            C3293g.b bVar3 = this.f9470k;
            if (!bVar3.f9409e || (interfaceC3355g = bVar3.f9407c) == null) {
                return;
            }
            bVar3.f9405a.m4031b(interfaceC3355g, bVar3.f9408d);
            return;
        }
        try {
            C3266a.f fVar = this.f9470k.f9405a;
            fVar.m4031b(null, fVar.mo4030a());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            this.f9470k.f9405a.m4032c("Failed to get service from broker.");
            aVar.m4085e(new ConnectionResult(10), null);
        }
    }
}
