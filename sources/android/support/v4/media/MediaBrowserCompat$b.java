package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat$b extends Handler {
    public final WeakReference<MediaBrowserCompat$h> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Messenger> f15b;

    public MediaBrowserCompat$b(MediaBrowserCompat$h mediaBrowserCompat$h) {
        this.a = new WeakReference<>(mediaBrowserCompat$h);
    }

    public void a(Messenger messenger) {
        this.f15b = new WeakReference<>(messenger);
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        WeakReference<Messenger> weakReference = this.f15b;
        if (weakReference == null || weakReference.get() == null || this.a.get() == null) {
            return;
        }
        Bundle data = message.getData();
        MediaSessionCompat.a(data);
        MediaBrowserCompat$h mediaBrowserCompat$h = this.a.get();
        Messenger messenger = this.f15b.get();
        try {
            int i = message.what;
            if (i == 1) {
                Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                MediaSessionCompat.a(bundle);
                mediaBrowserCompat$h.a(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat$Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
            } else if (i == 2) {
                mediaBrowserCompat$h.c(messenger);
            } else if (i != 3) {
                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
            } else {
                Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                MediaSessionCompat.a(bundle2);
                Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                MediaSessionCompat.a(bundle3);
                mediaBrowserCompat$h.b(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
            if (message.what == 1) {
                mediaBrowserCompat$h.c(messenger);
            }
        }
    }
}
