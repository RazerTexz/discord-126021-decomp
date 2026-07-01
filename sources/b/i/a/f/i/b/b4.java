package b.i.a.f.i.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class b4 extends BroadcastReceiver {
    public final k9 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1520b;
    public boolean c;

    public b4(k9 k9Var) {
        this.a = k9Var;
    }

    @WorkerThread
    public final void a() {
        this.a.P();
        this.a.f().b();
        this.a.f().b();
        if (this.f1520b) {
            this.a.g().n.a("Unregistering connectivity change receiver");
            this.f1520b = false;
            this.c = false;
            try {
                this.a.k.f1570b.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.a.g().f.b("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.a.P();
        String action = intent.getAction();
        this.a.g().n.b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.a.g().i.b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zU = this.a.J().u();
        if (this.c != zU) {
            this.c = zU;
            this.a.f().v(new e4(this, zU));
        }
    }
}
