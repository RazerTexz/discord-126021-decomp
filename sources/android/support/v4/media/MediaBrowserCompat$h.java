package android.support.v4.media;

import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface MediaBrowserCompat$h {
    void a(Messenger messenger, String str, MediaSessionCompat$Token mediaSessionCompat$Token, Bundle bundle);

    void b(Messenger messenger, String str, List<MediaBrowserCompat$MediaItem> list, Bundle bundle, Bundle bundle2);

    void c(Messenger messenger);
}
