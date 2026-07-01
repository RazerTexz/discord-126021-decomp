package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class TimeSignalCommand$a implements Parcelable$Creator<TimeSignalCommand> {
    @Override // android.os.Parcelable$Creator
    public TimeSignalCommand createFromParcel(Parcel parcel) {
        return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
    }

    @Override // android.os.Parcelable$Creator
    public TimeSignalCommand[] newArray(int i) {
        return new TimeSignalCommand[i];
    }
}
