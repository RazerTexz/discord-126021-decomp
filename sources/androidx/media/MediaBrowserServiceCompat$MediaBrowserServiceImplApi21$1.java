package androidx.media;

import android.support.v4.media.session.MediaSessionCompat$Token;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1 implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1;
    public final /* synthetic */ MediaSessionCompat$Token val$token;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1(MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
        this.val$token = mediaSessionCompat$Token;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.setSessionTokenOnHandler(this.val$token);
    }
}
