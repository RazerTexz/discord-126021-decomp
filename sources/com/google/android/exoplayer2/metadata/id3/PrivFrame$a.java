package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class PrivFrame$a implements Parcelable$Creator<PrivFrame> {
    @Override // android.os.Parcelable$Creator
    public PrivFrame createFromParcel(Parcel parcel) {
        return new PrivFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public PrivFrame[] newArray(int i) {
        return new PrivFrame[i];
    }
}
