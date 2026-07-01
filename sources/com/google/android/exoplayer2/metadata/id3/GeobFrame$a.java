package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class GeobFrame$a implements Parcelable$Creator<GeobFrame> {
    @Override // android.os.Parcelable$Creator
    public GeobFrame createFromParcel(Parcel parcel) {
        return new GeobFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public GeobFrame[] newArray(int i) {
        return new GeobFrame[i];
    }
}
