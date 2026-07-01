package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView$SavedState$a implements Parcelable$Creator<LottieAnimationView$SavedState> {
    @Override // android.os.Parcelable$Creator
    public LottieAnimationView$SavedState createFromParcel(Parcel parcel) {
        return new LottieAnimationView$SavedState(parcel, null);
    }

    @Override // android.os.Parcelable$Creator
    public LottieAnimationView$SavedState[] newArray(int i) {
        return new LottieAnimationView$SavedState[i];
    }
}
