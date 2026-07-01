package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat$Token$a implements Parcelable$Creator<MediaSessionCompat$Token> {
    @Override // android.os.Parcelable$Creator
    public MediaSessionCompat$Token createFromParcel(Parcel parcel) {
        return new MediaSessionCompat$Token(parcel.readParcelable(null));
    }

    @Override // android.os.Parcelable$Creator
    public MediaSessionCompat$Token[] newArray(int i) {
        return new MediaSessionCompat$Token[i];
    }
}
