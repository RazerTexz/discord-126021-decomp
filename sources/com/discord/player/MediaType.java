package com.discord.player;

import android.os.Parcel;
import android.os.Parcelable;
import d0.z.d.m;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum MediaType implements Parcelable {
    VIDEO,
    GIFV;

    public static final MediaType$a CREATOR = new MediaType$a(null);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(name());
    }
}
