package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class RatingCompat$a implements Parcelable$Creator<RatingCompat> {
    @Override // android.os.Parcelable$Creator
    public RatingCompat createFromParcel(Parcel parcel) {
        return new RatingCompat(parcel.readInt(), parcel.readFloat());
    }

    @Override // android.os.Parcelable$Creator
    public RatingCompat[] newArray(int i) {
        return new RatingCompat[i];
    }
}
