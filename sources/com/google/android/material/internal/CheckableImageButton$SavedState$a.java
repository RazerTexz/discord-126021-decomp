package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class CheckableImageButton$SavedState$a implements Parcelable$ClassLoaderCreator<CheckableImageButton$SavedState> {
    @Override // android.os.Parcelable$ClassLoaderCreator
    @NonNull
    public CheckableImageButton$SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        return new CheckableImageButton$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object[] newArray(int i) {
        return new CheckableImageButton$SavedState[i];
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object createFromParcel(@NonNull Parcel parcel) {
        return new CheckableImageButton$SavedState(parcel, null);
    }
}
