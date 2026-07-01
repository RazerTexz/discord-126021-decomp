package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class PictureFrame$a implements Parcelable$Creator<PictureFrame> {
    @Override // android.os.Parcelable$Creator
    public PictureFrame createFromParcel(Parcel parcel) {
        return new PictureFrame(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public PictureFrame[] newArray(int i) {
        return new PictureFrame[i];
    }
}
