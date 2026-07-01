package b.i.a.f.e.h.j;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t0 extends LifecycleCallback implements DialogInterface.OnCancelListener {
    public volatile boolean k;
    public final AtomicReference<s0> l;
    public final Handler m;
    public final GoogleApiAvailability n;

    public t0(j jVar, GoogleApiAvailability googleApiAvailability) {
        super(jVar);
        this.l = new AtomicReference<>(null);
        this.m = new b.i.a.f.h.e.c(Looper.getMainLooper());
        this.n = googleApiAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void d(int i, int i2, Intent intent) {
        s0 s0Var = this.l.get();
        boolean z2 = false;
        if (i != 1) {
            if (i == 2) {
                int iC = this.n.c(b());
                z2 = iC == 0;
                if (s0Var == null) {
                    return;
                }
                if (s0Var.f1372b.l == 18 && iC == 18) {
                    return;
                }
            }
        } else if (i2 == -1) {
            z2 = true;
        } else if (i2 == 0) {
            if (s0Var == null) {
                return;
            }
            s0 s0Var2 = new s0(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, s0Var.f1372b.toString()), s0Var.a);
            this.l.set(s0Var2);
            s0Var = s0Var2;
        }
        if (z2) {
            m();
        } else if (s0Var != null) {
            l(s0Var.f1372b, s0Var.a);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void e(Bundle bundle) {
        if (bundle != null) {
            this.l.set(bundle.getBoolean("resolving_error", false) ? new s0(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void h(Bundle bundle) {
        s0 s0Var = this.l.get();
        if (s0Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", s0Var.a);
            bundle.putInt("failed_status", s0Var.f1372b.l);
            bundle.putParcelable("failed_resolution", s0Var.f1372b.m);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void i() {
        this.k = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        this.k = false;
    }

    public abstract void k();

    public abstract void l(ConnectionResult connectionResult, int i);

    public final void m() {
        this.l.set(null);
        k();
    }

    public final void n(ConnectionResult connectionResult, int i) {
        s0 s0Var = new s0(connectionResult, i);
        if (this.l.compareAndSet(null, s0Var)) {
            this.m.post(new v0(this, s0Var));
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ConnectionResult connectionResult = new ConnectionResult(13, null);
        s0 s0Var = this.l.get();
        l(connectionResult, s0Var == null ? -1 : s0Var.a);
        m();
    }
}
