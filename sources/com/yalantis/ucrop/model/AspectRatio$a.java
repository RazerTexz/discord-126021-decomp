package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class AspectRatio$a implements Parcelable$Creator<AspectRatio> {
    @Override // android.os.Parcelable$Creator
    public AspectRatio createFromParcel(Parcel parcel) {
        return new AspectRatio(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public AspectRatio[] newArray(int i) {
        return new AspectRatio[i];
    }
}
