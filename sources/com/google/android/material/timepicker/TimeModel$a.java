package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class TimeModel$a implements Parcelable$Creator<TimeModel> {
    @Override // android.os.Parcelable$Creator
    public TimeModel createFromParcel(Parcel parcel) {
        return new TimeModel(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    @Override // android.os.Parcelable$Creator
    public TimeModel[] newArray(int i) {
        return new TimeModel[i];
    }
}
