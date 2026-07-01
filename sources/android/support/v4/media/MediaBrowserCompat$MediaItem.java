package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.browse.MediaBrowser$MediaItem;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable$Creator<MediaBrowserCompat$MediaItem> CREATOR = new MediaBrowserCompat$MediaItem$a();
    public final int j;
    public final MediaDescriptionCompat k;

    public MediaBrowserCompat$MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
        if (mediaDescriptionCompat == null) {
            throw new IllegalArgumentException("description cannot be null");
        }
        if (TextUtils.isEmpty(mediaDescriptionCompat.j)) {
            throw new IllegalArgumentException("description must have a non-empty media id");
        }
        this.j = i;
        this.k = mediaDescriptionCompat;
    }

    public static List<MediaBrowserCompat$MediaItem> a(List<?> list) {
        MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            if (obj != null) {
                MediaBrowser$MediaItem mediaBrowser$MediaItem = (MediaBrowser$MediaItem) obj;
                mediaBrowserCompat$MediaItem = new MediaBrowserCompat$MediaItem(MediaDescriptionCompat.a(MediaBrowserCompat$a.a(mediaBrowser$MediaItem)), MediaBrowserCompat$a.b(mediaBrowser$MediaItem));
            } else {
                mediaBrowserCompat$MediaItem = null;
            }
            arrayList.add(mediaBrowserCompat$MediaItem);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        return "MediaItem{mFlags=" + this.j + ", mDescription=" + this.k + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        this.k.writeToParcel(parcel, i);
    }

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.j = parcel.readInt();
        this.k = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }
}
