package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class DrmInitData$SchemeData$a implements Parcelable$Creator<DrmInitData$SchemeData> {
    @Override // android.os.Parcelable$Creator
    public DrmInitData$SchemeData createFromParcel(Parcel parcel) {
        return new DrmInitData$SchemeData(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public DrmInitData$SchemeData[] newArray(int i) {
        return new DrmInitData$SchemeData[i];
    }
}
