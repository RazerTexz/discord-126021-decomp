package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class CalendarConstraints$a implements Parcelable$Creator<CalendarConstraints> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
        return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (CalendarConstraints$DateValidator) parcel.readParcelable(CalendarConstraints$DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public CalendarConstraints[] newArray(int i) {
        return new CalendarConstraints[i];
    }
}
