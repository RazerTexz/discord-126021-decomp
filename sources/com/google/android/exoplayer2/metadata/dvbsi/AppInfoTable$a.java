package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class AppInfoTable$a implements Parcelable$Creator<AppInfoTable> {
    @Override // android.os.Parcelable$Creator
    public AppInfoTable createFromParcel(Parcel parcel) {
        String string = parcel.readString();
        Objects.requireNonNull(string);
        return new AppInfoTable(parcel.readInt(), string);
    }

    @Override // android.os.Parcelable$Creator
    public AppInfoTable[] newArray(int i) {
        return new AppInfoTable[i];
    }
}
