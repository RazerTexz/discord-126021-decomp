package com.lytefast.flexinput.model;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: compiled from: Media.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Media$a implements Parcelable$Creator<Media> {
    @Override // android.os.Parcelable$Creator
    public Media createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "parcel");
        return new Media(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public Media[] newArray(int i) {
        return new Media[i];
    }
}
