package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder$DeathRecipient;
import androidx.core.util.Pair;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$ConnectionRecord implements IBinder$DeathRecipient {
    public final MediaSessionManager$RemoteUserInfo browserInfo;
    public final MediaBrowserServiceCompat$ServiceCallbacks callbacks;
    public final int pid;
    public final String pkg;
    public MediaBrowserServiceCompat$BrowserRoot root;
    public final Bundle rootHints;
    public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap<>();
    public final /* synthetic */ MediaBrowserServiceCompat this$0;
    public final int uid;

    public MediaBrowserServiceCompat$ConnectionRecord(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, int i, int i2, Bundle bundle, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        this.this$0 = mediaBrowserServiceCompat;
        this.pkg = str;
        this.pid = i;
        this.uid = i2;
        this.browserInfo = new MediaSessionManager$RemoteUserInfo(str, i, i2);
        this.rootHints = bundle;
        this.callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
    }

    @Override // android.os.IBinder$DeathRecipient
    public void binderDied() {
        this.this$0.mHandler.post(new MediaBrowserServiceCompat$ConnectionRecord$1(this));
    }
}
