package android.support.v4.media;

import android.media.MediaDescription;
import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class MediaDescriptionCompat$a implements Parcelable$Creator<MediaDescriptionCompat> {
    @Override // android.os.Parcelable$Creator
    public MediaDescriptionCompat createFromParcel(Parcel parcel) {
        return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
    }

    @Override // android.os.Parcelable$Creator
    public MediaDescriptionCompat[] newArray(int i) {
        return new MediaDescriptionCompat[i];
    }
}
