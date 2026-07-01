package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsClient$2$3 implements Runnable {
    public final /* synthetic */ CustomTabsClient$2 this$1;
    public final /* synthetic */ Bundle val$extras;

    public CustomTabsClient$2$3(CustomTabsClient$2 customTabsClient$2, Bundle bundle) {
        this.this$1 = customTabsClient$2;
        this.val$extras = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.val$callback.onMessageChannelReady(this.val$extras);
    }
}
