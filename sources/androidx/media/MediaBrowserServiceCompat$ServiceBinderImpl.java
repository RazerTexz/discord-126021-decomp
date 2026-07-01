package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$ServiceBinderImpl {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    public MediaBrowserServiceCompat$ServiceBinderImpl(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
    }

    public void addSubscription(String str, IBinder iBinder, Bundle bundle, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        this.this$0.mHandler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$3(this, mediaBrowserServiceCompat$ServiceCallbacks, str, iBinder, bundle));
    }

    public void connect(String str, int i, int i2, Bundle bundle, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        if (this.this$0.isValidPackage(str, i2)) {
            this.this$0.mHandler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$1(this, mediaBrowserServiceCompat$ServiceCallbacks, str, i, i2, bundle));
            return;
        }
        throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + str);
    }

    public void disconnect(MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        this.this$0.mHandler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$2(this, mediaBrowserServiceCompat$ServiceCallbacks));
    }

    public void getMediaItem(String str, ResultReceiver resultReceiver, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        if (TextUtils.isEmpty(str) || resultReceiver == null) {
            return;
        }
        this.this$0.mHandler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$5(this, mediaBrowserServiceCompat$ServiceCallbacks, str, resultReceiver));
    }

    public void registerCallbacks(MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, String str, int i, int i2, Bundle bundle) {
        this.this$0.mHandler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$6(this, mediaBrowserServiceCompat$ServiceCallbacks, i2, str, i, bundle));
    }

    public void removeSubscription(String str, IBinder iBinder, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        this.this$0.mHandler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$4(this, mediaBrowserServiceCompat$ServiceCallbacks, str, iBinder));
    }

    public void search(String str, Bundle bundle, ResultReceiver resultReceiver, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        if (TextUtils.isEmpty(str) || resultReceiver == null) {
            return;
        }
        this.this$0.mHandler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$8(this, mediaBrowserServiceCompat$ServiceCallbacks, str, bundle, resultReceiver));
    }

    public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        if (TextUtils.isEmpty(str) || resultReceiver == null) {
            return;
        }
        this.this$0.mHandler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$9(this, mediaBrowserServiceCompat$ServiceCallbacks, str, bundle, resultReceiver));
    }

    public void unregisterCallbacks(MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        this.this$0.mHandler.postOrRun(new MediaBrowserServiceCompat$ServiceBinderImpl$7(this, mediaBrowserServiceCompat$ServiceCallbacks));
    }
}
