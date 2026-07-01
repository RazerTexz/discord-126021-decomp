package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import x.a.a.a$a;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsSessionToken$MockCallback extends a$a {
    @Override // x.a.a.a$a, android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // x.a.a.a
    public void extraCallback(String str, Bundle bundle) {
    }

    @Override // x.a.a.a
    public Bundle extraCallbackWithResult(String str, Bundle bundle) {
        return null;
    }

    @Override // x.a.a.a
    public void onMessageChannelReady(Bundle bundle) {
    }

    @Override // x.a.a.a
    public void onNavigationEvent(int i, Bundle bundle) {
    }

    @Override // x.a.a.a
    public void onPostMessage(String str, Bundle bundle) {
    }

    @Override // x.a.a.a
    public void onRelationshipValidationResult(int i, Uri uri, boolean z2, Bundle bundle) {
    }
}
