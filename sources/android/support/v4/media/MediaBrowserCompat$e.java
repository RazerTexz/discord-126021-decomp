package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Process;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserProtocol;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaBrowserCompat$e implements MediaBrowserCompat$d, MediaBrowserCompat$h, MediaBrowserCompat$c$b {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaBrowser f16b;
    public final Bundle c;
    public final MediaBrowserCompat$b d = new MediaBrowserCompat$b(this);
    public final ArrayMap<String, MediaBrowserCompat$j> e = new ArrayMap<>();
    public MediaBrowserCompat$i f;
    public Messenger g;
    public MediaSessionCompat$Token h;

    public MediaBrowserCompat$e(Context context, ComponentName componentName, MediaBrowserCompat$c mediaBrowserCompat$c, Bundle bundle) {
        this.a = context;
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        this.c = bundle2;
        bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
        bundle2.putInt(MediaBrowserProtocol.EXTRA_CALLING_PID, Process.myPid());
        mediaBrowserCompat$c.setInternalConnectionCallback(this);
        this.f16b = new MediaBrowser(context, componentName, mediaBrowserCompat$c.mConnectionCallbackFwk, bundle2);
    }

    @Override // android.support.v4.media.MediaBrowserCompat$h
    public void a(Messenger messenger, String str, MediaSessionCompat$Token mediaSessionCompat$Token, Bundle bundle) {
    }

    @Override // android.support.v4.media.MediaBrowserCompat$h
    public void b(Messenger messenger, String str, List<MediaBrowserCompat$MediaItem> list, Bundle bundle, Bundle bundle2) {
        if (this.g != messenger) {
            return;
        }
        MediaBrowserCompat$j mediaBrowserCompat$j = this.e.get(str);
        if (mediaBrowserCompat$j != null) {
            mediaBrowserCompat$j.a(bundle);
        } else if (MediaBrowserCompat.a) {
            Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
        }
    }

    @Override // android.support.v4.media.MediaBrowserCompat$h
    public void c(Messenger messenger) {
    }
}
