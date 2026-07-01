package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.MediaSession$QueueItem;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.support.v4.media.MediaDescriptionCompat;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable$Creator<MediaSessionCompat$QueueItem> CREATOR = new MediaSessionCompat$QueueItem$a();
    public final MediaDescriptionCompat j;
    public final long k;

    public MediaSessionCompat$QueueItem(MediaSession$QueueItem mediaSession$QueueItem, MediaDescriptionCompat mediaDescriptionCompat, long j) {
        if (mediaDescriptionCompat == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if (j == -1) {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }
        this.j = mediaDescriptionCompat;
        this.k = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("MediaSession.QueueItem {Description=");
        sbU.append(this.j);
        sbU.append(", Id=");
        return a.C(sbU, this.k, " }");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.j.writeToParcel(parcel, i);
        parcel.writeLong(this.k);
    }

    public MediaSessionCompat$QueueItem(Parcel parcel) {
        this.j = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.k = parcel.readLong();
    }
}
