package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zau;
import com.google.android.gms.signin.internal.zam;
import java.util.Objects;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;
import p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3355g;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.i0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3298i0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zam f9426j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ BinderC3294g0 f9427k;

    public RunnableC3298i0(BinderC3294g0 binderC3294g0, zam zamVar) {
        this.f9427k = binderC3294g0;
        this.f9426j = zamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BinderC3294g0 binderC3294g0 = this.f9427k;
        zam zamVar = this.f9426j;
        Objects.requireNonNull(binderC3294g0);
        ConnectionResult connectionResult = zamVar.f20842k;
        if (connectionResult.m9020x0()) {
            zau zauVar = zamVar.f20843l;
            Objects.requireNonNull(zauVar, "null reference");
            ConnectionResult connectionResult2 = zauVar.f20552l;
            if (!connectionResult2.m9020x0()) {
                String strValueOf = String.valueOf(connectionResult2);
                Log.wtf("SignInCoordinator", C1643a.m857j(strValueOf.length() + 48, "Sign-in succeeded with resolve account failure: ", strValueOf), new Exception());
                ((C3293g.b) binderC3294g0.f9420h).m4104b(connectionResult2);
                binderC3294g0.f9419g.mo4036h();
                return;
            }
            InterfaceC3296h0 interfaceC3296h0 = binderC3294g0.f9420h;
            InterfaceC3355g interfaceC3355gM9041w0 = zauVar.m9041w0();
            Set<Scope> set = binderC3294g0.f9417e;
            C3293g.b bVar = (C3293g.b) interfaceC3296h0;
            Objects.requireNonNull(bVar);
            if (interfaceC3355gM9041w0 == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                bVar.m4104b(new ConnectionResult(4));
            } else {
                bVar.f9407c = interfaceC3355gM9041w0;
                bVar.f9408d = set;
                if (bVar.f9409e) {
                    bVar.f9405a.m4031b(interfaceC3355gM9041w0, set);
                }
            }
        } else {
            ((C3293g.b) binderC3294g0.f9420h).m4104b(connectionResult);
        }
        binderC3294g0.f9419g.mo4036h();
    }
}
