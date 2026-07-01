package android.support.v4.media;

import android.os.Binder;
import android.os.Build$VERSION;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserCompat$k {
    public final IBinder a = new Binder();

    public MediaBrowserCompat$k() {
        if (Build$VERSION.SDK_INT >= 26) {
            new MediaBrowserCompat$k$b(this);
        } else {
            new MediaBrowserCompat$k$a(this);
        }
    }
}
