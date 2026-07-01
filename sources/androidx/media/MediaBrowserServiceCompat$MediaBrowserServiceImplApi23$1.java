package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1 extends MediaBrowserServiceCompat$Result<MediaBrowserCompat$MediaItem> {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ResultWrapper val$resultWrapper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1(MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23, Object obj, MediaBrowserServiceCompat$ResultWrapper mediaBrowserServiceCompat$ResultWrapper) {
        super(obj);
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi23;
        this.val$resultWrapper = mediaBrowserServiceCompat$ResultWrapper;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$Result
    public void detach() {
        this.val$resultWrapper.detach();
    }

    @Override // androidx.media.MediaBrowserServiceCompat$Result
    public /* bridge */ /* synthetic */ void onResultSent(@Nullable MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem) {
        onResultSent2(mediaBrowserCompat$MediaItem);
    }

    /* JADX INFO: renamed from: onResultSent, reason: avoid collision after fix types in other method */
    public void onResultSent2(@Nullable MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem) {
        if (mediaBrowserCompat$MediaItem == null) {
            this.val$resultWrapper.sendResult(null);
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        mediaBrowserCompat$MediaItem.writeToParcel(parcelObtain, 0);
        this.val$resultWrapper.sendResult(parcelObtain);
    }
}
