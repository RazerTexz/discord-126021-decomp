package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsSessionToken$1 extends CustomTabsCallback {
    public final /* synthetic */ CustomTabsSessionToken this$0;

    public CustomTabsSessionToken$1(CustomTabsSessionToken customTabsSessionToken) {
        this.this$0 = customTabsSessionToken;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public void extraCallback(@NonNull String str, @Nullable Bundle bundle) {
        try {
            this.this$0.mCallbackBinder.extraCallback(str, bundle);
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    @NonNull
    public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) {
        try {
            return this.this$0.mCallbackBinder.extraCallbackWithResult(str, bundle);
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            return null;
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public void onMessageChannelReady(@Nullable Bundle bundle) {
        try {
            this.this$0.mCallbackBinder.onMessageChannelReady(bundle);
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public void onNavigationEvent(int i, @Nullable Bundle bundle) {
        try {
            this.this$0.mCallbackBinder.onNavigationEvent(i, bundle);
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public void onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
        try {
            this.this$0.mCallbackBinder.onPostMessage(str, bundle);
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public void onRelationshipValidationResult(int i, @NonNull Uri uri, boolean z2, @Nullable Bundle bundle) {
        try {
            this.this$0.mCallbackBinder.onRelationshipValidationResult(i, uri, z2, bundle);
        } catch (RemoteException unused) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
        }
    }
}
