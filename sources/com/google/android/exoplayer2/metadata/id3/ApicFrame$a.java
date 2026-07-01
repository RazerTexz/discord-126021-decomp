package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class ApicFrame$a implements Parcelable$Creator<ApicFrame> {
    @Override // android.os.Parcelable$Creator
    public ApicFrame createFromParcel(Parcel parcel) {
        return new ApicFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public ApicFrame[] newArray(int i) {
        return new ApicFrame[i];
    }
}
