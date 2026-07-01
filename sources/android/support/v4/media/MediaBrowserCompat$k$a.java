package android.support.v4.media;

import android.media.browse.MediaBrowser$MediaItem;
import android.media.browse.MediaBrowser$SubscriptionCallback;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaBrowserCompat$k$a extends MediaBrowser$SubscriptionCallback {
    public final /* synthetic */ MediaBrowserCompat$k a;

    public MediaBrowserCompat$k$a(MediaBrowserCompat$k mediaBrowserCompat$k) {
        this.a = mediaBrowserCompat$k;
    }

    @Override // android.media.browse.MediaBrowser$SubscriptionCallback
    public void onChildrenLoaded(@NonNull String str, List<MediaBrowser$MediaItem> list) {
        Objects.requireNonNull(this.a);
        MediaBrowserCompat$k mediaBrowserCompat$k = this.a;
        MediaBrowserCompat$MediaItem.a(list);
        Objects.requireNonNull(mediaBrowserCompat$k);
    }

    @Override // android.media.browse.MediaBrowser$SubscriptionCallback
    public void onError(@NonNull String str) {
        Objects.requireNonNull(this.a);
    }
}
