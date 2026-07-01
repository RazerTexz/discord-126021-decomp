package b.i.a.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.q2, reason: use source file name */
/* JADX INFO: compiled from: WakeLockManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WakeLockManager {

    @Nullable
    public final PowerManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public PowerManager.WakeLock f1057b;
    public boolean c;
    public boolean d;

    public WakeLockManager(Context context) {
        this.a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @SuppressLint({"WakelockTimeout"})
    public final void a() {
        PowerManager.WakeLock wakeLock = this.f1057b;
        if (wakeLock == null) {
            return;
        }
        if (this.c && this.d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
