package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser$MediaItem;
import android.service.media.MediaBrowserService$Result;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23 extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21 {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23(MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23, Context context) {
        super(mediaBrowserServiceCompat$MediaBrowserServiceImplApi23, context);
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi23;
    }

    @Override // android.service.media.MediaBrowserService
    public void onLoadItem(String str, MediaBrowserService$Result<MediaBrowser$MediaItem> mediaBrowserService$Result) {
        this.this$1.onLoadItem(str, new MediaBrowserServiceCompat$ResultWrapper<>(mediaBrowserService$Result));
    }
}
