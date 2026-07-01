package com.google.android.material.stateful;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendableSavedState$a implements Parcelable$ClassLoaderCreator<ExtendableSavedState> {
    @Override // android.os.Parcelable$ClassLoaderCreator
    @NonNull
    public ExtendableSavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        return new ExtendableSavedState(parcel, classLoader, null);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object[] newArray(int i) {
        return new ExtendableSavedState[i];
    }

    @Override // android.os.Parcelable$Creator
    @Nullable
    public Object createFromParcel(@NonNull Parcel parcel) {
        return new ExtendableSavedState(parcel, null, null);
    }
}
