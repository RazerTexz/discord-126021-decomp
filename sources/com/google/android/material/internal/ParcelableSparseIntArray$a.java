package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ParcelableSparseIntArray$a implements Parcelable$Creator<ParcelableSparseIntArray> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public ParcelableSparseIntArray createFromParcel(@NonNull Parcel parcel) {
        int i = parcel.readInt();
        ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(i);
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        parcel.readIntArray(iArr);
        parcel.readIntArray(iArr2);
        for (int i2 = 0; i2 < i; i2++) {
            parcelableSparseIntArray.put(iArr[i2], iArr2[i2]);
        }
        return parcelableSparseIntArray;
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public ParcelableSparseIntArray[] newArray(int i) {
        return new ParcelableSparseIntArray[i];
    }
}
