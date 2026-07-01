package com.discord.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MediaSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MediaSource implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Uri progressiveMediaUri;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final String featureTag;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final MediaType mediaType;

    /* JADX INFO: renamed from: com.discord.player.MediaSource$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MediaSource.kt */
    public static final class Companion implements Parcelable.Creator<MediaSource> {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @Override // android.os.Parcelable.Creator
        public MediaSource createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            Parcelable parcelable = parcel.readParcelable(Uri.class.getClassLoader());
            Intrinsics3.checkNotNull(parcelable);
            String string = parcel.readString();
            Intrinsics3.checkNotNull(string);
            Intrinsics3.checkNotNullExpressionValue(string, "parcel.readString()!!");
            Parcelable parcelable2 = parcel.readParcelable(MediaType.class.getClassLoader());
            Intrinsics3.checkNotNull(parcelable2);
            return new MediaSource((Uri) parcelable, string, (MediaType) parcelable2);
        }

        @Override // android.os.Parcelable.Creator
        public MediaSource[] newArray(int i) {
            return new MediaSource[i];
        }
    }

    public MediaSource(Uri uri, String str, MediaType mediaType) {
        Intrinsics3.checkNotNullParameter(uri, "progressiveMediaUri");
        Intrinsics3.checkNotNullParameter(str, "featureTag");
        Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
        this.progressiveMediaUri = uri;
        this.featureTag = str;
        this.mediaType = mediaType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaSource)) {
            return false;
        }
        MediaSource mediaSource = (MediaSource) other;
        return Intrinsics3.areEqual(this.progressiveMediaUri, mediaSource.progressiveMediaUri) && Intrinsics3.areEqual(this.featureTag, mediaSource.featureTag) && Intrinsics3.areEqual(this.mediaType, mediaSource.mediaType);
    }

    public int hashCode() {
        Uri uri = this.progressiveMediaUri;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        String str = this.featureTag;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        MediaType mediaType = this.mediaType;
        return iHashCode2 + (mediaType != null ? mediaType.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MediaSource(progressiveMediaUri=");
        sbU.append(this.progressiveMediaUri);
        sbU.append(", featureTag=");
        sbU.append(this.featureTag);
        sbU.append(", mediaType=");
        sbU.append(this.mediaType);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.progressiveMediaUri, flags);
        parcel.writeString(this.featureTag);
        parcel.writeParcelable(this.mediaType, flags);
    }
}
