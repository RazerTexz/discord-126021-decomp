package p007b.p225i.p226a.p242c;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.r2 */
/* JADX INFO: compiled from: WifiLockManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2844r2 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final WifiManager f7474a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public WifiManager.WifiLock f7475b;

    /* JADX INFO: renamed from: c */
    public boolean f7476c;

    /* JADX INFO: renamed from: d */
    public boolean f7477d;

    public C2844r2(Context context) {
        this.f7474a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    /* JADX INFO: renamed from: a */
    public final void m3362a() {
        WifiManager.WifiLock wifiLock = this.f7475b;
        if (wifiLock == null) {
            return;
        }
        if (this.f7476c && this.f7477d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
