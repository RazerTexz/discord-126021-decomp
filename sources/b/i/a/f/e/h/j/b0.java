package b.i.a.f.e.h.j;

import android.app.Activity;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class b0 extends t0 {
    public TaskCompletionSource<Void> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(j jVar) {
        super(jVar, GoogleApiAvailability.d);
        Object obj = GoogleApiAvailability.c;
        this.o = new TaskCompletionSource<>();
        jVar.a("GmsAvailabilityHelper", this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void f() {
        this.o.a(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    @Override // b.i.a.f.e.h.j.t0
    public final void k() {
        Activity activityE = this.j.e();
        if (activityE == null) {
            this.o.a(new ApiException(new Status(8, null)));
            return;
        }
        int iB = this.n.b(activityE, b.i.a.f.e.c.a);
        if (iB == 0) {
            this.o.b(null);
        } else {
            if (this.o.a.o()) {
                return;
            }
            n(new ConnectionResult(iB, null), 0);
        }
    }

    @Override // b.i.a.f.e.h.j.t0
    public final void l(ConnectionResult connectionResult, int i) {
        TaskCompletionSource<Void> taskCompletionSource = this.o;
        taskCompletionSource.a.t(AnimatableValueParser.l0(new Status(connectionResult.l, connectionResult.n, connectionResult.m)));
    }
}
