package b.i.a.f.e.h.j;

import android.app.Activity;
import android.os.Handler;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a1 extends t0 {
    public final ArraySet<b<?>> o;
    public final g p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(j jVar, g gVar) {
        super(jVar, GoogleApiAvailability.d);
        Object obj = GoogleApiAvailability.c;
        this.o = new ArraySet<>();
        this.p = gVar;
        jVar.a("ConnectionlessLifecycleHelper", this);
    }

    public static void o(Activity activity, g gVar, b<?> bVar) {
        j jVarC = LifecycleCallback.c(activity);
        a1 a1Var = (a1) jVarC.d("ConnectionlessLifecycleHelper", a1.class);
        if (a1Var == null) {
            a1Var = new a1(jVarC, gVar);
        }
        b.c.a.a0.d.z(bVar, "ApiKey cannot be null");
        a1Var.o.add(bVar);
        gVar.b(a1Var);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void g() {
        if (this.o.isEmpty()) {
            return;
        }
        this.p.b(this);
    }

    @Override // b.i.a.f.e.h.j.t0, com.google.android.gms.common.api.internal.LifecycleCallback
    public void i() {
        this.k = true;
        if (this.o.isEmpty()) {
            return;
        }
        this.p.b(this);
    }

    @Override // b.i.a.f.e.h.j.t0, com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        this.k = false;
        g gVar = this.p;
        Objects.requireNonNull(gVar);
        synchronized (g.l) {
            if (gVar.u == this) {
                gVar.u = null;
                gVar.v.clear();
            }
        }
    }

    @Override // b.i.a.f.e.h.j.t0
    public final void k() {
        Handler handler = this.p.f1359x;
        handler.sendMessage(handler.obtainMessage(3));
    }

    @Override // b.i.a.f.e.h.j.t0
    public final void l(ConnectionResult connectionResult, int i) {
        g gVar = this.p;
        if (gVar.c(connectionResult, i)) {
            return;
        }
        Handler handler = gVar.f1359x;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }
}
