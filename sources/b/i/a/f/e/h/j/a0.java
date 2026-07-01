package b.i.a.f.e.h.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends BroadcastReceiver {

    @Nullable
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u0 f1353b;

    public a0(u0 u0Var) {
        this.f1353b = u0Var;
    }

    public final synchronized void a() {
        Context context = this.a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.a = null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            u0 u0Var = this.f1353b;
            u0Var.f1373b.k.m();
            if (u0Var.a.isShowing()) {
                u0Var.a.dismiss();
            }
            a();
        }
    }
}
