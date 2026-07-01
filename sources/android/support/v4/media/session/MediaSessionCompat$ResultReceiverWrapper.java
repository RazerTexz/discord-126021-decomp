package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaSessionCompat$ResultReceiverWrapper implements Parcelable {
    public static final Parcelable$Creator<MediaSessionCompat$ResultReceiverWrapper> CREATOR = new MediaSessionCompat$ResultReceiverWrapper$a();
    public ResultReceiver j;

    public MediaSessionCompat$ResultReceiverWrapper(Parcel parcel) {
        this.j = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.j.writeToParcel(parcel, i);
    }
}
