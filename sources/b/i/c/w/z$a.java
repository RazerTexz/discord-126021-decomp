package b.i.c.w;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public class z$a extends BroadcastReceiver {

    @Nullable
    @GuardedBy("this")
    public z a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f1801b;

    public z$a(z zVar, z zVar2) {
        this.f1801b = zVar;
        this.a = zVar2;
    }

    public void a() {
        if (z.a()) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        this.f1801b.m.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(Context context, Intent intent) {
        z zVar = this.a;
        if (zVar == null) {
            return;
        }
        if (zVar.e()) {
            if (z.a()) {
                Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
            }
            z zVar2 = this.a;
            zVar2.p.h.schedule(zVar2, 0L, TimeUnit.SECONDS);
            context.unregisterReceiver(this);
            this.a = null;
        }
    }
}
