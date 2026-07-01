package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$ServiceBinderImpl$1 implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    public final /* synthetic */ int val$pid;
    public final /* synthetic */ String val$pkg;
    public final /* synthetic */ Bundle val$rootHints;
    public final /* synthetic */ int val$uid;

    public MediaBrowserServiceCompat$ServiceBinderImpl$1(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, String str, int i, int i2, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
        this.val$pkg = str;
        this.val$pid = i;
        this.val$uid = i2;
        this.val$rootHints = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder iBinderAsBinder = this.val$callbacks.asBinder();
        this.this$1.this$0.mConnections.remove(iBinderAsBinder);
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = new MediaBrowserServiceCompat$ConnectionRecord(this.this$1.this$0, this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$1.this$0;
        mediaBrowserServiceCompat.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
        MediaBrowserServiceCompat$BrowserRoot mediaBrowserServiceCompat$BrowserRootOnGetRoot = mediaBrowserServiceCompat.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
        mediaBrowserServiceCompat$ConnectionRecord.root = mediaBrowserServiceCompat$BrowserRootOnGetRoot;
        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = this.this$1.this$0;
        mediaBrowserServiceCompat2.mCurConnection = null;
        if (mediaBrowserServiceCompat$BrowserRootOnGetRoot == null) {
            StringBuilder sbU = a.U("No root for client ");
            sbU.append(this.val$pkg);
            sbU.append(" from service ");
            sbU.append(getClass().getName());
            Log.i(MediaBrowserServiceCompat.TAG, sbU.toString());
            try {
                this.val$callbacks.onConnectFailed();
                return;
            } catch (RemoteException unused) {
                a.r0(a.U("Calling onConnectFailed() failed. Ignoring. pkg="), this.val$pkg, MediaBrowserServiceCompat.TAG);
                return;
            }
        }
        try {
            mediaBrowserServiceCompat2.mConnections.put(iBinderAsBinder, mediaBrowserServiceCompat$ConnectionRecord);
            iBinderAsBinder.linkToDeath(mediaBrowserServiceCompat$ConnectionRecord, 0);
            if (this.this$1.this$0.mSession != null) {
                this.val$callbacks.onConnect(mediaBrowserServiceCompat$ConnectionRecord.root.getRootId(), this.this$1.this$0.mSession, mediaBrowserServiceCompat$ConnectionRecord.root.getExtras());
            }
        } catch (RemoteException unused2) {
            a.r0(a.U("Calling onConnect() failed. Dropping client. pkg="), this.val$pkg, MediaBrowserServiceCompat.TAG);
            this.this$1.this$0.mConnections.remove(iBinderAsBinder);
        }
    }
}
