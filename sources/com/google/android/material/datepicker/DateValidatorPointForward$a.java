package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class DateValidatorPointForward$a implements Parcelable$Creator<DateValidatorPointForward> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public DateValidatorPointForward createFromParcel(@NonNull Parcel parcel) {
        return new DateValidatorPointForward(parcel.readLong(), null);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public DateValidatorPointForward[] newArray(int i) {
        return new DateValidatorPointForward[i];
    }
}
