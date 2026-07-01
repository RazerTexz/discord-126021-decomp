package androidx.media;

import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import b.d.b.a.a;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1 implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplBase this$1;
    public final /* synthetic */ MediaSessionCompat$Token val$token;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1(MediaBrowserServiceCompat$MediaBrowserServiceImplBase mediaBrowserServiceCompat$MediaBrowserServiceImplBase, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplBase;
        this.val$token = mediaSessionCompat$Token;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<MediaBrowserServiceCompat$ConnectionRecord> it = this.this$1.this$0.mConnections.values().iterator();
        while (it.hasNext()) {
            MediaBrowserServiceCompat$ConnectionRecord next = it.next();
            try {
                next.callbacks.onConnect(next.root.getRootId(), this.val$token, next.root.getExtras());
            } catch (RemoteException unused) {
                StringBuilder sbU = a.U("Connection for ");
                sbU.append(next.pkg);
                sbU.append(" is no longer valid.");
                Log.w(MediaBrowserServiceCompat.TAG, sbU.toString());
                it.remove();
            }
        }
    }
}
