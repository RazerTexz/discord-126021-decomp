package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$BaseBehavior$SavedState$a implements Parcelable$ClassLoaderCreator<AppBarLayout$BaseBehavior$SavedState> {
    @Override // android.os.Parcelable$ClassLoaderCreator
    @NonNull
    public AppBarLayout$BaseBehavior$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        return new AppBarLayout$BaseBehavior$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object[] newArray(int i) {
        return new AppBarLayout$BaseBehavior$SavedState[i];
    }

    @Override // android.os.Parcelable$Creator
    @Nullable
    public Object createFromParcel(@NonNull Parcel parcel) {
        return new AppBarLayout$BaseBehavior$SavedState(parcel, null);
    }
}
