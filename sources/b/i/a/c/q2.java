package b.i.a.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager$WakeLock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: WakeLockManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q2 {

    @Nullable
    public final PowerManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public PowerManager$WakeLock f1057b;
    public boolean c;
    public boolean d;

    public q2(Context context) {
        this.a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @SuppressLint({"WakelockTimeout"})
    public final void a() {
        PowerManager$WakeLock powerManager$WakeLock = this.f1057b;
        if (powerManager$WakeLock == null) {
            return;
        }
        if (this.c && this.d) {
            powerManager$WakeLock.acquire();
        } else {
            powerManager$WakeLock.release();
        }
    }
}
