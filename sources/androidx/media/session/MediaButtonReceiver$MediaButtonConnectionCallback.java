package androidx.media.session;

import android.content.BroadcastReceiver$PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat$c;
import android.support.v4.media.MediaBrowserCompat$e;
import android.support.v4.media.MediaBrowserCompat$i;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import android.view.KeyEvent;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver$MediaButtonConnectionCallback extends MediaBrowserCompat$c {
    private final Context mContext;
    private final Intent mIntent;
    private MediaBrowserCompat mMediaBrowser;
    private final BroadcastReceiver$PendingResult mPendingResult;

    public MediaButtonReceiver$MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver$PendingResult broadcastReceiver$PendingResult) {
        this.mContext = context;
        this.mIntent = intent;
        this.mPendingResult = broadcastReceiver$PendingResult;
    }

    private void finish() {
        Messenger messenger;
        MediaBrowserCompat$e mediaBrowserCompat$e = (MediaBrowserCompat$e) this.mMediaBrowser.f14b;
        MediaBrowserCompat$i mediaBrowserCompat$i = mediaBrowserCompat$e.f;
        if (mediaBrowserCompat$i != null && (messenger = mediaBrowserCompat$e.g) != null) {
            try {
                mediaBrowserCompat$i.a(7, null, messenger);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
            }
        }
        mediaBrowserCompat$e.f16b.disconnect();
        this.mPendingResult.finish();
    }

    @Override // android.support.v4.media.MediaBrowserCompat$c
    public void onConnected() {
        Context context = this.mContext;
        MediaBrowserCompat$e mediaBrowserCompat$e = (MediaBrowserCompat$e) this.mMediaBrowser.f14b;
        if (mediaBrowserCompat$e.h == null) {
            mediaBrowserCompat$e.h = MediaSessionCompat$Token.a(mediaBrowserCompat$e.f16b.getSessionToken(), null);
        }
        MediaSessionCompat$Token mediaSessionCompat$Token = mediaBrowserCompat$e.h;
        new ConcurrentHashMap();
        if (mediaSessionCompat$Token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = new MediaControllerCompat$MediaControllerImplApi21(context, mediaSessionCompat$Token);
        KeyEvent keyEvent = (KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        mediaControllerCompat$MediaControllerImplApi21.a.dispatchMediaButtonEvent(keyEvent);
        finish();
    }

    @Override // android.support.v4.media.MediaBrowserCompat$c
    public void onConnectionFailed() {
        finish();
    }

    @Override // android.support.v4.media.MediaBrowserCompat$c
    public void onConnectionSuspended() {
        finish();
    }

    public void setMediaBrowser(MediaBrowserCompat mediaBrowserCompat) {
        this.mMediaBrowser = mediaBrowserCompat;
    }
}
