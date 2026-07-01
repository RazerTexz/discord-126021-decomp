package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import x.a.a.a$a;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsClient$2 extends a$a {
    private Handler mHandler = new Handler(Looper.getMainLooper());
    public final /* synthetic */ CustomTabsClient this$0;
    public final /* synthetic */ CustomTabsCallback val$callback;

    public CustomTabsClient$2(CustomTabsClient customTabsClient, CustomTabsCallback customTabsCallback) {
        this.this$0 = customTabsClient;
        this.val$callback = customTabsCallback;
    }

    @Override // x.a.a.a
    public void extraCallback(String str, Bundle bundle) throws RemoteException {
        if (this.val$callback == null) {
            return;
        }
        this.mHandler.post(new CustomTabsClient$2$2(this, str, bundle));
    }

    @Override // x.a.a.a
    public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) throws RemoteException {
        CustomTabsCallback customTabsCallback = this.val$callback;
        if (customTabsCallback == null) {
            return null;
        }
        return customTabsCallback.extraCallbackWithResult(str, bundle);
    }

    @Override // x.a.a.a
    public void onMessageChannelReady(Bundle bundle) throws RemoteException {
        if (this.val$callback == null) {
            return;
        }
        this.mHandler.post(new CustomTabsClient$2$3(this, bundle));
    }

    @Override // x.a.a.a
    public void onNavigationEvent(int i, Bundle bundle) {
        if (this.val$callback == null) {
            return;
        }
        this.mHandler.post(new CustomTabsClient$2$1(this, i, bundle));
    }

    @Override // x.a.a.a
    public void onPostMessage(String str, Bundle bundle) throws RemoteException {
        if (this.val$callback == null) {
            return;
        }
        this.mHandler.post(new CustomTabsClient$2$4(this, str, bundle));
    }

    @Override // x.a.a.a
    public void onRelationshipValidationResult(int i, Uri uri, boolean z2, @Nullable Bundle bundle) throws RemoteException {
        if (this.val$callback == null) {
            return;
        }
        this.mHandler.post(new CustomTabsClient$2$5(this, i, uri, z2, bundle));
    }
}
