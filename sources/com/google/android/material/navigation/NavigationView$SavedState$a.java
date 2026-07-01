package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationView$SavedState$a implements Parcelable$ClassLoaderCreator<NavigationView$SavedState> {
    @Override // android.os.Parcelable$ClassLoaderCreator
    @NonNull
    public NavigationView$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        return new NavigationView$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object[] newArray(int i) {
        return new NavigationView$SavedState[i];
    }

    @Override // android.os.Parcelable$Creator
    @Nullable
    public Object createFromParcel(@NonNull Parcel parcel) {
        return new NavigationView$SavedState(parcel, null);
    }
}
