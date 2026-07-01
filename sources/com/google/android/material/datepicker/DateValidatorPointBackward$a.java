package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class DateValidatorPointBackward$a implements Parcelable$Creator<DateValidatorPointBackward> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public DateValidatorPointBackward createFromParcel(@NonNull Parcel parcel) {
        return new DateValidatorPointBackward(parcel.readLong(), null);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public DateValidatorPointBackward[] newArray(int i) {
        return new DateValidatorPointBackward[i];
    }
}
