package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$ServiceBinderImpl$3 implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    public final /* synthetic */ String val$id;
    public final /* synthetic */ Bundle val$options;
    public final /* synthetic */ IBinder val$token;

    public MediaBrowserServiceCompat$ServiceBinderImpl$3(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, String str, IBinder iBinder, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
        this.val$id = str;
        this.val$token = iBinder;
        this.val$options = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
        if (mediaBrowserServiceCompat$ConnectionRecord == null) {
            a.r0(a.U("addSubscription for callback that isn't registered id="), this.val$id, MediaBrowserServiceCompat.TAG);
        } else {
            this.this$1.this$0.addSubscription(this.val$id, mediaBrowserServiceCompat$ConnectionRecord, this.val$token, this.val$options);
        }
    }
}
