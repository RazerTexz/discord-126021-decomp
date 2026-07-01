package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
public class RangeSlider$RangeSliderState extends AbsSavedState {
    public static final Parcelable$Creator<RangeSlider$RangeSliderState> CREATOR = new RangeSlider$RangeSliderState$a();
    public float j;
    public int k;

    public RangeSlider$RangeSliderState(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.j);
        parcel.writeInt(this.k);
    }

    public RangeSlider$RangeSliderState(Parcel parcel, RangeSlider$a rangeSlider$a) {
        super(parcel.readParcelable(RangeSlider$RangeSliderState.class.getClassLoader()));
        this.j = parcel.readFloat();
        this.k = parcel.readInt();
    }
}
