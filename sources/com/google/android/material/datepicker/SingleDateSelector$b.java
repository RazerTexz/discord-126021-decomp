package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class SingleDateSelector$b implements Parcelable$Creator<SingleDateSelector> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
        SingleDateSelector singleDateSelector = new SingleDateSelector();
        SingleDateSelector.access$102(singleDateSelector, (Long) parcel.readValue(Long.class.getClassLoader()));
        return singleDateSelector;
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public SingleDateSelector[] newArray(int i) {
        return new SingleDateSelector[i];
    }
}
