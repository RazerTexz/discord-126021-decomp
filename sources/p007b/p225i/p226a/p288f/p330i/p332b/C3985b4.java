package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;

/* JADX INFO: renamed from: b.i.a.f.i.b.b4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3985b4 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public final C4097k9 f10561a;

    /* JADX INFO: renamed from: b */
    public boolean f10562b;

    /* JADX INFO: renamed from: c */
    public boolean f10563c;

    public C3985b4(C4097k9 c4097k9) {
        this.f10561a = c4097k9;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final void m5501a() {
        this.f10561a.m5715P();
        this.f10561a.mo5725f().mo5848b();
        this.f10561a.mo5725f().mo5848b();
        if (this.f10562b) {
            this.f10561a.mo5726g().f11149n.m5860a("Unregistering connectivity change receiver");
            this.f10562b = false;
            this.f10563c = false;
            try {
                this.f10561a.f10906k.f11254b.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f10561a.mo5726g().f11141f.m5861b("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.f10561a.m5715P();
        String action = intent.getAction();
        this.f10561a.mo5726g().f11149n.m5861b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f10561a.mo5726g().f11144i.m5861b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zM5963u = this.f10561a.m5709J().m5963u();
        if (this.f10563c != zM5963u) {
            this.f10563c = zM5963u;
            this.f10561a.mo5725f().m5852v(new RunnableC4021e4(this, zM5963u));
        }
    }
}
