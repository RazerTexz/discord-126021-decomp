package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ParcelableSparseArray$a implements Parcelable$ClassLoaderCreator<ParcelableSparseArray> {
    @Override // android.os.Parcelable$ClassLoaderCreator
    @NonNull
    public ParcelableSparseArray createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        return new ParcelableSparseArray(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public Object[] newArray(int i) {
        return new ParcelableSparseArray[i];
    }

    @Override // android.os.Parcelable$Creator
    @Nullable
    public Object createFromParcel(@NonNull Parcel parcel) {
        return new ParcelableSparseArray(parcel, null);
    }
}
