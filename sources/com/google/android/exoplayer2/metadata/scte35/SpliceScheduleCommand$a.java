package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class SpliceScheduleCommand$a implements Parcelable$Creator<SpliceScheduleCommand> {
    @Override // android.os.Parcelable$Creator
    public SpliceScheduleCommand createFromParcel(Parcel parcel) {
        return new SpliceScheduleCommand(parcel, null);
    }

    @Override // android.os.Parcelable$Creator
    public SpliceScheduleCommand[] newArray(int i) {
        return new SpliceScheduleCommand[i];
    }
}
