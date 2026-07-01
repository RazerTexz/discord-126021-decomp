package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {
    public static final boolean a = Log.isLoggable("MediaBrowserCompat", 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaBrowserCompat$d f14b;

    public MediaBrowserCompat(Context context, ComponentName componentName, MediaBrowserCompat$c mediaBrowserCompat$c, Bundle bundle) {
        int i = Build$VERSION.SDK_INT;
        if (i >= 26) {
            this.f14b = new MediaBrowserCompat$g(context, componentName, mediaBrowserCompat$c, null);
        } else if (i >= 23) {
            this.f14b = new MediaBrowserCompat$f(context, componentName, mediaBrowserCompat$c, null);
        } else {
            this.f14b = new MediaBrowserCompat$e(context, componentName, mediaBrowserCompat$c, null);
        }
    }
}
