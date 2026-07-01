package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class IcyHeaders$a implements Parcelable$Creator<IcyHeaders> {
    @Override // android.os.Parcelable$Creator
    public IcyHeaders createFromParcel(Parcel parcel) {
        return new IcyHeaders(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public IcyHeaders[] newArray(int i) {
        return new IcyHeaders[i];
    }
}
