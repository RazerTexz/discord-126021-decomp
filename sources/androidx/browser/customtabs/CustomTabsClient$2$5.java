package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsClient$2$5 implements Runnable {
    public final /* synthetic */ CustomTabsClient$2 this$1;
    public final /* synthetic */ Bundle val$extras;
    public final /* synthetic */ int val$relation;
    public final /* synthetic */ Uri val$requestedOrigin;
    public final /* synthetic */ boolean val$result;

    public CustomTabsClient$2$5(CustomTabsClient$2 customTabsClient$2, int i, Uri uri, boolean z2, Bundle bundle) {
        this.this$1 = customTabsClient$2;
        this.val$relation = i;
        this.val$requestedOrigin = uri;
        this.val$result = z2;
        this.val$extras = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.val$callback.onRelationshipValidationResult(this.val$relation, this.val$requestedOrigin, this.val$result, this.val$extras);
    }
}
