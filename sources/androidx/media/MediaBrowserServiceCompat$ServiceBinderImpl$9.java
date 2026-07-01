package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$ServiceBinderImpl$9 implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ String val$action;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    public final /* synthetic */ Bundle val$extras;
    public final /* synthetic */ ResultReceiver val$receiver;

    public MediaBrowserServiceCompat$ServiceBinderImpl$9(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
        this.val$action = str;
        this.val$extras = bundle;
        this.val$receiver = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
        if (mediaBrowserServiceCompat$ConnectionRecord != null) {
            this.this$1.this$0.performCustomAction(this.val$action, this.val$extras, mediaBrowserServiceCompat$ConnectionRecord, this.val$receiver);
            return;
        }
        StringBuilder sbU = a.U("sendCustomAction for callback that isn't registered action=");
        sbU.append(this.val$action);
        sbU.append(", extras=");
        sbU.append(this.val$extras);
        Log.w(MediaBrowserServiceCompat.TAG, sbU.toString());
    }
}
