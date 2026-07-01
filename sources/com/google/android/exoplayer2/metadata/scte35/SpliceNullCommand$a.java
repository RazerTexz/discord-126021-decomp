package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class SpliceNullCommand$a implements Parcelable$Creator<SpliceNullCommand> {
    @Override // android.os.Parcelable$Creator
    public SpliceNullCommand createFromParcel(Parcel parcel) {
        return new SpliceNullCommand();
    }

    @Override // android.os.Parcelable$Creator
    public SpliceNullCommand[] newArray(int i) {
        return new SpliceNullCommand[i];
    }
}
