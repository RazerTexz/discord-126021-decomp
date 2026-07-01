package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsClient$2$1 implements Runnable {
    public final /* synthetic */ CustomTabsClient$2 this$1;
    public final /* synthetic */ Bundle val$extras;
    public final /* synthetic */ int val$navigationEvent;

    public CustomTabsClient$2$1(CustomTabsClient$2 customTabsClient$2, int i, Bundle bundle) {
        this.this$1 = customTabsClient$2;
        this.val$navigationEvent = i;
        this.val$extras = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.val$callback.onNavigationEvent(this.val$navigationEvent, this.val$extras);
    }
}
