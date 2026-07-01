package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class SmtaMetadataEntry$a implements Parcelable$Creator<SmtaMetadataEntry> {
    @Override // android.os.Parcelable$Creator
    public SmtaMetadataEntry createFromParcel(Parcel parcel) {
        return new SmtaMetadataEntry(parcel, (SmtaMetadataEntry$a) null);
    }

    @Override // android.os.Parcelable$Creator
    public SmtaMetadataEntry[] newArray(int i) {
        return new SmtaMetadataEntry[i];
    }
}
