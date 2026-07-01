package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class MdtaMetadataEntry$a implements Parcelable$Creator<MdtaMetadataEntry> {
    @Override // android.os.Parcelable$Creator
    public MdtaMetadataEntry createFromParcel(Parcel parcel) {
        return new MdtaMetadataEntry(parcel, null);
    }

    @Override // android.os.Parcelable$Creator
    public MdtaMetadataEntry[] newArray(int i) {
        return new MdtaMetadataEntry[i];
    }
}
