package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsClient$1 extends CustomTabsServiceConnection {
    public final /* synthetic */ Context val$applicationContext;

    public CustomTabsClient$1(Context context) {
        this.val$applicationContext = context;
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient) {
        customTabsClient.warmup(0L);
        this.val$applicationContext.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
