package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class InternalFrame$a implements Parcelable$Creator<InternalFrame> {
    @Override // android.os.Parcelable$Creator
    public InternalFrame createFromParcel(Parcel parcel) {
        return new InternalFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public InternalFrame[] newArray(int i) {
        return new InternalFrame[i];
    }
}
