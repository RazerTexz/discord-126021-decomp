package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.app.Activity;
import android.os.Handler;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.a1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3277a1 extends AbstractDialogInterfaceOnCancelListenerC3320t0 {

    /* JADX INFO: renamed from: o */
    public final ArraySet<C3278b<?>> f9343o;

    /* JADX INFO: renamed from: p */
    public final C3293g f9344p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3277a1(InterfaceC3299j interfaceC3299j, C3293g c3293g) {
        super(interfaceC3299j, GoogleApiAvailability.f20481d);
        Object obj = GoogleApiAvailability.f20480c;
        this.f9343o = new ArraySet<>();
        this.f9344p = c3293g;
        interfaceC3299j.mo4069a("ConnectionlessLifecycleHelper", this);
    }

    /* JADX INFO: renamed from: o */
    public static void m4057o(Activity activity, C3293g c3293g, C3278b<?> c3278b) {
        InterfaceC3299j interfaceC3299jM9038c = LifecycleCallback.m9038c(activity);
        C3277a1 c3277a1 = (C3277a1) interfaceC3299jM9038c.mo4070d("ConnectionlessLifecycleHelper", C3277a1.class);
        if (c3277a1 == null) {
            c3277a1 = new C3277a1(interfaceC3299jM9038c, c3293g);
        }
        C1460d.m595z(c3278b, "ApiKey cannot be null");
        c3277a1.f9343o.add(c3278b);
        c3293g.m4079b(c3277a1);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: g */
    public void mo4058g() {
        if (this.f9343o.isEmpty()) {
            return;
        }
        this.f9344p.m4079b(this);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractDialogInterfaceOnCancelListenerC3320t0, com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: i */
    public void mo4059i() {
        this.f9451k = true;
        if (this.f9343o.isEmpty()) {
            return;
        }
        this.f9344p.m4079b(this);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractDialogInterfaceOnCancelListenerC3320t0, com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: j */
    public void mo4060j() {
        this.f9451k = false;
        C3293g c3293g = this.f9344p;
        Objects.requireNonNull(c3293g);
        synchronized (C3293g.f9378l) {
            if (c3293g.f9387u == this) {
                c3293g.f9387u = null;
                c3293g.f9388v.clear();
            }
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractDialogInterfaceOnCancelListenerC3320t0
    /* JADX INFO: renamed from: k */
    public final void mo4061k() {
        Handler handler = this.f9344p.f9390x;
        handler.sendMessage(handler.obtainMessage(3));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractDialogInterfaceOnCancelListenerC3320t0
    /* JADX INFO: renamed from: l */
    public final void mo4062l(ConnectionResult connectionResult, int i) {
        C3293g c3293g = this.f9344p;
        if (c3293g.m4080c(connectionResult, i)) {
            return;
        }
        Handler handler = c3293g.f9390x;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }
}
