package com.discord.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(parcel, "parcel");
            C12238m.checkNotNullParameter(parcel, "parcel");
            Parcelable parcelable = parcel.readParcelable(Uri.class.getClassLoader());
            C12238m.checkNotNull(parcelable);
            String string = parcel.readString();
            C12238m.checkNotNull(string);
            C12238m.checkNotNullExpressionValue(string, "parcel.readString()!!");
            Parcelable parcelable2 = parcel.readParcelable(MediaType.class.getClassLoader());
            C12238m.checkNotNull(parcelable2);
            return new MediaSource((Uri) parcelable, string, (MediaType) parcelable2);
        }

        @Override // android.os.Parcelable.Creator
        public MediaSource[] newArray(int i) {
            return new MediaSource[i];
        }
    }

    public MediaSource(Uri uri, String str, MediaType mediaType) {
        C12238m.checkNotNullParameter(uri, "progressiveMediaUri");
        C12238m.checkNotNullParameter(str, "featureTag");
        C12238m.checkNotNullParameter(mediaType, "mediaType");
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
        return C12238m.areEqual(this.progressiveMediaUri, mediaSource.progressiveMediaUri) && C12238m.areEqual(this.featureTag, mediaSource.featureTag) && C12238m.areEqual(this.mediaType, mediaSource.mediaType);
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
        StringBuilder sbM833U = C1643a.m833U("MediaSource(progressiveMediaUri=");
        sbM833U.append(this.progressiveMediaUri);
        sbM833U.append(", featureTag=");
        sbM833U.append(this.featureTag);
        sbM833U.append(", mediaType=");
        sbM833U.append(this.mediaType);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.progressiveMediaUri, flags);
        parcel.writeString(this.featureTag);
        parcel.writeParcelable(this.mediaType, flags);
    }
}
