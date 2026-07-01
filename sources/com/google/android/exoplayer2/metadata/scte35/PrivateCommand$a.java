package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class PrivateCommand$a implements Parcelable$Creator<PrivateCommand> {
    @Override // android.os.Parcelable$Creator
    public PrivateCommand createFromParcel(Parcel parcel) {
        return new PrivateCommand(parcel, null);
    }

    @Override // android.os.Parcelable$Creator
    public PrivateCommand[] newArray(int i) {
        return new PrivateCommand[i];
    }
}
