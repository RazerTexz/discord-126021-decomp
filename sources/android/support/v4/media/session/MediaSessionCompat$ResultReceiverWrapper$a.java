package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat$ResultReceiverWrapper$a implements Parcelable$Creator<MediaSessionCompat$ResultReceiverWrapper> {
    @Override // android.os.Parcelable$Creator
    public MediaSessionCompat$ResultReceiverWrapper createFromParcel(Parcel parcel) {
        return new MediaSessionCompat$ResultReceiverWrapper(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public MediaSessionCompat$ResultReceiverWrapper[] newArray(int i) {
        return new MediaSessionCompat$ResultReceiverWrapper[i];
    }
}
