package android.support.v4.media;

import android.media.MediaDescription;
import android.media.browse.MediaBrowser$MediaItem;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaBrowserCompat$a {
    @DoNotInline
    public static MediaDescription a(MediaBrowser$MediaItem mediaBrowser$MediaItem) {
        return mediaBrowser$MediaItem.getDescription();
    }

    @DoNotInline
    public static int b(MediaBrowser$MediaItem mediaBrowser$MediaItem) {
        return mediaBrowser$MediaItem.getFlags();
    }
}
