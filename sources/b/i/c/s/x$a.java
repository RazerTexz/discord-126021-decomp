package b.i.c.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class x$a extends BroadcastReceiver {
    public x a;

    public x$a(x xVar) {
        this.a = xVar;
    }

    public void a() {
        if (FirebaseInstanceId.l()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        x xVar = this.a;
        if (xVar != null && xVar.c()) {
            if (FirebaseInstanceId.l()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            x xVar2 = this.a;
            xVar2.l.d(xVar2, 0L);
            this.a.a().unregisterReceiver(this);
            this.a = null;
        }
    }
}
