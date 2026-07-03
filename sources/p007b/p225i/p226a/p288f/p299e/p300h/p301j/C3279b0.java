package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.C3256c;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.b0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3279b0 extends AbstractDialogInterfaceOnCancelListenerC3320t0 {

    /* JADX INFO: renamed from: o */
    public TaskCompletionSource<Void> f9348o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3279b0(InterfaceC3299j interfaceC3299j) {
        super(interfaceC3299j, GoogleApiAvailability.f20481d);
        Object obj = GoogleApiAvailability.f20480c;
        this.f9348o = new TaskCompletionSource<>();
        interfaceC3299j.mo4069a("GmsAvailabilityHelper", this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: f */
    public void mo4063f() {
        this.f9348o.m9125a(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractDialogInterfaceOnCancelListenerC3320t0
    /* JADX INFO: renamed from: k */
    public final void mo4061k() {
        Activity activityMo4071e = this.f20511j.mo4071e();
        if (activityMo4071e == null) {
            this.f9348o.m9125a(new ApiException(new Status(8, null)));
            return;
        }
        int iMo4018b = this.f9454n.mo4018b(activityMo4071e, C3256c.f9306a);
        if (iMo4018b == 0) {
            this.f9348o.m9126b(null);
        } else {
            if (this.f9348o.f20845a.mo6020o()) {
                return;
            }
            m4119n(new ConnectionResult(iMo4018b, null), 0);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractDialogInterfaceOnCancelListenerC3320t0
    /* JADX INFO: renamed from: l */
    public final void mo4062l(ConnectionResult connectionResult, int i) {
        TaskCompletionSource<Void> taskCompletionSource = this.f9348o;
        taskCompletionSource.f20845a.m6025t(C1460d.m540l0(new Status(connectionResult.f20474l, connectionResult.f20476n, connectionResult.f20475m)));
    }
}
