package b.i.a.f.e.h.j;

import android.util.Log;
import b.d.b.a.outline;
import b.i.a.f.e.h.j.g;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zau;
import com.google.android.gms.signin.internal.zam;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ zam j;
    public final /* synthetic */ g0 k;

    public i0(g0 g0Var, zam zamVar) {
        this.k = g0Var;
        this.j = zamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g0 g0Var = this.k;
        zam zamVar = this.j;
        Objects.requireNonNull(g0Var);
        ConnectionResult connectionResult = zamVar.k;
        if (connectionResult.x0()) {
            zau zauVar = zamVar.l;
            Objects.requireNonNull(zauVar, "null reference");
            ConnectionResult connectionResult2 = zauVar.l;
            if (!connectionResult2.x0()) {
                String strValueOf = String.valueOf(connectionResult2);
                Log.wtf("SignInCoordinator", outline.j(strValueOf.length() + 48, "Sign-in succeeded with resolve account failure: ", strValueOf), new Exception());
                ((g.b) g0Var.h).b(connectionResult2);
                g0Var.g.h();
                return;
            }
            h0 h0Var = g0Var.h;
            b.i.a.f.e.k.g gVarW0 = zauVar.w0();
            Set<Scope> set = g0Var.e;
            g.b bVar = (g.b) h0Var;
            Objects.requireNonNull(bVar);
            if (gVarW0 == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                bVar.b(new ConnectionResult(4));
            } else {
                bVar.c = gVarW0;
                bVar.d = set;
                if (bVar.e) {
                    bVar.a.b(gVarW0, set);
                }
            }
        } else {
            ((g.b) g0Var.h).b(connectionResult);
        }
        g0Var.g.h();
    }
}
