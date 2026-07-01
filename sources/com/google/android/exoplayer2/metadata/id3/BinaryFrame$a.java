package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class BinaryFrame$a implements Parcelable$Creator<BinaryFrame> {
    @Override // android.os.Parcelable$Creator
    public BinaryFrame createFromParcel(Parcel parcel) {
        return new BinaryFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public BinaryFrame[] newArray(int i) {
        return new BinaryFrame[i];
    }
}
