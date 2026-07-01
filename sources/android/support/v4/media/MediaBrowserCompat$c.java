package android.support.v4.media;

import android.media.browse.MediaBrowser$ConnectionCallback;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat$c {
    public final MediaBrowser$ConnectionCallback mConnectionCallbackFwk = new MediaBrowserCompat$c$a(this);
    public MediaBrowserCompat$c$b mConnectionCallbackInternal;

    public void onConnected() {
        throw null;
    }

    public void onConnectionFailed() {
        throw null;
    }

    public void onConnectionSuspended() {
        throw null;
    }

    public void setInternalConnectionCallback(MediaBrowserCompat$c$b mediaBrowserCompat$c$b) {
        this.mConnectionCallbackInternal = mediaBrowserCompat$c$b;
    }
}
