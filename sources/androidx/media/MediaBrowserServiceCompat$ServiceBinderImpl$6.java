package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$ServiceBinderImpl$6 implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    public final /* synthetic */ int val$pid;
    public final /* synthetic */ String val$pkg;
    public final /* synthetic */ Bundle val$rootHints;
    public final /* synthetic */ int val$uid;

    public MediaBrowserServiceCompat$ServiceBinderImpl$6(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, int i, String str, int i2, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
        this.val$uid = i;
        this.val$pkg = str;
        this.val$pid = i2;
        this.val$rootHints = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord;
        IBinder iBinderAsBinder = this.val$callbacks.asBinder();
        this.this$1.this$0.mConnections.remove(iBinderAsBinder);
        Iterator<MediaBrowserServiceCompat$ConnectionRecord> it = this.this$1.this$0.mPendingConnections.iterator();
        while (true) {
            mediaBrowserServiceCompat$ConnectionRecord = null;
            if (!it.hasNext()) {
                break;
            }
            MediaBrowserServiceCompat$ConnectionRecord next = it.next();
            if (next.uid == this.val$uid) {
                mediaBrowserServiceCompat$ConnectionRecord = (TextUtils.isEmpty(this.val$pkg) || this.val$pid <= 0) ? new MediaBrowserServiceCompat$ConnectionRecord(this.this$1.this$0, next.pkg, next.pid, next.uid, this.val$rootHints, this.val$callbacks) : null;
                it.remove();
                break;
            }
        }
        if (mediaBrowserServiceCompat$ConnectionRecord == null) {
            mediaBrowserServiceCompat$ConnectionRecord = new MediaBrowserServiceCompat$ConnectionRecord(this.this$1.this$0, this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
        }
        this.this$1.this$0.mConnections.put(iBinderAsBinder, mediaBrowserServiceCompat$ConnectionRecord);
        try {
            iBinderAsBinder.linkToDeath(mediaBrowserServiceCompat$ConnectionRecord, 0);
        } catch (RemoteException unused) {
            Log.w(MediaBrowserServiceCompat.TAG, "IBinder is already dead.");
        }
    }
}
