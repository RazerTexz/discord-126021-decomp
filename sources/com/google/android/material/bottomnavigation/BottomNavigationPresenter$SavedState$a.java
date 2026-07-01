package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationPresenter$SavedState$a implements Parcelable$Creator<BottomNavigationPresenter$SavedState> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public BottomNavigationPresenter$SavedState createFromParcel(@NonNull Parcel parcel) {
        return new BottomNavigationPresenter$SavedState(parcel);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public BottomNavigationPresenter$SavedState[] newArray(int i) {
        return new BottomNavigationPresenter$SavedState[i];
    }
}
