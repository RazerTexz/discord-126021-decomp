package androidx.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.browse.MediaBrowser$MediaItem;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.service.media.MediaBrowserService$BrowserRoot;
import android.service.media.MediaBrowserService$Result;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21 extends MediaBrowserService {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21(MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21, Context context) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
        attachBaseContext(context);
    }

    @Override // android.service.media.MediaBrowserService
    @SuppressLint({"SyntheticAccessor"})
    public MediaBrowserService$BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        MediaBrowserServiceCompat$BrowserRoot mediaBrowserServiceCompat$BrowserRootOnGetRoot = this.this$1.onGetRoot(str, i, bundle == null ? null : new Bundle(bundle));
        if (mediaBrowserServiceCompat$BrowserRootOnGetRoot == null) {
            return null;
        }
        return new MediaBrowserService$BrowserRoot(MediaBrowserServiceCompat$BrowserRoot.access$000(mediaBrowserServiceCompat$BrowserRootOnGetRoot), MediaBrowserServiceCompat$BrowserRoot.access$100(mediaBrowserServiceCompat$BrowserRootOnGetRoot));
    }

    @Override // android.service.media.MediaBrowserService
    public void onLoadChildren(String str, MediaBrowserService$Result<List<MediaBrowser$MediaItem>> mediaBrowserService$Result) {
        this.this$1.onLoadChildren(str, new MediaBrowserServiceCompat$ResultWrapper<>(mediaBrowserService$Result));
    }
}
