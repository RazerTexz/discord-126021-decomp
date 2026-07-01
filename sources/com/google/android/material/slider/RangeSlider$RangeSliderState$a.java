package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes3.dex */
public class RangeSlider$RangeSliderState$a implements Parcelable$Creator<RangeSlider$RangeSliderState> {
    @Override // android.os.Parcelable$Creator
    public RangeSlider$RangeSliderState createFromParcel(Parcel parcel) {
        return new RangeSlider$RangeSliderState(parcel, null);
    }

    @Override // android.os.Parcelable$Creator
    public RangeSlider$RangeSliderState[] newArray(int i) {
        return new RangeSlider$RangeSliderState[i];
    }
}
