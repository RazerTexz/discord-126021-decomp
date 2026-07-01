package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior$SavedState$a implements Parcelable$ClassLoaderCreator<BottomSheetBehavior$SavedState> {
    @Override // android.os.Parcelable$ClassLoaderCreator
    @NonNull
    public BottomSheetBehavior$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        return new BottomSheetBehavior$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object[] newArray(int i) {
        return new BottomSheetBehavior$SavedState[i];
    }

    @Override // android.os.Parcelable$Creator
    @Nullable
    public Object createFromParcel(@NonNull Parcel parcel) {
        return new BottomSheetBehavior$SavedState(parcel, (ClassLoader) null);
    }
}
