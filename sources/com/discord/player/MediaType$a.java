package com.discord.player;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaType$a implements Parcelable$Creator<MediaType> {
    public MediaType$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @Override // android.os.Parcelable$Creator
    public MediaType createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        m.checkNotNull(string);
        m.checkNotNullExpressionValue(string, "parcel.readString()!!");
        return MediaType.valueOf(string);
    }

    @Override // android.os.Parcelable$Creator
    public MediaType[] newArray(int i) {
        return new MediaType[i];
    }
}
