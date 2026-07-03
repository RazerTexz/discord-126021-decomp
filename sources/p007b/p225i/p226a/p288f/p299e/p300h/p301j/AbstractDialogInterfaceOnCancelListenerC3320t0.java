package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

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
import p007b.p225i.p226a.p288f.p313h.p318e.HandlerC3479c;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.t0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDialogInterfaceOnCancelListenerC3320t0 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: k */
    public volatile boolean f9451k;

    /* JADX INFO: renamed from: l */
    public final AtomicReference<C3318s0> f9452l;

    /* JADX INFO: renamed from: m */
    public final Handler f9453m;

    /* JADX INFO: renamed from: n */
    public final GoogleApiAvailability f9454n;

    public AbstractDialogInterfaceOnCancelListenerC3320t0(InterfaceC3299j interfaceC3299j, GoogleApiAvailability googleApiAvailability) {
        super(interfaceC3299j);
        this.f9452l = new AtomicReference<>(null);
        this.f9453m = new HandlerC3479c(Looper.getMainLooper());
        this.f9454n = googleApiAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: d */
    public void mo4115d(int i, int i2, Intent intent) {
        C3318s0 c3318s0 = this.f9452l.get();
        boolean z2 = false;
        if (i != 1) {
            if (i == 2) {
                int iM9024c = this.f9454n.m9024c(m9040b());
                z2 = iM9024c == 0;
                if (c3318s0 == null) {
                    return;
                }
                if (c3318s0.f9449b.f20474l == 18 && iM9024c == 18) {
                    return;
                }
            }
        } else if (i2 == -1) {
            z2 = true;
        } else if (i2 == 0) {
            if (c3318s0 == null) {
                return;
            }
            C3318s0 c3318s1 = new C3318s0(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, c3318s0.f9449b.toString()), c3318s0.f9448a);
            this.f9452l.set(c3318s1);
            c3318s0 = c3318s1;
        }
        if (z2) {
            m4118m();
        } else if (c3318s0 != null) {
            mo4062l(c3318s0.f9449b, c3318s0.f9448a);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: e */
    public void mo4116e(Bundle bundle) {
        if (bundle != null) {
            this.f9452l.set(bundle.getBoolean("resolving_error", false) ? new C3318s0(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: h */
    public void mo4117h(Bundle bundle) {
        C3318s0 c3318s0 = this.f9452l.get();
        if (c3318s0 != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", c3318s0.f9448a);
            bundle.putInt("failed_status", c3318s0.f9449b.f20474l);
            bundle.putParcelable("failed_resolution", c3318s0.f9449b.f20475m);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: i */
    public void mo4059i() {
        this.f9451k = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: j */
    public void mo4060j() {
        this.f9451k = false;
    }

    /* JADX INFO: renamed from: k */
    public abstract void mo4061k();

    /* JADX INFO: renamed from: l */
    public abstract void mo4062l(ConnectionResult connectionResult, int i);

    /* JADX INFO: renamed from: m */
    public final void m4118m() {
        this.f9452l.set(null);
        mo4061k();
    }

    /* JADX INFO: renamed from: n */
    public final void m4119n(ConnectionResult connectionResult, int i) {
        C3318s0 c3318s0 = new C3318s0(connectionResult, i);
        if (this.f9452l.compareAndSet(null, c3318s0)) {
            this.f9453m.post(new RunnableC3324v0(this, c3318s0));
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ConnectionResult connectionResult = new ConnectionResult(13, null);
        C3318s0 c3318s0 = this.f9452l.get();
        mo4062l(connectionResult, c3318s0 == null ? -1 : c3318s0.f9448a);
        m4118m();
    }
}
