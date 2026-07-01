package android.support.v4.media;

import android.content.Context;
import android.media.browse.MediaBrowser$ConnectionCallback;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import java.util.Objects;
import x.a.b.b.a.b;
import x.a.b.b.a.b$a;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaBrowserCompat$c$a extends MediaBrowser$ConnectionCallback {
    public final /* synthetic */ MediaBrowserCompat$c a;

    public MediaBrowserCompat$c$a(MediaBrowserCompat$c mediaBrowserCompat$c) {
        this.a = mediaBrowserCompat$c;
    }

    @Override // android.media.browse.MediaBrowser$ConnectionCallback
    public void onConnected() {
        MediaBrowserCompat$c$b mediaBrowserCompat$c$b = this.a.mConnectionCallbackInternal;
        if (mediaBrowserCompat$c$b != null) {
            MediaBrowserCompat$e mediaBrowserCompat$e = (MediaBrowserCompat$e) mediaBrowserCompat$c$b;
            Objects.requireNonNull(mediaBrowserCompat$e);
            try {
                Bundle extras = mediaBrowserCompat$e.f16b.getExtras();
                if (extras != null) {
                    extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                    IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                    if (binder != null) {
                        mediaBrowserCompat$e.f = new MediaBrowserCompat$i(binder, mediaBrowserCompat$e.c);
                        Messenger messenger = new Messenger(mediaBrowserCompat$e.d);
                        mediaBrowserCompat$e.g = messenger;
                        mediaBrowserCompat$e.d.a(messenger);
                        try {
                            MediaBrowserCompat$i mediaBrowserCompat$i = mediaBrowserCompat$e.f;
                            Context context = mediaBrowserCompat$e.a;
                            Messenger messenger2 = mediaBrowserCompat$e.g;
                            Objects.requireNonNull(mediaBrowserCompat$i);
                            Bundle bundle = new Bundle();
                            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                            bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
                            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, mediaBrowserCompat$i.f17b);
                            mediaBrowserCompat$i.a(6, bundle, messenger2);
                        } catch (RemoteException unused) {
                            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                        }
                    }
                    b bVarC = b$a.c(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                    if (bVarC != null) {
                        mediaBrowserCompat$e.h = MediaSessionCompat$Token.a(mediaBrowserCompat$e.f16b.getSessionToken(), bVarC);
                    }
                }
            } catch (IllegalStateException e) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e);
            }
        }
        this.a.onConnected();
    }

    @Override // android.media.browse.MediaBrowser$ConnectionCallback
    public void onConnectionFailed() {
        MediaBrowserCompat$c$b mediaBrowserCompat$c$b = this.a.mConnectionCallbackInternal;
        if (mediaBrowserCompat$c$b != null) {
            Objects.requireNonNull((MediaBrowserCompat$e) mediaBrowserCompat$c$b);
        }
        this.a.onConnectionFailed();
    }

    @Override // android.media.browse.MediaBrowser$ConnectionCallback
    public void onConnectionSuspended() {
        MediaBrowserCompat$c$b mediaBrowserCompat$c$b = this.a.mConnectionCallbackInternal;
        if (mediaBrowserCompat$c$b != null) {
            MediaBrowserCompat$e mediaBrowserCompat$e = (MediaBrowserCompat$e) mediaBrowserCompat$c$b;
            mediaBrowserCompat$e.f = null;
            mediaBrowserCompat$e.g = null;
            mediaBrowserCompat$e.h = null;
            mediaBrowserCompat$e.d.a(null);
        }
        this.a.onConnectionSuspended();
    }
}
