package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ParcelableSparseBooleanArray$a implements Parcelable$Creator<ParcelableSparseBooleanArray> {
    @Override // android.os.Parcelable$Creator
    @NonNull
    public ParcelableSparseBooleanArray createFromParcel(@NonNull Parcel parcel) {
        int i = parcel.readInt();
        ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[i];
        parcel.readIntArray(iArr);
        parcel.readBooleanArray(zArr);
        for (int i2 = 0; i2 < i; i2++) {
            parcelableSparseBooleanArray.put(iArr[i2], zArr[i2]);
        }
        return parcelableSparseBooleanArray;
    }

    @Override // android.os.Parcelable$Creator
    @NonNull
    public ParcelableSparseBooleanArray[] newArray(int i) {
        return new ParcelableSparseBooleanArray[i];
    }
}
