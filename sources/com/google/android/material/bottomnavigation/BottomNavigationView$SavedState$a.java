package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationView$SavedState$a implements Parcelable$ClassLoaderCreator<BottomNavigationView$SavedState> {
    @Override // android.os.Parcelable$ClassLoaderCreator
    @NonNull
    public BottomNavigationView$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        return new BottomNavigationView$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object[] newArray(int i) {
        return new BottomNavigationView$SavedState[i];
    }

    @Override // android.os.Parcelable$Creator
    @Nullable
    public Object createFromParcel(@NonNull Parcel parcel) {
        return new BottomNavigationView$SavedState(parcel, null);
    }
}
