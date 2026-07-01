package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem$a implements Parcelable$Creator<MediaBrowserCompat$MediaItem> {
    @Override // android.os.Parcelable$Creator
    public MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
        return new MediaBrowserCompat$MediaItem(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public MediaBrowserCompat$MediaItem[] newArray(int i) {
        return new MediaBrowserCompat$MediaItem[i];
    }
}
