package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsClient$2$2 implements Runnable {
    public final /* synthetic */ CustomTabsClient$2 this$1;
    public final /* synthetic */ Bundle val$args;
    public final /* synthetic */ String val$callbackName;

    public CustomTabsClient$2$2(CustomTabsClient$2 customTabsClient$2, String str, Bundle bundle) {
        this.this$1 = customTabsClient$2;
        this.val$callbackName = str;
        this.val$args = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.val$callback.extraCallback(this.val$callbackName, this.val$args);
    }
}
