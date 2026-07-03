package p007b.p225i.p226a.p242c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.q2 */
/* JADX INFO: compiled from: WakeLockManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2840q2 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final PowerManager f7457a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public PowerManager.WakeLock f7458b;

    /* JADX INFO: renamed from: c */
    public boolean f7459c;

    /* JADX INFO: renamed from: d */
    public boolean f7460d;

    public C2840q2(Context context) {
        this.f7457a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @SuppressLint({"WakelockTimeout"})
    /* JADX INFO: renamed from: a */
    public final void m3357a() {
        PowerManager.WakeLock wakeLock = this.f7458b;
        if (wakeLock == null) {
            return;
        }
        if (this.f7459c && this.f7460d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
