package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class IcyInfo$a implements Parcelable$Creator<IcyInfo> {
    @Override // android.os.Parcelable$Creator
    public IcyInfo createFromParcel(Parcel parcel) {
        return new IcyInfo(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public IcyInfo[] newArray(int i) {
        return new IcyInfo[i];
    }
}
