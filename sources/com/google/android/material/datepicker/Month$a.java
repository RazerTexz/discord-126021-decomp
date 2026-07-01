package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class Month$a implements Parcelable$Creator<Month> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public Month createFromParcel(@NonNull Parcel parcel) {
        return Month.g(parcel.readInt(), parcel.readInt());
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Month[] newArray(int i) {
        return new Month[i];
    }
}
