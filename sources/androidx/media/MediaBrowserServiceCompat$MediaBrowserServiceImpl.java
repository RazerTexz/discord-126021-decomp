package androidx.media;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat$Token;

/* JADX INFO: loaded from: classes.dex */
public interface MediaBrowserServiceCompat$MediaBrowserServiceImpl {
    Bundle getBrowserRootHints();

    MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo();

    void notifyChildrenChanged(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String str, Bundle bundle);

    void notifyChildrenChanged(String str, Bundle bundle);

    IBinder onBind(Intent intent);

    void onCreate();

    void setSessionToken(MediaSessionCompat$Token mediaSessionCompat$Token);
}
