package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class BaseSlider$SliderState$a implements Parcelable$Creator<BaseSlider$SliderState> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public BaseSlider$SliderState createFromParcel(@NonNull Parcel parcel) {
        return new BaseSlider$SliderState(parcel, null);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public BaseSlider$SliderState[] newArray(int i) {
        return new BaseSlider$SliderState[i];
    }
}
