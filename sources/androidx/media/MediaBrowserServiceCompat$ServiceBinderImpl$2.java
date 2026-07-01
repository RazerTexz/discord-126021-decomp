package androidx.media;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$ServiceBinderImpl$2 implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;

    public MediaBrowserServiceCompat$ServiceBinderImpl$2(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecordRemove = this.this$1.this$0.mConnections.remove(this.val$callbacks.asBinder());
        if (mediaBrowserServiceCompat$ConnectionRecordRemove != null) {
            mediaBrowserServiceCompat$ConnectionRecordRemove.callbacks.asBinder().unlinkToDeath(mediaBrowserServiceCompat$ConnectionRecordRemove, 0);
        }
    }
}
