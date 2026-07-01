package com.discord.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MediaSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSource$a implements Parcelable$Creator<MediaSource> {
    public MediaSource$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @Override // android.os.Parcelable$Creator
    public MediaSource createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "parcel");
        m.checkNotNullParameter(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(Uri.class.getClassLoader());
        m.checkNotNull(parcelable);
        String string = parcel.readString();
        m.checkNotNull(string);
        m.checkNotNullExpressionValue(string, "parcel.readString()!!");
        Parcelable parcelable2 = parcel.readParcelable(MediaType.class.getClassLoader());
        m.checkNotNull(parcelable2);
        return new MediaSource((Uri) parcelable, string, (MediaType) parcelable2);
    }

    @Override // android.os.Parcelable$Creator
    public MediaSource[] newArray(int i) {
        return new MediaSource[i];
    }
}
