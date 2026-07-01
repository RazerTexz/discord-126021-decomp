package b.i.a.f.e.k;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends i0<Boolean> {
    public final int d;

    @Nullable
    public final Bundle e;
    public final /* synthetic */ b f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public z(b bVar, @Nullable int i, Bundle bundle) {
        super(bVar, Boolean.TRUE);
        this.f = bVar;
        this.d = i;
        this.e = bundle;
    }

    @Override // b.i.a.f.e.k.i0
    public final void a() {
    }

    @Override // b.i.a.f.e.k.i0
    public final /* synthetic */ void b(Boolean bool) {
        ConnectionResult connectionResult;
        if (this.d != 0) {
            this.f.F(1, null);
            Bundle bundle = this.e;
            connectionResult = new ConnectionResult(this.d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
        } else {
            if (d()) {
                return;
            }
            this.f.F(1, null);
            connectionResult = new ConnectionResult(8, null);
        }
        e(connectionResult);
    }

    public abstract boolean d();

    public abstract void e(ConnectionResult connectionResult);
}
