package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class PlaybackStateCompat$CustomAction$a implements Parcelable$Creator<PlaybackStateCompat$CustomAction> {
    @Override // android.os.Parcelable$Creator
    public PlaybackStateCompat$CustomAction createFromParcel(Parcel parcel) {
        return new PlaybackStateCompat$CustomAction(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public PlaybackStateCompat$CustomAction[] newArray(int i) {
        return new PlaybackStateCompat$CustomAction[i];
    }
}
