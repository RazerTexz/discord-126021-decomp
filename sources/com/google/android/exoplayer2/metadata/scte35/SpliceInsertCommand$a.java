package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class SpliceInsertCommand$a implements Parcelable$Creator<SpliceInsertCommand> {
    @Override // android.os.Parcelable$Creator
    public SpliceInsertCommand createFromParcel(Parcel parcel) {
        return new SpliceInsertCommand(parcel, null);
    }

    @Override // android.os.Parcelable$Creator
    public SpliceInsertCommand[] newArray(int i) {
        return new SpliceInsertCommand[i];
    }
}
