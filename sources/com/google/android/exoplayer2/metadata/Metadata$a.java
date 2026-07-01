package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class Metadata$a implements Parcelable$Creator<Metadata> {
    @Override // android.os.Parcelable$Creator
    public Metadata createFromParcel(Parcel parcel) {
        return new Metadata(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public Metadata[] newArray(int i) {
        return new Metadata[i];
    }
}
