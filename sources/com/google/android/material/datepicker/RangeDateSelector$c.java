package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class RangeDateSelector$c implements Parcelable$Creator<RangeDateSelector> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
        RangeDateSelector rangeDateSelector = new RangeDateSelector();
        RangeDateSelector.access$302(rangeDateSelector, (Long) parcel.readValue(Long.class.getClassLoader()));
        RangeDateSelector.access$402(rangeDateSelector, (Long) parcel.readValue(Long.class.getClassLoader()));
        return rangeDateSelector;
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public RangeDateSelector[] newArray(int i) {
        return new RangeDateSelector[i];
    }
}
