package b.i.a.c;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager$WifiLock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: WifiLockManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r2 {

    @Nullable
    public final WifiManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public WifiManager$WifiLock f1059b;
    public boolean c;
    public boolean d;

    public r2(Context context) {
        this.a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public final void a() {
        WifiManager$WifiLock wifiManager$WifiLock = this.f1059b;
        if (wifiManager$WifiLock == null) {
            return;
        }
        if (this.c && this.d) {
            wifiManager$WifiLock.acquire();
        } else {
            wifiManager$WifiLock.release();
        }
    }
}
