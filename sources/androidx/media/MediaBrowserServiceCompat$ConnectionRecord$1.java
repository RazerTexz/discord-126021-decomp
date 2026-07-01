package androidx.media;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$ConnectionRecord$1 implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ConnectionRecord this$1;

    public MediaBrowserServiceCompat$ConnectionRecord$1(MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord) {
        this.this$1 = mediaBrowserServiceCompat$ConnectionRecord;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = this.this$1;
        mediaBrowserServiceCompat$ConnectionRecord.this$0.mConnections.remove(mediaBrowserServiceCompat$ConnectionRecord.callbacks.asBinder());
    }
}
