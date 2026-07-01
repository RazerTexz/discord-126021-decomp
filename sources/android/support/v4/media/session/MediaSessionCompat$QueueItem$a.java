package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat$QueueItem$a implements Parcelable$Creator<MediaSessionCompat$QueueItem> {
    @Override // android.os.Parcelable$Creator
    public MediaSessionCompat$QueueItem createFromParcel(Parcel parcel) {
        return new MediaSessionCompat$QueueItem(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public MediaSessionCompat$QueueItem[] newArray(int i) {
        return new MediaSessionCompat$QueueItem[i];
    }
}
