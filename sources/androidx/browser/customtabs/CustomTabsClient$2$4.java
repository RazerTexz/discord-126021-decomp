package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsClient$2$4 implements Runnable {
    public final /* synthetic */ CustomTabsClient$2 this$1;
    public final /* synthetic */ Bundle val$extras;
    public final /* synthetic */ String val$message;

    public CustomTabsClient$2$4(CustomTabsClient$2 customTabsClient$2, String str, Bundle bundle) {
        this.this$1 = customTabsClient$2;
        this.val$message = str;
        this.val$extras = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.val$callback.onPostMessage(this.val$message, this.val$extras);
    }
}
