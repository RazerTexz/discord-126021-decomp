package android.support.v4.media;

import android.media.browse.MediaBrowser$MediaItem;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public class MediaBrowserCompat$k$b extends MediaBrowserCompat$k$a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserCompat$k f19b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserCompat$k$b(MediaBrowserCompat$k mediaBrowserCompat$k) {
        super(mediaBrowserCompat$k);
        this.f19b = mediaBrowserCompat$k;
    }

    @Override // android.media.browse.MediaBrowser$SubscriptionCallback
    public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowser$MediaItem> list, @NonNull Bundle bundle) {
        MediaSessionCompat.a(bundle);
        MediaBrowserCompat$k mediaBrowserCompat$k = this.f19b;
        MediaBrowserCompat$MediaItem.a(list);
        Objects.requireNonNull(mediaBrowserCompat$k);
    }

    @Override // android.media.browse.MediaBrowser$SubscriptionCallback
    public void onError(@NonNull String str, @NonNull Bundle bundle) {
        MediaSessionCompat.a(bundle);
        Objects.requireNonNull(this.f19b);
    }
}
