package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class MlltFrame$a implements Parcelable$Creator<MlltFrame> {
    @Override // android.os.Parcelable$Creator
    public MlltFrame createFromParcel(Parcel parcel) {
        return new MlltFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public MlltFrame[] newArray(int i) {
        return new MlltFrame[i];
    }
}
