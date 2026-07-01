package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2 extends MediaBrowserServiceCompat$Result<List<MediaBrowserCompat$MediaItem>> {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ResultWrapper val$resultWrapper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2(MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21, Object obj, MediaBrowserServiceCompat$ResultWrapper mediaBrowserServiceCompat$ResultWrapper) {
        super(obj);
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
        this.val$resultWrapper = mediaBrowserServiceCompat$ResultWrapper;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$Result
    public void detach() {
        this.val$resultWrapper.detach();
    }

    @Override // androidx.media.MediaBrowserServiceCompat$Result
    public /* bridge */ /* synthetic */ void onResultSent(@Nullable List<MediaBrowserCompat$MediaItem> list) {
        onResultSent2(list);
    }

    /* JADX INFO: renamed from: onResultSent, reason: avoid collision after fix types in other method */
    public void onResultSent2(@Nullable List<MediaBrowserCompat$MediaItem> list) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList();
            for (MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem : list) {
                Parcel parcelObtain = Parcel.obtain();
                mediaBrowserCompat$MediaItem.writeToParcel(parcelObtain, 0);
                arrayList.add(parcelObtain);
            }
        } else {
            arrayList = null;
        }
        this.val$resultWrapper.sendResult(arrayList);
    }
}
