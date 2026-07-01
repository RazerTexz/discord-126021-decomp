package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class DrmInitData$a implements Parcelable$Creator<DrmInitData> {
    @Override // android.os.Parcelable$Creator
    public DrmInitData createFromParcel(Parcel parcel) {
        return new DrmInitData(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public DrmInitData[] newArray(int i) {
        return new DrmInitData[i];
    }
}
